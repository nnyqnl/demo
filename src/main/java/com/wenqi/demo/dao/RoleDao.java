package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findByEmployee(Employee employee);
}
