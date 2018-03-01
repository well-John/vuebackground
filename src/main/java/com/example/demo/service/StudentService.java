package com.example.demo.service;


import com.example.demo.dao.StudentDao;
import com.example.demo.entity.StudentEntity;
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
@Service("studentService")
public class StudentService {

    @Autowired
    private StudentDao studentDao;
	
	public StudentEntity queryObject(Integer id){
        return studentDao.queryObject(id);
	}
	
    public List<StudentEntity> queryList(Map<String, Object> map){return studentDao.queryList(map);}
	
	public  int queryTotal(Map<String, Object> map){return studentDao.queryTotal(map);}
	
	public  void save(StudentEntity student){studentDao.save(student);}
	
    public 	void update(StudentEntity student){studentDao.update(student);}

	public void updateSelective(StudentEntity student){studentDao.updateSelective(student);}
	
	public void delete(Integer id){studentDao.delete(id);}
	
	public void deleteBatch(Integer[] ids){studentDao.deleteBatch(ids);}

	public boolean forbidden(Integer id){
		return studentDao.forbidden(id) == 1 ? true : false;
	}

	public boolean recover(Integer id){
		return studentDao.recover(id) == 1 ? true : false;
	}
}
