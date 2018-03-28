/**
 * @author 牛文奇
 *
 * 2018年3月11日
 */
package com.wenqi.demo.exception;

/**
 * @author 牛文奇
 * 2018年3月11日
 */
public class GirlException extends RuntimeException {
	private String msg;
	private String code;
	
	
	public GirlException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GirlException(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "GirlException [msg=" + msg + ", code=" + code + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
