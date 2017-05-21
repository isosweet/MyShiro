package com.myshiro.shirotest.md5;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {
	
	
	public static void main(String[] args) {
		
		String source = "111111";
		String salt = "asdf";
		int hashIterations = 5;
		
		/**
		 * source：明文，原始密码
		 * salt：盐，通过使用随机数
		 * hashIterations：散列的次数，比如散列两次，相当于MD5(MD5(''))
		 */
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		
		String password = md5Hash.toString();
		
		System.out.println("password--->" + password);
		
	}
}
