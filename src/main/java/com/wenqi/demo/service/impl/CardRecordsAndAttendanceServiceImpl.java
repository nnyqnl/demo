package com.wenqi.demo.service.impl;

import com.wenqi.demo.domain.CardRecords;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.enums.AttendanceTypeEnum;
import com.wenqi.demo.service.AttendanceService;
import com.wenqi.demo.service.CardRecordsAndAttendanceService;
import com.wenqi.demo.service.CardRecordsService;
import com.wenqi.demo.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class CardRecordsAndAttendanceServiceImpl implements CardRecordsAndAttendanceService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CardRecordsAndAttendanceServiceImpl.class);
    @Autowired
    private CardRecordsService cardRecordsService;
    @Autowired
    private AttendanceService attendanceService;
    @Override
    public void importAttendanceRecords() throws ParseException {
        RequestModel requestModel=new RequestModel();
        List<CardRecords> list=cardRecordsService.findYesterdayRecords(DateUtil.getYesterday());

        if (list==null&&list.isEmpty()){
            //没有打卡记录
            return;
        }
        LOGGER.info("昨天的打卡记录共有"+list.size()+"条");
        //便利循环，判断每一条打卡记录是否正常，是否有加班
        for (CardRecords c :list) {
            int i = c.getStartTime().compareTo(DateUtil.getYesterday8());//上班时间减去早上八点
            int j = c.getEndTime().compareTo(DateUtil.getYesterday16());//下班时间减去下午六点
            Float wordHours;//工作时长
            if(i>0&&j>0){
                //上班迟到，下班无早退,考勤异常
                wordHours=(DateUtil.getYesterday16().getTime()-c.getStartTime().getTime())/(1000f*60*60)-2;
                requestModel.getParams().put("type", AttendanceTypeEnum.ABNORMAL.getType());//0表示异常
            }else if(i<0&&j<0){
                //上班正常，下班早退
                wordHours=(c.getEndTime().getTime()-DateUtil.getYesterday8().getTime())/(1000f*60*60)-2;
                requestModel.getParams().put("type",AttendanceTypeEnum.ABNORMAL.getType());//0表示异常
            }else if(i>0&&j<0){
                //上班迟到，下班早退
                wordHours=(c.getEndTime().getTime()-c.getStartTime().getTime())/(1000f*60*60)-2;
                requestModel.getParams().put("type",AttendanceTypeEnum.ABNORMAL.getType());//0表示异常
            }else {
                //正常
                wordHours=8f;
                requestModel.getParams().put("type",AttendanceTypeEnum.NORMAL.getType());//0表示异常
            }

            DecimalFormat df = new DecimalFormat("0.00");

            requestModel.getParams().put("workingHours",Float.parseFloat(df.format(wordHours)));
            requestModel.getParams().put("employeeNumber",c.getemployeeNumber());
            requestModel.getParams().put("attendanceDate",c.getCardRecordsDate());
            attendanceService.insert(requestModel);
        }
    }
    public static void main(String args[]){
        float f=5L/3f;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print(df.format(f));
    }
}
