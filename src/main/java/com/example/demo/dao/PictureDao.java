package com.example.demo.dao;


import com.example.demo.entity.PictureEntity;
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
public interface PictureDao{

    PictureEntity queryObject(Integer id);

    List<PictureEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(PictureEntity tdSupplier);

    void update(PictureEntity tdSupplier);

    void updateSelective(PictureEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
