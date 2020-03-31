package com.blg.demo.jpa.dao.repository;

import com.blg.demo.jpa.model.$Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @Auther: panhongtong
 * @Date: 2020/3/31 17:04
 * @Description:
 */
public interface GirlRepository extends JpaRepository<$Girl,String> {

    Optional<$Girl> findById(String id);

    $Girl save($Girl girl);

}
