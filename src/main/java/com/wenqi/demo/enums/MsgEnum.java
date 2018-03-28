package com.wenqi.demo.enums;

public enum MsgEnum {
	SUCCESS("200","成功"),
	FAILURE("999","失败"),
	ErrormessageEnum("111","缺少必要的参数"),
	UNKNOWN("777","未知错误"),
	GirlZhongXue("100","上中学"),
	GirlXiaoxue("101","上小学"),
	ParamsUnValidDetails("700", "参数校验不通过! 未通过校验的参数列表: {0}."),
	ParseException("444","解析异常");
	
	private String code;
	private String msg;
	
	private MsgEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
