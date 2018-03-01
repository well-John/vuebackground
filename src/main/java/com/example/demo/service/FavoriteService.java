package com.example.demo.service;


import com.example.demo.dao.FavoriteDao;
import com.example.demo.entity.FavoriteEntity;
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
@Service("favoriteService")
public class FavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;
	
	public FavoriteEntity queryObject(Integer id){
        return favoriteDao.queryObject(id);
	}
	
    public List<FavoriteEntity> queryList(Map<String, Object> map){return favoriteDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return favoriteDao.queryTotal(map);}
	
	public  void save(FavoriteEntity favorite){favoriteDao.save(favorite);}
	
    public 	void update(FavoriteEntity favorite){favoriteDao.update(favorite);}

	public void updateSelective(FavoriteEntity favorite){favoriteDao.updateSelective(favorite);}
	
	public void delete(Integer id){favoriteDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){favoriteDao.deleteBatch(ids);}
}
