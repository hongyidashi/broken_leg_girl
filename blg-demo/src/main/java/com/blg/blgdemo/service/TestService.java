package com.blg.blgdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.blg.blgdemo.mq.TopicSender;
import com.blg.blgdemo.vo.reqvo.TestReqVO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/2 17:29
 * @Description:
 */
@Service
@Slf4j
@Transactional
public class TestService {

    public void testToken(TestReqVO reqVO) {
        String token = reqVO.getToken();
        System.out.println("拿到的token："+token);
    }

    @Autowired
    private TopicSender topicSender;

    public String testMQT() {
        topicSender.send();
        return "应该是成功了吧";
    }
}
