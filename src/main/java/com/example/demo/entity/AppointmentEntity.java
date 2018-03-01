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
public class AppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//预约时间
	private Date appointmentDate;
	//教员id
	private Integer teacherId;
	//学员id
	private Integer studentId;
	//预约发起人身份(1:学员，2：教员)
	private Integer organiser;
	//预约状态(0:待接受，1：已接受)
	private Integer status;
	//
	private String teacherName;

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
	 * 设置：预约时间
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
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
	 * 设置：学员id
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学员id
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/**
	 * 设置：预约发起人身份(1:学员，2：教员)
	 */
	public void setOrganiser(Integer organiser) {
		this.organiser = organiser;
	}
	/**
	 * 获取：预约发起人身份(1:学员，2：教员)
	 */
	public Integer getOrganiser() {
		return organiser;
	}
	/**
	 * 设置：预约状态(0:待接受，1：已接受)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：预约状态(0:待接受，1：已接受)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 获取：
	 */
	public String getTeacherName() {
		return teacherName;
	}
}
