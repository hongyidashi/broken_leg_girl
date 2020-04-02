package com.blg.blgdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/2 17:57
 * @Description:
 */
@Aspect
@Component
public class TestAOP {

//    @Around("execution(* com.blg.blgdemo.controller.TestController.testToken())")
//    public Object roundAsp(ProceedingJoinPoint pj){
//        System.out.println("前");
//
//        Object proceed = null;
//        try {
//            Object[] args = pj.getArgs();
//            System.out.println("原参数为："+args[0]);
//            args[0]="我好了";
//            System.out.println("修改后入参参数为："+ pj.getArgs()[0]);
//            //如果需要重新设置参数，则调用proceed的有参方法，否则直接调用无参方法即可
//            proceed = pj.proceed(args);
//        } catch (Throwable throwable) {
//            System.out.println("异常");
//            throwable.printStackTrace();
//        }
//
//        System.out.println("后");
//
//        return proceed;
//    }

}
