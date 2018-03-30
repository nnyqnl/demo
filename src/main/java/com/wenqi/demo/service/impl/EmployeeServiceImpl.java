package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.EmployeeDao;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee findByEmployeeNumber(Map<String, Object> requestMap) {
        return employeeDao.findByEmployeeNumber(requestMap);
    }

    @Override
    public List<Employee> listByDepartmentId(RequestModel requestModel) {
        return employeeDao.listByDepartmentId(requestModel.getParams());
    }
}
