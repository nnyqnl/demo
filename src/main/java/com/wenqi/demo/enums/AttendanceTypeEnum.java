package com.wenqi.demo.enums;

public enum AttendanceTypeEnum {
	NORMAL(1,"正常"),
	ABNORMAL(0,"异常");

	private int type;
	private String typeName;

	AttendanceTypeEnum(int type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
