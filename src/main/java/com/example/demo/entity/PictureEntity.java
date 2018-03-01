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
public class PictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//教员id
	private Integer id;
	//
	private Integer teacherId;
	//图片类型
	private Integer type;
	//图片路径
	private String path;
	//上传时间
	private Date uploadTime;
	//审核状态
	private Integer status;

	/**
	 * 设置：教员id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：教员id
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
	 * 设置：图片类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：图片类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：图片路径
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：图片路径
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：上传时间
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getUploadTime() {
		return uploadTime;
	}
	/**
	 * 设置：审核状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：审核状态
	 */
	public Integer getStatus() {
		return status;
	}
}
