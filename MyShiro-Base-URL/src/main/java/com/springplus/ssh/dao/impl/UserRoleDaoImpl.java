package com.springplus.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springplus.ssh.dao.UserRoleDao;
import com.springplus.ssh.dao.base.BaseDaoImpl;
import com.springplus.ssh.entity.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

	@Override
	public List<UserRole> findUserRoleListByUserId(String userId) throws Exception {
		
		String hql = "from UserRole where userId = ? and delFlag = '0'";
		
		return this.findByHql(hql, userId);
	}
		
	
	

}
