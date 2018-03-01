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
public class ForderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//发布时间
	private Date releaseDate;
	//年级科目
	private String subject;
	//订单状态(0:待审核，1：待预约，2：已预约 3：成功 4：失败 )
	private Integer status;
	//预约记录id
	private Integer appointmentId;
	//处理人id
	private Integer adminId;
	//
	private String adminName;
	//
	private Integer teacherId;
	//
	private Integer studentId;
	//
	private Integer teacherRequirementId;

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
	 * 设置：发布时间
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}
	/**
	 * 设置：年级科目
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：年级科目
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：订单状态(0:待审核，1：待预约，2：已预约 3：成功 4：失败 )
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态(0:待审核，1：待预约，2：已预约 3：成功 4：失败 )
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：预约记录id
	 */
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	/**
	 * 获取：预约记录id
	 */
	public Integer getAppointmentId() {
		return appointmentId;
	}
	/**
	 * 设置：处理人id
	 */
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	/**
	 * 获取：处理人id
	 */
	public Integer getAdminId() {
		return adminId;
	}
	/**
	 * 设置：
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * 获取：
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * 设置：
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：
	 */
	public Integer getTeacherId() {
		return teacherId;
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
	/**
	 * 设置：
	 */
	public void setTeacherRequirementId(Integer teacherRequirementId) {
		this.teacherRequirementId = teacherRequirementId;
	}
	/**
	 * 获取：
	 */
	public Integer getTeacherRequirementId() {
		return teacherRequirementId;
	}
}
