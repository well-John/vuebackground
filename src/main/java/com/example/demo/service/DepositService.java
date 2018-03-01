package com.example.demo.service;


import com.example.demo.dao.DepositDao;
import com.example.demo.entity.DepositEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:37:14
 */
@Service("depositService")
public class DepositService {

    @Autowired
    private DepositDao depositDao;
	
	public DepositEntity queryObject(Integer id){
        return depositDao.queryObject(id);
	}
	
    public	List<DepositEntity> queryList(Map<String, Object> map){return depositDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return depositDao.queryTotal(map);}
	
	public  void save(DepositEntity deposit){depositDao.save(deposit);}
	
    public 	void update(DepositEntity deposit){depositDao.update(deposit);}

	public void updateSelective(DepositEntity deposit){depositDao.updateSelective(deposit);}
	
	public void delete(Integer id){depositDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){depositDao.deleteBatch(ids);}
}
