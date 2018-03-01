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
public class TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//昵称
	private String nickname;
	//真实姓名
	private String name;
	//密码
	private String password;
	//性别(0:男，1：女)
	private Integer sex;
	//出生年月
	private String birthday;
	//最高学历
	private String education;
	//所学专业
	private String major;
	//就读大学
	private String university;
	//联系电话
	private String phone;
	//电子邮箱
	private String email;
	//自我描述
	private String description;
	//通讯地址
	private String address;
	//辅导经验
	private String teachingTime;
	//教授区域
	private String teachingArea;
	//教授科目
	private String teachingSubject;
	//外语水平
	private String foreignLevel;
	//家教经历
	private String experience;
	//头像
	private String avatar;
	//上次登录时间
	private Date lastTime;
	//注册时间
	private Date registerTime;
	//上次登录ip
	private String lastIp;
	//是否可用(0:可用，1：禁用)
	private Integer isabled;
	//职业(0:在校大学生，1：教师)
	private Integer identity;
	//
	private String qq;
	//目前身份
	private String currentStatus;
	//
	private String wechat;

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
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：性别(0:男，1：女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0:男，1：女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：出生年月
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：出生年月
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：最高学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：最高学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：所学专业
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * 获取：所学专业
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * 设置：就读大学
	 */
	public void setUniversity(String university) {
		this.university = university;
	}
	/**
	 * 获取：就读大学
	 */
	public String getUniversity() {
		return university;
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
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：自我描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：自我描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：通讯地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：通讯地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：辅导经验
	 */
	public void setTeachingTime(String teachingTime) {
		this.teachingTime = teachingTime;
	}
	/**
	 * 获取：辅导经验
	 */
	public String getTeachingTime() {
		return teachingTime;
	}
	/**
	 * 设置：教授区域
	 */
	public void setTeachingArea(String teachingArea) {
		this.teachingArea = teachingArea;
	}
	/**
	 * 获取：教授区域
	 */
	public String getTeachingArea() {
		return teachingArea;
	}
	/**
	 * 设置：教授科目
	 */
	public void setTeachingSubject(String teachingSubject) {
		this.teachingSubject = teachingSubject;
	}
	/**
	 * 获取：教授科目
	 */
	public String getTeachingSubject() {
		return teachingSubject;
	}
	/**
	 * 设置：外语水平
	 */
	public void setForeignLevel(String foreignLevel) {
		this.foreignLevel = foreignLevel;
	}
	/**
	 * 获取：外语水平
	 */
	public String getForeignLevel() {
		return foreignLevel;
	}
	/**
	 * 设置：家教经历
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * 获取：家教经历
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
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
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
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
	 * 设置：是否可用(0:可用，1：禁用)
	 */
	public void setIsabled(Integer isabled) {
		this.isabled = isabled;
	}
	/**
	 * 获取：是否可用(0:可用，1：禁用)
	 */
	public Integer getIsabled() {
		return isabled;
	}
	/**
	 * 设置：职业(0:在校大学生，1：教师)
	 */
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	/**
	 * 获取：职业(0:在校大学生，1：教师)
	 */
	public Integer getIdentity() {
		return identity;
	}
	/**
	 * 设置：
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：目前身份
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	/**
	 * 获取：目前身份
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}
	/**
	 * 设置：
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：
	 */
	public String getWechat() {
		return wechat;
	}
}
