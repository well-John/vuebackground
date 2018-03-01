package com.example.demo.dao;


import com.example.demo.entity.TeacherRequirementEntity;
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
public interface TeacherRequirementDao{

    TeacherRequirementEntity queryObject(Integer id);

    List<TeacherRequirementEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TeacherRequirementEntity tdSupplier);

    void update(TeacherRequirementEntity tdSupplier);

    void updateSelective(TeacherRequirementEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
