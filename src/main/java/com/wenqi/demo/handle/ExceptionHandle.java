/**
 * @author 牛文奇
 *
 * 2018年3月11日
 */
package com.wenqi.demo.handle;

import com.wenqi.demo.controller.AttendanceController;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 牛文奇
 * 2018年3月11日
 */
@ControllerAdvice
public class ExceptionHandle {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceController.class);
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public ResultModel handle(Exception e){
		if(e instanceof GirlException){
			GirlException g=(GirlException) e;
			e.printStackTrace();
			return new ResultModel(g.getCode(), g.getMsg());
		}
		e.printStackTrace();
		return new ResultModel(MsgEnum.UNKNOWN.getCode(),MsgEnum.UNKNOWN.getMsg());
	}
}
