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
public class TeacherRequirementEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学员id
	private Integer studentId;
	//联系人
	private String concat;
	//联系人性别(0:男,1:女)
	private Integer sex;
	//学员年龄
	private String age;
	//学员年级
	private String grade;
	//联系电话
	private String phone;
	//电子邮件
	private String email;
	//所在区域
	private String area;
	//详细地址
	private String address;
	//辅导科目
	private String subject;
	//学员状态详细描述
	private String studentDescription;
	//学员状态(0:零基础,1:补差型,2:提高型,3:拔尖型)
	private Integer studentLevel;
	//授课时间
	private String teachingTime;
	//需求人数
	private Integer requireCount;
	//性别要求(0:男，1：女,2:无要求)
	private Integer requireSex;
	//身份要求（0：在职教员，1：在职教师，2：无）
	private Integer identity;
	//资格要求
	private String requirement;
	//薪酬要求
	private String payment;
	//辅导方式()
	private String teachingType;
	//乘车补贴（0：无，1：有，2：部分，3：协商）
	private Integer ridingAllowance;
	//
	private Date releaseTime;
	//发布状态（0：发布中，1：已关闭)
	private Integer releaseStatus;

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
	 * 设置：联系人
	 */
	public void setConcat(String concat) {
		this.concat = concat;
	}
	/**
	 * 获取：联系人
	 */
	public String getConcat() {
		return concat;
	}
	/**
	 * 设置：联系人性别(0:男,1:女)
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：联系人性别(0:男,1:女)
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：学员年龄
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 获取：学员年龄
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 设置：学员年级
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：学员年级
	 */
	public String getGrade() {
		return grade;
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
	 * 设置：电子邮件
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮件
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：所在区域
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：所在区域
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：辅导科目
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * 获取：辅导科目
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * 设置：学员状态详细描述
	 */
	public void setStudentDescription(String studentDescription) {
		this.studentDescription = studentDescription;
	}
	/**
	 * 获取：学员状态详细描述
	 */
	public String getStudentDescription() {
		return studentDescription;
	}
	/**
	 * 设置：学员状态(0:零基础,1:补差型,2:提高型,3:拔尖型)
	 */
	public void setStudentLevel(Integer studentLevel) {
		this.studentLevel = studentLevel;
	}
	/**
	 * 获取：学员状态(0:零基础,1:补差型,2:提高型,3:拔尖型)
	 */
	public Integer getStudentLevel() {
		return studentLevel;
	}
	/**
	 * 设置：授课时间
	 */
	public void setTeachingTime(String teachingTime) {
		this.teachingTime = teachingTime;
	}
	/**
	 * 获取：授课时间
	 */
	public String getTeachingTime() {
		return teachingTime;
	}
	/**
	 * 设置：需求人数
	 */
	public void setRequireCount(Integer requireCount) {
		this.requireCount = requireCount;
	}
	/**
	 * 获取：需求人数
	 */
	public Integer getRequireCount() {
		return requireCount;
	}
	/**
	 * 设置：性别要求(0:男，1：女,2:无要求)
	 */
	public void setRequireSex(Integer requireSex) {
		this.requireSex = requireSex;
	}
	/**
	 * 获取：性别要求(0:男，1：女,2:无要求)
	 */
	public Integer getRequireSex() {
		return requireSex;
	}
	/**
	 * 设置：身份要求（0：在职教员，1：在职教师，2：无）
	 */
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	/**
	 * 获取：身份要求（0：在职教员，1：在职教师，2：无）
	 */
	public Integer getIdentity() {
		return identity;
	}
	/**
	 * 设置：资格要求
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	/**
	 * 获取：资格要求
	 */
	public String getRequirement() {
		return requirement;
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
	 * 设置：辅导方式()
	 */
	public void setTeachingType(String teachingType) {
		this.teachingType = teachingType;
	}
	/**
	 * 获取：辅导方式()
	 */
	public String getTeachingType() {
		return teachingType;
	}
	/**
	 * 设置：乘车补贴（0：无，1：有，2：部分，3：协商）
	 */
	public void setRidingAllowance(Integer ridingAllowance) {
		this.ridingAllowance = ridingAllowance;
	}
	/**
	 * 获取：乘车补贴（0：无，1：有，2：部分，3：协商）
	 */
	public Integer getRidingAllowance() {
		return ridingAllowance;
	}
	/**
	 * 设置：
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：发布状态（0：发布中，1：已关闭)
	 */
	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	/**
	 * 获取：发布状态（0：发布中，1：已关闭)
	 */
	public Integer getReleaseStatus() {
		return releaseStatus;
	}
}
