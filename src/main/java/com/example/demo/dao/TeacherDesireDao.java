package com.example.demo.dao;


import com.example.demo.entity.TeacherDesireEntity;
import org.apache.ibatis.annotations.Mapper;

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
public interface TeacherDesireDao{

    TeacherDesireEntity queryObject(Integer id);

    List<TeacherDesireEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TeacherDesireEntity tdSupplier);

    void update(TeacherDesireEntity tdSupplier);

    void updateSelective(TeacherDesireEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
