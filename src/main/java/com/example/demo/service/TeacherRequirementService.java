package com.example.demo.service;

import com.example.demo.dao.TeacherRequirementDao;
import com.example.demo.entity.TeacherRequirementEntity;
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
@Service("teacherRequirementService")
public class TeacherRequirementService {

    @Autowired
    private TeacherRequirementDao teacherRequirementDao;
	
	public TeacherRequirementEntity queryObject(Integer id){
        return teacherRequirementDao.queryObject(id);
	}
	
    public	List<TeacherRequirementEntity> queryList(Map<String, Object> map){return teacherRequirementDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return teacherRequirementDao.queryTotal(map);}
	
	public  void save(TeacherRequirementEntity teacherRequirement){teacherRequirementDao.save(teacherRequirement);}
	
    public 	void update(TeacherRequirementEntity teacherRequirement){teacherRequirementDao.update(teacherRequirement);}

	public void updateSelective(TeacherRequirementEntity teacherRequirement){teacherRequirementDao.updateSelective(teacherRequirement);}
	
	public void delete(Integer id){teacherRequirementDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){teacherRequirementDao.deleteBatch(ids);}
}
