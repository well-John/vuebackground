package com.example.demo.dao;


import com.example.demo.entity.AdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
@Mapper
public interface AdminDao{

    AdminEntity queryObject(Integer id);

    List<AdminEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(AdminEntity tdSupplier);

    void update(AdminEntity tdSupplier);

    void updateSelective(AdminEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    List<AdminEntity> login(@Param("login") String login, @Param("password") String password);
}
