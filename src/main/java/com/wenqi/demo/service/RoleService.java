package com.wenqi.demo.service;

import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByEmployee(Employee employee);
}
