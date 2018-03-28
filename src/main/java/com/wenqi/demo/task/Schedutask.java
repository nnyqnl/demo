//package com.wenqi.demo.task;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Configuration
//@Component // 此注解必加
//@EnableScheduling // 此注解必加
//
//public class Schedutask {
//
//
//    //@Autowired可以使用spring的bean
//
//
//    /**
//     * 发送告警通知
//     */
//    public void importToAttendance() {
//        //实际的业务
//
//        System.out.println("OverTime start time"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//
//        System.out.println("OverTime end time"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    }
//
//}