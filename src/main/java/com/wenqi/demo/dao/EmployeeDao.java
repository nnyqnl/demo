package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    Employee findByEmployeeNumber(Map<String, Object> requestMap);

    List<Employee> listByDepartmentId(Map params);
}
