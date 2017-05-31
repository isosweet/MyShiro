package com.springplus.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springplus.ssh.dao.UserDao;
import com.springplus.ssh.dao.base.BaseDaoImpl;
import com.springplus.ssh.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByUserName(String userName) throws Exception {
		
		String hql = "from User where userName = ? and validity = 0";
		
		List<User> userList = this.findByHql(hql, userName);
		
		if (userList.isEmpty()) return null;
		
		if (userList.size() == 1) return userList.get(0);
		
		return null;
	}

	
}
