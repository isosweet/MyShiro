package com.springplus.ssh.dao;

import com.springplus.ssh.dao.base.BaseDao;
import com.springplus.ssh.entity.User;

public interface UserDao extends BaseDao<User>{
	
	User getUserByUserName(String userName) throws Exception;
	
}
