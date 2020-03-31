package com.blg.demo.jpa.controller;

import com.blg.demo.jpa.dao.repository.GirlRepository;
import com.blg.demo.jpa.model.$Girl;
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
    private GirlRepository girlRepository;

    @GetMapping("testH")
    public String test() {
        $Girl girl = new $Girl();
        girl.setName("断腿少女");
        girl.setAge(3);
        girlRepository.save(girl);
        return String.valueOf(girlRepository.findAll());
    }
}
