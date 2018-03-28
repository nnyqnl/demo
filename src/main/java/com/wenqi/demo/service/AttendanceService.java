package com.wenqi.demo.service;

import com.wenqi.demo.domain.Attendance;
import com.wenqi.demo.dto.RequestModel;

import java.util.List;

public interface AttendanceService {
    List<Attendance> attendanceSearch(RequestModel requestModel);

    void insert(RequestModel requestModel);
}
