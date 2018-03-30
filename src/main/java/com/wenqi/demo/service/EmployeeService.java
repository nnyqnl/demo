package com.wenqi.demo.service;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.dto.RequestModel;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee findByEmployeeNumber(Map<String, Object> requestMap);

    List<Employee> listByDepartmentId(RequestModel requestModel);
}
