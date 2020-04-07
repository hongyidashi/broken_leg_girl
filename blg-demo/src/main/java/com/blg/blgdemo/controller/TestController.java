package com.blg.blgdemo.controller;

import com.blg.api.annotation.ExtApiToken;
import com.blg.blgdemo.mq.TopicSender;
import com.blg.blgdemo.service.TestService;
import com.blg.blgdemo.vo.reqvo.TestReqVO;
import com.blg.framework.utils.Webs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 15:47
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String testController() {
        return Webs.getRequest().getRequestURI() + "------" + Webs.getRequest().getMethod() + "中文乱码咋办啊";
    }

    @Autowired
    private ApplicationContext applicationContext;

    @ExtApiToken
    @PostMapping(value = "testToken")
    public String testToken(@RequestBody TestReqVO reqVO) {
        testService.testToken(reqVO);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        return "中文应该没问题吧没问题吧";
    }

    @GetMapping("testMQT")
    public String testMQT() {
        return testService.testMQT();
    }


    @GetMapping("testMq")
    public String myTestMq() {
        return testService.myTestMq();
    }
}
