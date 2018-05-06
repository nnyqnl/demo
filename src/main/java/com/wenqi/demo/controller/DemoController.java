/**
 * @author 牛文奇
 *
 * 2018年3月12日
 */
package com.wenqi.demo.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.wenqi.demo.dao.DemoDao;
import com.wenqi.demo.domain.Demo;
import com.wenqi.demo.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 牛文奇
 */
@RestController
public class DemoController {

	@Autowired
	private DemoDao demoDao;
	@PostMapping(value = "/getById",
            produces = {"application/json"})
	public Map getById(@RequestParam Integer id){
        Map<String,Object> map = demoDao.getById(id);
        Object status = map.get("status");
        Object type = map.get("type");
        int a=(int)status;
        int b=(int)type;

        System.out.println(status.getClass());
        System.out.println(type.getClass());
        System.out.println(a+"====="+b);

        return map;
	}

    @PostMapping(value = "/getDemoById")
	public Demo getDemoById(@RequestParam Integer id){
        Demo demo = demoDao.getDemoById(id);

        if(1==demo.getStatus()){
            System.out.println("hahahha=----------------------");
        }
        System.out.println(demo.getStatus().getClass());
        System.out.println(demo.getType().getClass());

        return demo;
	}


    @GetMapping("/getByOther/{other}")
    public Map getByOther(@PathVariable String other){
        List<Map> list = demoDao.getByOther(other);

        return list.get(1);
    }


}
