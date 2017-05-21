package com.springplus.ssh.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springplus.ssh.dao.UserDao;
import com.springplus.ssh.entity.User;
import com.springplus.ssh.exception.CustomException;
import com.springplus.ssh.model.ActiveUser;
import com.springplus.ssh.util.MD5;

/**   
* @Title: AuthorizeService.java 
* @Description:  认证授权服务 
* @author wangxuezheng
* @date 2017年5月21日 下午8:56:35 
* @version V1.0   
*/
@Service("authorizeService")
@Transactional
public class AuthorizeService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据用户的身份和密码，进行认证，如果认证通过，返回用户身份信息
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public ActiveUser authentication(String userName, String password) throws Exception{
		
		// 根据用户账号查询数据库
		User user = userDao.getUserByUserName(userName);
		if (user == null){ // 账号不存在
			throw new CustomException("账号不存在");
		}
		
		//密码对比
		String pwd_db = user.getPassword();
		String pwd_input = new MD5().getMD5ofStr(password); // MD5加密
		if (!pwd_db.equalsIgnoreCase(pwd_input)){
			throw new CustomException("密码错误");
		}
		
		// 认证 通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserId(user.getId());
		activeUser.setLoginName(user.getUserName());
		activeUser.setLoginTime(new Date());
		
		return activeUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
