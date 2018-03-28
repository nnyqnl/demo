package com.wenqi.demo.task;

import com.wenqi.demo.service.CardRecordsAndAttendanceService;
import com.wenqi.demo.service.impl.AttendanceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
@EnableScheduling // 此注解必加
public class TastDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(TastDemo.class);
    @Autowired
    private CardRecordsAndAttendanceService cardRecordsAndAttendanceService;
//    @Scheduled(fixedRate = 5000)//每5秒执行一次
//    public void play() throws Exception {
//        System.out.println("执行Quartz定时器任务："+new Date());
//    }

    @Scheduled(cron = "*0 0 14 * * ? ") //每天下午两点
    public void importCardRecordsToAttendance() throws ParseException {
        LOGGER.info("导入昨天的考勤记录=========================》开始");
//        System.out.println("每分钟执行一个的定时任务："+new Date());
        cardRecordsAndAttendanceService.importAttendanceRecords();
        LOGGER.info("导入昨天的考勤记录=========================》结束");
    }
}
