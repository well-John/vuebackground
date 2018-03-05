package com.example.demo.controller;

import com.example.demo.entity.TeacherRequirementEntity;
import com.example.demo.service.TeacherRequirementService;
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
@RequestMapping("/generator/teacherrequirement")
public class TeacherRequirementController {
	@Autowired
	private TeacherRequirementService teacherRequirementService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TeacherRequirementEntity> teacherRequirementList = teacherRequirementService.queryList(query);
		int total = teacherRequirementService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(teacherRequirementList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		TeacherRequirementEntity teacherRequirement = teacherRequirementService.queryObject(id);
		
		return R.ok().put("teacherRequirement", teacherRequirement);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TeacherRequirementEntity teacherRequirement){
		teacherRequirementService.save(teacherRequirement);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TeacherRequirementEntity teacherRequirement){
		teacherRequirementService.update(teacherRequirement);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		teacherRequirementService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/checkRequire")
	public  R checkRequire(Integer id,Integer status){
		TeacherRequirementEntity requirement = new TeacherRequirementEntity();
		requirement.setId(id);
		requirement.setReleaseStatus(status);
		teacherRequirementService.updateSelective(requirement);
		return R.ok();
	}
}
