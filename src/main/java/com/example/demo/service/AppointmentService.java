package com.example.demo.service;

import com.example.demo.dao.AppointmentDao;
import com.example.demo.entity.AppointmentEntity;
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
@Service("appointmentService")
public class AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;
	
	public AppointmentEntity queryObject(Integer id){
        return appointmentDao.queryObject(id);
	}
	
    public	List<AppointmentEntity> queryList(Map<String, Object> map){return appointmentDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return appointmentDao.queryTotal(map);}
	
	public  void save(AppointmentEntity appointment){appointmentDao.save(appointment);}
	
    public 	void update(AppointmentEntity appointment){appointmentDao.update(appointment);}

	public void updateSelective(AppointmentEntity appointment){appointmentDao.updateSelective(appointment);}
	
	public void delete(Integer id){appointmentDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){appointmentDao.deleteBatch(ids);}
}
