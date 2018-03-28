package com.wenqi.demo.controller;

import com.wenqi.demo.dto.RequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;



public class BaseController<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	

	
	public RequestModel getRequestModel(HttpServletRequest request) {
		RequestModel requestModel = new RequestModel();
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String paramName = (String) enumeration.nextElement();
			String paramValue = request.getParameter(paramName);
			//处理输入参数：所有参数放入InputObject中的params，注意如果参数未传，则应置为null，能够更好地支持MySQL5.0以上版本数据；
			requestModel.getParams().put(paramName, paramValue == "" ? null : paramValue);
		}
		return requestModel;
	}


}
