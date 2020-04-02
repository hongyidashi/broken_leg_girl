package com.blg.framework.config;

import com.blg.framework.jpa.support.CommentWriter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/1 09:02
 * @Description:
 */
@Configuration
//配置了扫描hibernate实体和repository的路径
@EnableJpaRepositories(basePackages = "${"+ Constants.APP_BASE_PACKAGE+"}.**.dao")
@EntityScan("${"+ Constants.APP_BASE_PACKAGE+"}.**.model")
//配置扫描组件的路径
@ComponentScan(basePackages = "${"+ Constants.APP_BASE_PACKAGE+"}")
public class MainConfig {

    @Bean
    public CommentWriter commentWriter(){
        return new CommentWriter();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    @Primary
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }
}
