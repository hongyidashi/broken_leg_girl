package com.blg.blgdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 15:18
 * @Description:
 */
//如果不带数据库必须加上这句exclude
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class BLGDemo {
    public static void main(String[] args) {
        SpringApplication.run(BLGDemo.class, args);
    }
}
