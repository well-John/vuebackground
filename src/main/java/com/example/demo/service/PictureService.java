package com.example.demo.service;


import com.example.demo.dao.PictureDao;
import com.example.demo.entity.PictureEntity;
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
@Service("pictureService")
public class PictureService {

    @Autowired
    private PictureDao pictureDao;
	
	public PictureEntity queryObject(Integer id){
        return pictureDao.queryObject(id);
	}
	
    public List<PictureEntity> queryList(Map<String, Object> map){return pictureDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return pictureDao.queryTotal(map);}
	
	public  void save(PictureEntity picture){pictureDao.save(picture);}
	
    public 	void update(PictureEntity picture){pictureDao.update(picture);}

	public void updateSelective(PictureEntity picture){pictureDao.updateSelective(picture);}
	
	public void delete(Integer id){pictureDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){pictureDao.deleteBatch(ids);}
}
