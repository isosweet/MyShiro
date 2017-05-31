package com.springplus.ssh.dao;

import java.util.List;

import com.springplus.ssh.dao.base.BaseDao;
import com.springplus.ssh.entity.UserRole;

public interface UserRoleDao extends BaseDao<UserRole>{
	
	List<UserRole> findUserRoleListByUserId(String userId) throws Exception;
	
}
