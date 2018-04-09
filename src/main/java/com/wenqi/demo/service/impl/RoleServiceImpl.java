package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.RoleDao;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Role;
import com.wenqi.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findByEmployee(Employee employee) {
        return roleDao.findByEmployee(employee);
    }
}
