package com.example.demo.controller;

import com.example.demo.entity.TeacherDesireEntity;
import com.example.demo.service.TeacherDesireService;
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
 * @date 2018-03-01 11:27:41
 */
@RestController
@RequestMapping("/generator/teacherdesire")
public class TeacherDesireController {
	@Autowired
	private TeacherDesireService teacherDesireService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TeacherDesireEntity> teacherDesireList = teacherDesireService.queryList(query);
		int total = teacherDesireService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(teacherDesireList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		TeacherDesireEntity teacherDesire = teacherDesireService.queryObject(id);
		
		return R.ok().put("teacherDesire", teacherDesire);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TeacherDesireEntity teacherDesire){
		teacherDesireService.save(teacherDesire);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TeacherDesireEntity teacherDesire){
		teacherDesireService.update(teacherDesire);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		teacherDesireService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
