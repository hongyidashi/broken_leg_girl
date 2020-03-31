package com.blg.blgdemo.controller;

import com.blg.framework.utils.Webs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 15:47
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String testController() {
        return Webs.getRequest().getRequestURI() + "------" + Webs.getRequest().getMethod();
    }
}
