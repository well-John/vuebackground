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
public class FavoriteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//教员id
	private Integer teacherId;
	//教员姓名
	private String name;
	//教员性别(0:男，1：女)
	private Integer sex;
	//学历
	private String education;
	//学校专业
	private String schoolMajor;
	//可授课程
	private String subject;
	//
	private Integer studentId;

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
	 * 设置：教员id
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教员id
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：教员姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：教员姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：教员性别(0:男，1：女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：教员性别(0:男，1：女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：学校专业
	 */
	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}
	/**
	 * 获取：学校专业
	 */
	public String getSchoolMajor() {
		return schoolMajor;
	}
	/**
	 * 设置：可授课程
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：可授课程
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：
	 */
	public Integer getStudentId() {
		return studentId;
	}
}
