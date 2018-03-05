package com.example.demo.controller;


import com.example.demo.entity.PictureEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.PictureService;
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
@RequestMapping("/generator/picture")
public class PictureController {
	@Autowired
	private PictureService pictureService;

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PictureEntity> pictureList = pictureService.queryList(query);
		int total = pictureService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(pictureList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		PictureEntity picture = pictureService.queryObject(id);
		
		return R.ok().put("picture", picture);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody PictureEntity picture){
		pictureService.save(picture);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody PictureEntity picture){
		pictureService.update(picture);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		pictureService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/checkImg")
	public R checkImg(Integer status,Integer id){
		PictureEntity pictureEntity = pictureService.queryObject(id);
		pictureEntity.setStatus(status);
		pictureService.updateSelective(pictureEntity);
		if(pictureEntity.getType() == 0){
			TeacherEntity teacher = new TeacherEntity();
			teacher.setId(pictureEntity.getTeacherId());
			teacher.setAvatar(pictureEntity.getPath());
			teacherService.updateSelective(teacher);
		}
		return R.ok();
	}

}
