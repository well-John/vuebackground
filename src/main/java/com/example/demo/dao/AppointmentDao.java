package com.example.demo.dao;


import com.example.demo.entity.AppointmentEntity;
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
public interface AppointmentDao{

    AppointmentEntity queryObject(Integer id);

    List<AppointmentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(AppointmentEntity tdSupplier);

    void update(AppointmentEntity tdSupplier);

    void updateSelective(AppointmentEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
