package com.example.demo.service;


import com.example.demo.dao.TeacherDao;
import com.example.demo.entity.TeacherEntity;
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
@Service("teacherService")
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;
	
	public TeacherEntity queryObject(Integer id){
        return teacherDao.queryObject(id);
	}
	
    public List<TeacherEntity> queryList(Map<String, Object> map){return teacherDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return teacherDao.queryTotal(map);}
	
	public  void save(TeacherEntity teacher){teacherDao.save(teacher);}
	
    public 	void update(TeacherEntity teacher){teacherDao.update(teacher);}

	public void updateSelective(TeacherEntity teacher){teacherDao.updateSelective(teacher);}
	
	public void delete(Integer id){teacherDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){teacherDao.deleteBatch(ids);}

    public boolean forbidden(Integer id) {
        return teacherDao.forbidden(id) == 1 ? true : false;
    }

    public boolean recover(Integer id) {
        return teacherDao.recover(id) == 1 ? true : false;
    }
}
