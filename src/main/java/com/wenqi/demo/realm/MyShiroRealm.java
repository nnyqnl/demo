package com.wenqi.demo.realm;

import com.wenqi.demo.controller.EmployeeController;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //获取用户角色用户
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
//        SimpleAuthorizationInfo//获取用户角色
//        Set<String> roleSet = new HashSet<String>();
//        roleSet.add("100002");
//        info.setRoles(roleSet);
//
//        //获取用户权限
//        Set<String> permissionSet = new HashSet<String>();
//        permissionSet.add("权限添加");
//        permissionSet.add("权限删除");
//        info.setStringPermissions(permissionSet);


        return info;
    }
    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authcToken;
        String employeeNumber = usernamePasswordToken.getUsername();


        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("employeeNumber",employeeNumber);

        //根据用户名查询用户信息
        Employee employee=employeeService.findByEmployeeNumber(requestMap);
        if(employee==null){
            //没有该用户,会抛异常
            return null;
        }else {
            //大管家会比较密码，不一样也会抛异常
            return new SimpleAuthenticationInfo(employee,employee.getPassword(),getName());
        }

    }

}
