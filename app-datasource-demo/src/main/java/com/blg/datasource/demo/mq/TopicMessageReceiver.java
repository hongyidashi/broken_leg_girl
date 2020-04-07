package com.blg.datasource.demo.mq;

import com.alibaba.fastjson.JSONObject;
import com.blg.datasource.demo.service.TestService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class TopicMessageReceiver {

    @Autowired
    TestService testService;

    @RabbitListener(queues = "topic.testMQT")
    public void process(Message message, Channel channel) throws Exception {
        String messageId = message.getMessageProperties().getMessageId();
        System.out.println("消息ID：" + messageId);
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(msg);
        String name = jsonObject.getString("name");
        try {
            testService.testMQT(name);
            System.out.println("channel:"+channel);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            e.printStackTrace();
        }
    }

}