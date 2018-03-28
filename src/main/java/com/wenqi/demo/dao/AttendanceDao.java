package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Attendance;
import com.wenqi.demo.dto.RequestModel;

import java.util.List;
import java.util.Map;

public interface AttendanceDao {
    List<Attendance> search(Map map);

    void insert(Map map);
}
