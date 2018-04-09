package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.PermissionDao;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.domain.Permission;
import com.wenqi.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findByEmployee(Employee employee) {
        return permissionDao.findByEmployee(employee);
    }
}
