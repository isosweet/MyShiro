package com.springplus.ssh.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springplus.ssh.dao.PermissionDao;
import com.springplus.ssh.dao.RolePermissionDao;
import com.springplus.ssh.dao.UserDao;
import com.springplus.ssh.dao.UserRoleDao;
import com.springplus.ssh.entity.Permission;
import com.springplus.ssh.entity.RolePermission;
import com.springplus.ssh.entity.User;
import com.springplus.ssh.entity.UserRole;
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
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Autowired
	private PermissionDao permissionDao;
	
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
		
		// 用户的菜单
		List<Permission> menuList = this.findMenuListByUserId(user.getId());
		// 用户的权限
		List<Permission> permissionList = this.findPermissionListByUserId(user.getId());
		
		// 认证 通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserId(user.getId());
		activeUser.setLoginName(user.getUserName());
		activeUser.setLoginTime(new Date());
		activeUser.setMenus(menuList);
		activeUser.setPermissions(permissionList);
		
		return activeUser;
	}
	
	/**
	 * 根据用户id查询权限范围的菜单
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Permission> findMenuListByUserId(String userId) throws Exception{
		
		// 根据用户id查询用户角色
		List<UserRole> userRoleList = userRoleDao.findUserRoleListByUserId(userId);
		if (userRoleList.isEmpty()) return null;
		
		// 根据角色的id查询角色对应的权限
		List<String> permissionIds = new ArrayList<String>();
		for (UserRole userRole : userRoleList) {
			List<RolePermission> rolePermissionList = rolePermissionDao.findRolePermissionListByRoleId(userRole.getId());
			if (rolePermissionList.isEmpty()) return null;
			for (RolePermission rolePermission : rolePermissionList) {
				permissionIds.add(rolePermission.getId());
			}
		}
		
		// 根据权限id，查询权限类型为 0的 菜单 
		List<Permission> permissionList = new ArrayList<Permission>();
		for (String string : permissionIds) {
			Permission permission = permissionDao.getPermissionByIdAndType(string, 0);
			if (permission != null) permissionList.add(permission);
		}
		
		if (permissionList.size() == 0) return null;
		
		return permissionList;
	}
	
	/**
	 * 根据用户id查询权限范围的URL
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Permission> findPermissionListByUserId(String userId) throws Exception{
		
		// 根据用户id查询用户角色
		List<UserRole> userRoleList = userRoleDao.findUserRoleListByUserId(userId);
		if (userRoleList.isEmpty()) return null;
		
		// 根据角色的id查询角色对应的权限
		List<String> permissionIds = new ArrayList<String>();
		for (UserRole userRole : userRoleList) {
			List<RolePermission> rolePermissionList = rolePermissionDao.findRolePermissionListByRoleId(userRole.getId());
			if (rolePermissionList.isEmpty()) return null;
			for (RolePermission rolePermission : rolePermissionList) {
				permissionIds.add(rolePermission.getId());
			}
		}
		
		// 根据权限id，查询权限类型为 0的 菜单 
		List<Permission> permissionList = new ArrayList<Permission>();
		for (String string : permissionIds) {
			Permission permission = permissionDao.getPermissionByIdAndType(string, 1);
			if (permission != null) permissionList.add(permission);
		}
		
		if (permissionList.size() == 0) return null;
		
		return permissionList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
