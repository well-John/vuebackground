package com.example.demo.controller;

import com.example.demo.entity.DepositEntity;
import com.example.demo.service.DepositService;
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
 * @date 2018-03-01 11:37:14
 */
@RestController
@RequestMapping("/generator/deposit")
public class DepositController {
	@Autowired
	private DepositService depositService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DepositEntity> depositList = depositService.queryList(query);
		int total = depositService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(depositList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		DepositEntity deposit = depositService.queryObject(id);
		
		return R.ok().put("deposit", deposit);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody DepositEntity deposit){
		depositService.save(deposit);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody DepositEntity deposit){
		depositService.update(deposit);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		depositService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
