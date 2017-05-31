package com.springplus.ssh.dao;

import java.util.List;

import com.springplus.ssh.dao.base.BaseDao;
import com.springplus.ssh.entity.RolePermission;


public interface RolePermissionDao extends BaseDao<RolePermission> {
	
	List<RolePermission> findRolePermissionListByRoleId(String roleId) throws Exception;
	
}
