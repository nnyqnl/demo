/**
 * @author 牛文奇
 *
 * 2018年3月12日
 */
package com.wenqi.demo.controller;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.service.EmployeeService;
import com.wenqi.demo.utils.CryptographyUtil;
import com.wenqi.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 牛文奇
 * 2018年3月28日
 */
@RestController
@RequestMapping("/employeeManagement")
public class EmployeeController extends BaseController<Employee>{

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/list")
    public ResultModel listByDepartmentId(HttpServletRequest request){
        RequestModel requestModel = super.getRequestModel(request);
        //入参校验
        String departmentId = (String) requestModel.getParams().get("departmentId");
        if(StringUtils.isBlank(departmentId)){
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }

        List<Employee> list=employeeService.listByDepartmentId(requestModel);
        return ResultModel.ok(list);

    }

}
