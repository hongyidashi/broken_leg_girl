package com.blg.demo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/3 11:36
 * @Description:
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    public static final String SERVICE_URL = "http://blg-demo";

    @GetMapping("consumer/test")
    public String getServerURL() {
        return restTemplate.getForObject(SERVICE_URL + "/test", String.class);
    }

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
