package com.example.demo.controller;


import com.example.demo.entity.FavoriteEntity;
import com.example.demo.service.FavoriteService;
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
@RequestMapping("/generator/favorite")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FavoriteEntity> favoriteList = favoriteService.queryList(query);
		int total = favoriteService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(favoriteList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		FavoriteEntity favorite = favoriteService.queryObject(id);
		
		return R.ok().put("favorite", favorite);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody FavoriteEntity favorite){
		favoriteService.save(favorite);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody FavoriteEntity favorite){
		favoriteService.update(favorite);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		favoriteService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
