/**
 * @author 牛文奇
 *
 * 2018年3月12日
 */
package com.wenqi.demo.controller;

import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.service.AppUpdateService;
import com.wenqi.demo.service.impl.AppUpdateByAreaService;
import com.wenqi.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 牛文奇
 * 2018年3月12日
 */
@RestController
public class AppVersionUpdateController {


	@Value("${appVersionUpdateFlag}")
	private String appVersionUpdateFlag;

	@Resource(name = "generalAppUpdateService")
	private AppUpdateService generalAppUpdateService;

	@Resource(name = "appUpdateByVersionService")
	private AppUpdateService appUpdateByVersionService;

	@Resource(name = "appUpdateByAreaService")
	private AppUpdateService appUpdateByAreaService;
	@GetMapping("/app/update")
	public ResultModel appUpdate(String branch,String system,String version){
		Map map=new HashMap();
		map.put("branch",branch);
		map.put("system",system);
		map.put("version",version);
		String isUpdate=null;
		if("0".equals(appVersionUpdateFlag)){
			//走原来的service
			generalAppUpdateService.updateApp(map);


		}else if ("1".equals(appVersionUpdateFlag)){
			//按地区,新写service
			appUpdateByAreaService.updateApp(map);


		}else if ("2".equals(appVersionUpdateFlag)){
			//一部分版本号更新service
			isUpdate=appUpdateByVersionService.updateApp(map);


		}
		Map resultMap=new HashMap();
		resultMap.put("isUpdate",isUpdate);
		ResultModel resultModel= ResultModel.ok(resultMap);
//		switch (appVersionUpdateFlag) {
//			case "0":
//				//走原来的service
//				break;
//			case "1":
//				//按百分比,新写service
//				break;
//		}
		return resultModel;
	}



}
