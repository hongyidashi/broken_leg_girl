package com.blg.datasource.demo.controller;

import com.blg.datasource.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 17:07
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("testH")
    public String test() {
        return testService.testSave();
    }

    @GetMapping("testJ")
    public String testJ() {
        return testService.jpaQueue();
    }

    @GetMapping(value = "testC")
    public String testC() {
        return "中文乱码？？";
    }

    @GetMapping(value = "testR")
    public String testr() {
        return testService.testRedis();
    }
}
