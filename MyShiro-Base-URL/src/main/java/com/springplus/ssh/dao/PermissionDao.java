package com.springplus.ssh.dao;

import com.springplus.ssh.dao.base.BaseDao;
import com.springplus.ssh.entity.Permission;

public interface PermissionDao extends BaseDao<Permission> {
	
	Permission getPermissionByIdAndType(String id, Integer permissionType) throws Exception;
	
}
