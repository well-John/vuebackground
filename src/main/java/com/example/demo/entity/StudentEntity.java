package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-02-27 11:20:25
 */
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学员用户名
	private String name;
	//性别(0：男，1：女)
	private Integer sex;
	//登录密码
	private String password;
	//联系电话
	private String phone;
	//注册邮箱
	private String email;
	//上次登录ip
	private String lastIp;
	//上次登录时间
	private Date lastTime;
	//注册时间
	private Date regTime;
	//账户余额
	private String balance;
	//是否可用（0：未验证邮箱，1：禁用，2：可用）
	private Integer isabled;
	//登陆次数
	private Integer loginTimes;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：学员用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：学员用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别(0：男，1：女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0：男，1：女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：登录密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：注册邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：注册邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：上次登录ip
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	/**
	 * 获取：上次登录ip
	 */
	public String getLastIp() {
		return lastIp;
	}
	/**
	 * 设置：上次登录时间
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * 获取：上次登录时间
	 */
	public Date getLastTime() {
		return lastTime;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegTime() {
		return regTime;
	}
	/**
	 * 设置：账户余额
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	/**
	 * 获取：账户余额
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * 设置：是否可用（0：未验证邮箱，1：禁用，2：可用）
	 */
	public void setIsabled(Integer isabled) {
		this.isabled = isabled;
	}
	/**
	 * 获取：是否可用（0：未验证邮箱，1：禁用，2：可用）
	 */
	public Integer getIsabled() {
		return isabled;
	}
	/**
	 * 设置：登陆次数
	 */
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	/**
	 * 获取：登陆次数
	 */
	public Integer getLoginTimes() {
		return loginTimes;
	}
}
