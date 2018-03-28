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
public class AttendanceException extends RuntimeException {
	private String msg;

	@Override
	public String toString() {
		return "AttendanceException{" +
				"msg='" + msg + '\'' +
				", code='" + code + '\'' +
				'}';
	}

	private String code;


	public AttendanceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AttendanceException(String msg, String code) {
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


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
