package com.example.demo.dao;


import com.example.demo.entity.CommentEntity;
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
public interface CommentDao{

    CommentEntity queryObject(Integer id);

    List<CommentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(CommentEntity tdSupplier);

    void update(CommentEntity tdSupplier);

    void updateSelective(CommentEntity tdSupplier);

    void delete(Integer id);

    void deleteBatch(Integer[] ids);
}
