package com.myshiro.shirotest.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Shiro 认证
 * 
 * @author Administrator
 *
 */
public class AuthenticationTest {
	
	@Test
	public void testLoginAndLogout(){
		
		// 创建SecurityManager工厂,通过ini配置文件创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance(); 
		
		// 将SecurityManager设置到当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		// 从SecurityUtils里获取一个Subject
		Subject subject = SecurityUtils.getSubject();
		
		// 在认证提交前准备token(令牌)
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111");
		
		try {
			// 执行认证提交
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		// 是否认证通过
		boolean isAuthen = subject.isAuthenticated();
		
		System.out.println("是否认证通过----->" + isAuthen);
		
		// 退出
		subject.logout();
		
	}
}
