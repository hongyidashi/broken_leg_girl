package com.blg.datasource.demo.controller;

import com.blg.datasource.demo.model.$Girl;
import com.blg.datasource.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
