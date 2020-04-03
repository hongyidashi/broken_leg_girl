package com.blg.blgdemo.service;

import com.blg.blgdemo.vo.reqvo.TestReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/2 17:29
 * @Description:
 */
@Service
@Slf4j
public class TestService {

    public void testToken(TestReqVO reqVO) {
        String token = reqVO.getToken();
        System.out.println("拿到的token："+token);
    }
}
