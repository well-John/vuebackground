package com.example.demo.service;


import com.example.demo.dao.ForderDao;
import com.example.demo.entity.ForderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-02-27 11:20:25
 */
@Service("forderService")
public class ForderService {

    @Autowired
    private ForderDao forderDao;
	
	public ForderEntity queryObject(Integer id){
        return forderDao.queryObject(id);
	}
	
    public List<ForderEntity> queryList(Map<String, Object> map){return forderDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return forderDao.queryTotal(map);}
	
	public  void save(ForderEntity forder){forderDao.save(forder);}
	
    public 	void update(ForderEntity forder){forderDao.update(forder);}

	public void updateSelective(ForderEntity forder){forderDao.updateSelective(forder);}
	
	public void delete(Integer id){forderDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){forderDao.deleteBatch(ids);}
}
