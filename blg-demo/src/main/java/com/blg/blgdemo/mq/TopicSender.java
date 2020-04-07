package com.blg.blgdemo.mq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author panhongtong
 * @date 2020/2/18
 * @description Topic生产者
 */
@Component
public class TopicSender implements RabbitTemplate.ConfirmCallback  {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String msg = "My测试MQ";
        send(msg);
    }

    private void send(String name) {
        JSONObject jsonObect = new JSONObject();
        jsonObect.put("name", name);
        String msg = jsonObect.toJSONString();
        System.out.println("msg:" + msg);
        // 封装消息
        Message message = MessageBuilder.withBody(msg.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8").setMessageId(name).build();
        // 构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(name);
        // 发送消息
        this.rabbitTemplate.setMandatory(true);
        this.rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend("exchange", "topic.testMQT", message, correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String orderId = correlationData.getId(); //id 都是相同的哦  全局ID
        System.out.println("消息id:" + correlationData.getId());
        int count = 5;
        if (ack) { //消息发送成功
            System.out.println("消息发送确认成功");
        } else {
            while (count-- >0){
                //重试机制
                send(orderId);
                System.out.println("消息发送确认失败:" + cause);
            }
        }
    }
}
