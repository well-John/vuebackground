package com.example.demo.controller;


import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.TeacherService;
import com.example.demo.utils.PageUtils;
import com.example.demo.utils.Query;
import com.example.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-02-27 11:20:25
 */
@RestController
@RequestMapping("/generator/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TeacherEntity> teacherList = teacherService.queryList(query);
		int total = teacherService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(teacherList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		TeacherEntity teacher = teacherService.queryObject(id);
		
		return R.ok().put("teacher", teacher);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TeacherEntity teacher){
		teacherService.save(teacher);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TeacherEntity teacher){
		teacherService.update(teacher);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		teacherService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping(value = "/forbidden", method = RequestMethod.POST)
	public R forbidden(Integer id){
		System.out.println("id = " + id);
		System.out.println("StudentController.forbidden");
		if(teacherService.forbidden(id)){
			return R.ok();
		}else {
			return R.error();
		}
	}

	@RequestMapping("/recover")
	public R recover( Integer id){
		if(teacherService.recover(id)){
			return R.ok();
		}else {
			return R.error();
		}
	}
}
