package com.example.demo.dao;

import com.example.demo.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-02-27 11:20:25
 */
@Mapper
public interface TeacherDao{

    TeacherEntity queryObject(Integer id);

    List<TeacherEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TeacherEntity tdSupplier);

    void update(TeacherEntity tdSupplier);

    void updateSelective(TeacherEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    int forbidden(Integer id);

    int recover(Integer id);
}
