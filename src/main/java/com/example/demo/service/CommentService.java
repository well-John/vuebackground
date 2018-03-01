package com.example.demo.service;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
@Service("commentService")
public class CommentService {

    @Autowired
    private CommentDao commentDao;
	
	public CommentEntity queryObject(Integer id){
        return commentDao.queryObject(id);
	}
	
    public	List<CommentEntity> queryList(Map<String, Object> map){return commentDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return commentDao.queryTotal(map);}
	
	public  void save(CommentEntity comment){commentDao.save(comment);}
	
    public 	void update(CommentEntity comment){commentDao.update(comment);}

	public void updateSelective(CommentEntity comment){commentDao.updateSelective(comment);}
	
	public void delete(Integer id){commentDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){commentDao.deleteBatch(ids);}
}
