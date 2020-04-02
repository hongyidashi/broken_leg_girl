package com.blg.datasource.demo.service;

import com.blg.datasource.demo.model.$Girl;
import com.jpaquery.core.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: panhongtong
 * @Date: 2020/4/1 09:59
 * @Description:
 */
@Service
@Transactional
public class TestService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String testSave() {
        $Girl girl = new $Girl();
        girl.setName("断腿少女");
        girl.setAge(3);
        entityManager.persist(girl);
        return "OK";
    }

    public String jpaQueue() {
        return Querys.query(query -> {
            $Girl girl = query.from($Girl.class);
            return query.list(entityManager);
        }).toString();
    }

    public String testRedis() {
        redisTemplate.opsForValue().set("testR","断腿少女",5, TimeUnit.MINUTES);
        return redisTemplate.opsForValue().get("testR").toString();
    }

}
