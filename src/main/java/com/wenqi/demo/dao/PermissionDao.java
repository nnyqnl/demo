package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> findByEmployee(Employee employee);
}
