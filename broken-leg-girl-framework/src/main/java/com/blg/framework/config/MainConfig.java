package com.blg.framework.config;

import com.blg.framework.jpa.support.CommentWriter;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

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
@MapperScan("${"+ Constants.APP_BASE_PACKAGE+"}.**.dao")
public class MainConfig {

    @Bean
    public CommentWriter commentWriter(){
        return new CommentWriter();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    @Primary
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(transactionManager);
        return transactionTemplate;
    }

    private PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

    @Bean("sqlSessionFactoryBean")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        org.apache.ibatis.logging.LogFactory.useSlf4jLogging();
        LogFactory.useSlf4jLogging();
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mapper/*.xml";
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(packageSearchPath);
        sessionFactory.setMapperLocations(resources);
        sessionFactory.setDataSource(dataSource);
        Properties mybatisProperties = new Properties();
        mybatisProperties.put("mapUnderscoreToCamelCase","true");
        sessionFactory.setConfigurationProperties(mybatisProperties);
        return sessionFactory;
    }
}
