package com.blg.datasource.demo.service;

import com.blg.datasource.demo.dao.BadGirlDao;
import com.blg.datasource.demo.model.$Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    private BadGirlDao badGirlDao;

    public String testSave() {
        $Girl girl = new $Girl();
        girl.setName("断腿少女");
        girl.setAge(3);
        entityManager.persist(girl);
        return "OK";
    }

    public String testMybatis() {
        return badGirlDao.findAll().toString();
    }
}
