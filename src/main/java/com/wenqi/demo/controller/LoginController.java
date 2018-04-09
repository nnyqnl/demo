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
@RequestMapping("/employee")
public class LoginController extends BaseController<Employee>{

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@PostMapping("/login")
	public ResultModel login(HttpServletRequest request){
        RequestModel requestModel = super.getRequestModel(request);
        //入参校验
        if(!validateRequest(requestModel)){
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }

        Subject subject = SecurityUtils.getSubject();

        String employeeNumber =(String) requestModel.getParams().get("employeeNumber");
        String password = (String)requestModel.getParams().get("password");
//        Boolean rememberMe = (Boolean)requestModel.getParams().get("rememberMe");

        UsernamePasswordToken token = new UsernamePasswordToken(employeeNumber, CryptographyUtil.md5(password,"java"));
        LOGGER.info(CryptographyUtil.md5(password,"java"));
        try{
            subject.login(token);
            return ResultModel.ok(null);
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            return ResultUtil.buildErrorResultDto(MsgEnum.UnknownAccount);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return ResultUtil.buildErrorResultDto(MsgEnum.IncorrectCredentials);
        } catch (ShiroException e) {
            e.printStackTrace();
            return ResultUtil.buildErrorResultDto(MsgEnum.ShiroException);
        }


	}

//	@GetMapping("/logout")
//    public ResultModel logout(HttpServletRequest request){
//        SecurityUtils.getSubject().logout();
//        return ResultModel.ok(null);
//    }
    private boolean validateRequest(RequestModel requestModel) {
        String employeeNumber =(String) requestModel.getParams().get("employeeNumber");
        String password = (String)requestModel.getParams().get("password");

        //isBlank比isEmpty强大
        //  对应a="   ";isBlank返回true
        //isEmpty返回false
        if(StringUtils.isBlank(employeeNumber)){
            return false;
        }
        if(StringUtils.isBlank(password)){
            return false;
        }
        return true;
    }
}
