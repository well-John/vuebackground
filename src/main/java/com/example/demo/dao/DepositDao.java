package com.example.demo.dao;


import com.example.demo.entity.DepositEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:37:14
 */
@Mapper
public interface DepositDao{

    DepositEntity queryObject(Integer id);

    List<DepositEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(DepositEntity tdSupplier);

    void update(DepositEntity tdSupplier);

    void updateSelective(DepositEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
