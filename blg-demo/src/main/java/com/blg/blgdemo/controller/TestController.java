package com.blg.blgdemo.controller;

import com.blg.blgdemo.service.TestService;
import com.blg.blgdemo.vo.reqvo.TestReqVO;
import com.blg.framework.utils.Webs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping(value = "testToken")
    public String testToken(@RequestBody TestReqVO reqVO) {
        testService.testToken(reqVO);
        return "依旧解决中文乱码";
    }
}
