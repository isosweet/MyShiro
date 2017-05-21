package com.springplus.ssh.exception;
/**   
* @Title: CustomException.java 
* @Description:  自定义一般的异常 
* @author wangxuezheng
* @date 2017年5月21日 下午9:24:49 
* @version V1.0   
*/
public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}
	
}
