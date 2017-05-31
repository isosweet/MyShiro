package com.springplus.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springplus.ssh.dao.PermissionDao;
import com.springplus.ssh.dao.base.BaseDaoImpl;
import com.springplus.ssh.entity.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {

	@Override
	public Permission getPermissionByIdAndType(String id, Integer permissionType) throws Exception {
		
		String hql = "from Permission where id  = ? and permissionType and delFlag = '0'";
		
		List<Permission> list = this.findByHql(hql, id, permissionType);
		
		if (list.isEmpty()) return null;
		
		if (list.size() == 1) return list.get(0);
		
		return null;
	}
	
	

}
