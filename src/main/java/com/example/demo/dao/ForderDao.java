package com.example.demo.dao;

import com.example.demo.entity.ForderEntity;
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
public interface ForderDao{

    ForderEntity queryObject(Integer id);

    List<ForderEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ForderEntity tdSupplier);

    void update(ForderEntity tdSupplier);

    void updateSelective(ForderEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
