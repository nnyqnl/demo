package com.wenqi.demo.service;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findByEmployee(Employee employee);
}
