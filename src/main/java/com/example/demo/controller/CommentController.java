package com.example.demo.controller;

import com.example.demo.entity.CommentEntity;
import com.example.demo.service.CommentService;
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
@RequestMapping("/generator/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CommentEntity> commentList = commentService.queryList(query);
		int total = commentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		CommentEntity comment = commentService.queryObject(id);
		
		return R.ok().put("comment", comment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CommentEntity comment){
		commentService.save(comment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CommentEntity comment){
		commentService.update(comment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		commentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
