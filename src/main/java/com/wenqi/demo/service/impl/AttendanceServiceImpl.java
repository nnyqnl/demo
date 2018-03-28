package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.AttendanceDao;
import com.wenqi.demo.domain.Attendance;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.service.AttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceServiceImpl.class);
    @Autowired
    private AttendanceDao attendanceDao;
    @Override
    public List<Attendance> attendanceSearch(RequestModel requestModel) {
        LOGGER.info("调用dao入参："+requestModel.getParams().toString());
        List<Attendance> list=attendanceDao.search(requestModel.getParams());
        return list;
    }

    @Override
    public void insert(RequestModel requestModel) {
        attendanceDao.insert(requestModel.getParams());
    }
}
