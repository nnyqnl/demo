/**
 * @author 牛文奇
 *
 * 2018年3月12日
 */
package com.wenqi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 牛文奇
 * 2018年3月12日
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "spring boot";
	}
}
