package com.example.demo.controller;

import com.example.demo.entity.AppointmentEntity;
import com.example.demo.service.AppointmentService;
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
@RequestMapping("/generator/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AppointmentEntity> appointmentList = appointmentService.queryList(query);
		int total = appointmentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(appointmentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		AppointmentEntity appointment = appointmentService.queryObject(id);
		
		return R.ok().put("appointment", appointment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AppointmentEntity appointment){
		appointmentService.save(appointment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AppointmentEntity appointment){
		appointmentService.update(appointment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		appointmentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
