package com.blg.datasource.demo.dao;

import com.blg.datasource.demo.model.$BadGirl;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Auther: panhongtong
 * @Date: 2020/4/1 16:15
 * @Description:
 */
@Mapper
public interface BadGirlDao {

    $BadGirl findAll();

}
