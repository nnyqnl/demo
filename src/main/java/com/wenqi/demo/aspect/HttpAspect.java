/**
 * @author 牛文奇
 *
 * 2018年3月11日
 */
package com.wenqi.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 牛文奇
 * 2018年3月11日
 */
@Aspect
@Component
public class HttpAspect {

	private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.wenqi.demo.controller.*.*(..))||execution(public * com.wenqi.demo.handle.ExceptionHandle.handle(..))")
	public void log(){}
	
	@Before("log()")
	public void doBefore(){
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
//		
//		//请求url
//		logger.info("url={}", request.getRequestURL());
//		//ip
//		logger.info("ip={}", request.getRemoteAddr());
//		//method
//		logger.info("method={}", request.getMethod());
		
		logger.info("doBefore================");
	}
	
	@After("log()")
	public void doAfter(){
		logger.info("doAfter================");
	}
	
	@AfterReturning(returning="obj",pointcut="log()")
	public void doAfter(Object obj){
		logger.info("response={}",obj);
	}
}
