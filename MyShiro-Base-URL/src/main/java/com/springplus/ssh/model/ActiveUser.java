package com.springplus.ssh.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  用户身份信息
 *  
 * 
 * @author wangxuezheng
 *
 */
public class ActiveUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id 
	 */
	private String userId;

	/**
	 * 登陆名称
	 */
	private String loginName;
	
	/**
	 * 登陆时间
	 */
	private Date loginTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	
}
