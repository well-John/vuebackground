package com.example.demo.service;

import com.example.demo.dao.TeacherDesireDao;
import com.example.demo.entity.TeacherDesireEntity;
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
@Service("teacherDesireService")
public class TeacherDesireService {

    @Autowired
    private TeacherDesireDao teacherDesireDao;
	
	public TeacherDesireEntity queryObject(Integer id){
        return teacherDesireDao.queryObject(id);
	}
	
    public	List<TeacherDesireEntity> queryList(Map<String, Object> map){return teacherDesireDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return teacherDesireDao.queryTotal(map);}
	
	public  void save(TeacherDesireEntity teacherDesire){teacherDesireDao.save(teacherDesire);}
	
    public 	void update(TeacherDesireEntity teacherDesire){teacherDesireDao.update(teacherDesire);}

	public void updateSelective(TeacherDesireEntity teacherDesire){teacherDesireDao.updateSelective(teacherDesire);}
	
	public void delete(Integer id){teacherDesireDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){teacherDesireDao.deleteBatch(ids);}
}
