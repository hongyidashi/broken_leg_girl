package com.blg.datasource.demo.dao;

import com.blg.datasource.demo.model.$Girl;
import org.springframework.data.jpa.repository.JpaRepository;

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
