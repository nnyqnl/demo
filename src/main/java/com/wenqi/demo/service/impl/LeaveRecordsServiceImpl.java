package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.EmployeeDao;
import com.wenqi.demo.dao.LeaveRecordsDao;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.service.LeaveRecordsService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class LeaveRecordsServiceImpl implements LeaveRecordsService {
    @Autowired
    private LeaveRecordsDao LeaveRecordsDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public void askFor(Map requestMap) {
        //获取当前用户
        Employee employee=(Employee) SecurityUtils.getSubject().getPrincipal();
        Map map=new HashMap();
        map.put("employeeNumber",employee.getNumber());
        Employee _employee = employeeDao.findByEmployeeNumber(map);
        //向请假表中插入一条记录,组装参数
        requestMap.put("employeeNumber",employee.getNumber());
        requestMap.put("commitTime",new Date());
        if(_employee.getLevelId()>=3){
            //该职位请假不用领导批示，不用发邮件，直接将请假处理结果致为已处理isHandle=1，请假是否同意致为同意handleResult=1
            requestMap.put("isHandle",1);
            requestMap.put("handleResult",1);
            LeaveRecordsDao.insert(requestMap);
            return;
        }
        requestMap.put("isHandle",0);

        LeaveRecordsDao.insert(requestMap);

        //给领导发邮件通知
        //先查询其领导的邮箱
        map.put("number",_employee.getLeaderNumber());
        Employee leader = employeeDao.findByEmployeeNumber(map);
        String leaderEmail = leader.getEmail();
        //


    }
}
