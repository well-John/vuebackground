package com.example.demo.dao;


import com.example.demo.entity.FavoriteEntity;
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
public interface FavoriteDao{

    FavoriteEntity queryObject(Integer id);

    List<FavoriteEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(FavoriteEntity tdSupplier);

    void update(FavoriteEntity tdSupplier);

    void updateSelective(FavoriteEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
