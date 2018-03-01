package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-01 11:37:14
 */
public class DepositEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//充值时间
	private Date chargeDate;
	//充值金额
	private String chargeMoney;
	//充值状态(0:成功，1:失败)
	private Integer status;
	//充值人身份(1:学员，2：教员)
	private Integer organiser;
	//充值人id
	private Integer organiserId;

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
	 * 设置：充值时间
	 */
	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}
	/**
	 * 获取：充值时间
	 */
	public Date getChargeDate() {
		return chargeDate;
	}
	/**
	 * 设置：充值金额
	 */
	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	/**
	 * 获取：充值金额
	 */
	public String getChargeMoney() {
		return chargeMoney;
	}
	/**
	 * 设置：充值状态(0:成功，1:失败)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：充值状态(0:成功，1:失败)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：充值人身份(1:学员，2：教员)
	 */
	public void setOrganiser(Integer organiser) {
		this.organiser = organiser;
	}
	/**
	 * 获取：充值人身份(1:学员，2：教员)
	 */
	public Integer getOrganiser() {
		return organiser;
	}
	/**
	 * 设置：充值人id
	 */
	public void setOrganiserId(Integer organiserId) {
		this.organiserId = organiserId;
	}
	/**
	 * 获取：充值人id
	 */
	public Integer getOrganiserId() {
		return organiserId;
	}
}
