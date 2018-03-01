package com.example.demo.service;


import com.example.demo.dao.AdminDao;
import com.example.demo.entity.AdminEntity;
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
@Service("adminService")
public class AdminService {

    @Autowired
    private AdminDao adminDao;
	
	public AdminEntity queryObject(Integer id){
        return adminDao.queryObject(id);
	}
	
    public List<AdminEntity> queryList(Map<String, Object> map){return adminDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return adminDao.queryTotal(map);}
	
	public  void save(AdminEntity admin){adminDao.save(admin);}
	
    public 	void update(AdminEntity admin){adminDao.update(admin);}

	public void updateSelective(AdminEntity admin){adminDao.updateSelective(admin);}
	
	public void delete(Integer id){adminDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){adminDao.deleteBatch(ids);}

	public AdminEntity login(String login,String password){
		List<AdminEntity> list = adminDao.login(login,password);
		if(list.size()==1){
			return list.get(0);
		}else{
			return null;
		}
	}
}
