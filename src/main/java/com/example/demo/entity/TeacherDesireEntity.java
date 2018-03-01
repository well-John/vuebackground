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
public class TeacherDesireEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//教授科目
	private String subject;
	//教授区域
	private String area;
	//辅导方式
	private Integer coachWay;
	//薪酬要求
	private String payment;
	//教员id
	private Integer teacherId;

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
	 * 设置：教授科目
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：教授科目
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：教授区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：教授区域
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：辅导方式
	 */
	public void setCoachWay(Integer coachWay) {
		this.coachWay = coachWay;
	}
	/**
	 * 获取：辅导方式
	 */
	public Integer getCoachWay() {
		return coachWay;
	}
	/**
	 * 设置：薪酬要求
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * 获取：薪酬要求
	 */
	public String getPayment() {
		return payment;
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
}
