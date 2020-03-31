package com.blg.demo.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 16:33
 * @Description:
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@EnableJpaRepositories
public class JPAApplication {
    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
        System.out.println("start ----- ok");
    }
}
