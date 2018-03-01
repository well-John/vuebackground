package com.example.demo.dao;

import com.example.demo.entity.StudentEntity;
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
public interface StudentDao{

    StudentEntity queryObject(Integer id);

    List<StudentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(StudentEntity tdSupplier);

    void update(StudentEntity tdSupplier);

    void updateSelective(StudentEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);

    Integer forbidden(Integer id);

    Integer recover(Integer id);
}
