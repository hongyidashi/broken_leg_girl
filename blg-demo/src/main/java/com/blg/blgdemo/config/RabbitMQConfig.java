package com.blg.blgdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置类
 */
@Configuration
public class RabbitMQConfig {

    private static Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;

    // Bean默认的name是方法名
    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue("topic.testMQT");
    }

    @Bean
    TopicExchange exchange() {
        // 参数为交换机的名称
        return new TopicExchange("exchange");
    }

    @Bean
    // 如果参数名和上面用到方法名称一样，可以不用写@Qualifier
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.testMQT");
    }

}
