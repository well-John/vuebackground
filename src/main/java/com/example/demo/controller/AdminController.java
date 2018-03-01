package com.example.demo.controller;

import com.example.demo.entity.AdminEntity;
import com.example.demo.service.AdminService;
import com.example.demo.utils.PageUtils;
import com.example.demo.utils.Query;
import com.example.demo.utils.R;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/generator/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AdminEntity> adminList = adminService.queryList(query);
		int total = adminService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(adminList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		AdminEntity admin = adminService.queryObject(id);
		
		return R.ok().put("admin", admin);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody AdminEntity admin){
		adminService.save(admin);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody AdminEntity admin){
		adminService.update(admin);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		adminService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/login")
	public R login(HttpServletRequest request, String login, String password){
		HttpSession session = request.getSession();
		AdminEntity admin =adminService.login(login.trim(),password.trim());
        if(admin != null){
        	session.setAttribute("admin",admin);
        	return R.ok();
		}else{
        	return R.error();
		}
	}

	@RequestMapping("/checklogin")
	public R checkLogin(HttpServletRequest request){
		HttpSession session = request.getSession();
		AdminEntity admin = (AdminEntity) session.getAttribute("admin");
		if(admin != null){
			return R.ok();
		}else {
			return R.error();
		}
	}

	@RequestMapping("/logout")
	public R logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return R.ok();
	}
}
