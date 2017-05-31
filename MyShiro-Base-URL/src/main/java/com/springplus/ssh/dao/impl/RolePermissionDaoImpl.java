package com.springplus.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springplus.ssh.dao.RolePermissionDao;
import com.springplus.ssh.dao.base.BaseDaoImpl;
import com.springplus.ssh.entity.RolePermission;

@Repository("rolePermissionDao")
public class RolePermissionDaoImpl extends BaseDaoImpl<RolePermission> implements RolePermissionDao {

	@Override
	public List<RolePermission> findRolePermissionListByRoleId(String roleId) throws Exception {
		
		String hql = "from RolePermission where roleId = ? and delFlag = '0'";
		
		return this.findByHql(hql, roleId);
	}
	
	

}
