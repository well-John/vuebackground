package com.example.demo.controller;


import com.example.demo.entity.ForderEntity;
import com.example.demo.service.ForderService;
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
@RequestMapping("/generator/forder")
public class ForderController {
	@Autowired
	private ForderService forderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ForderEntity> forderList = forderService.queryList(query);
		int total = forderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(forderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ForderEntity forder = forderService.queryObject(id);
		
		return R.ok().put("forder", forder);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ForderEntity forder){
		forderService.save(forder);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ForderEntity forder){
		forderService.update(forder);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		forderService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
