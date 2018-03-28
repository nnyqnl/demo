package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Attendance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceDaoTest {

    @Autowired
    private AttendanceDao attendanceDao;
    @Test
    public void search() throws ParseException {
        Map map=new HashMap();
        map.put("type",1);
        map.put("employeeNumber","AAA000001");
        map.put("startDate",new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-25"));
        map.put("endDate",new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-30"));
        List<Attendance> list = attendanceDao.search(map);
        System.out.print(list);
    }
}