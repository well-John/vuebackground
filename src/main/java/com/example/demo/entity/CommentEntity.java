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
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer teacherId;
	//学员id
	private Integer studentId;
	//学员评价
	private String comment;
	//评价时间
	private Date commentTime;

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
	 * 设置：学员评价
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：学员评价
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 设置：评价时间
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	/**
	 * 获取：评价时间
	 */
	public Date getCommentTime() {
		return commentTime;
	}
}
