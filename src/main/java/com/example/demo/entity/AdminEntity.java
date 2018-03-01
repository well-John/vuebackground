package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:27:41
 */
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String login;
	//
	private String password;
	//
	private Date lastTime;
	//
	private String lastIp;
	//
	private String name;

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
	 * 设置：
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * 获取：
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * 获取：
	 */
	public Date getLastTime() {
		return lastTime;
	}
	/**
	 * 设置：
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	/**
	 * 获取：
	 */
	public String getLastIp() {
		return lastIp;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
}
