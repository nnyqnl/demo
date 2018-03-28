package com.wenqi.demo.controller;

import com.wenqi.demo.domain.Attendance;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.service.AttendanceService;
import com.wenqi.demo.service.CardRecordsService;
import com.wenqi.demo.service.impl.AttendanceServiceImpl;
import com.wenqi.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.wenqi.demo.domain.Attendance;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceController.class);
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendanceSearch")
    public ResultModel attendanceSearch(HttpServletRequest request) {
        RequestModel requestModel = super.getRequestModel(request);

        //校验入参
        if(!validateRequest(requestModel)){
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }
        try {
            dateStringToDate(requestModel);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResultModel(MsgEnum.ParseException.getCode(),MsgEnum.ParseException.getMsg());
        }
        LOGGER.info("调用service入参："+requestModel.toString());
        List<Attendance> list=attendanceService.attendanceSearch(requestModel);
        return ResultModel.ok(list);
    }

    private boolean validateRequest(RequestModel requestModel) {
        String employeeNumber =(String) requestModel.getParams().get("employeeNumber");
        String attendanceDateRange = (String)requestModel.getParams().get("attendanceDateRange");

        //isBlank比isEmpty强大
        //  对应a="   ";isBlank返回true
        //isEmpty返回false
        if(StringUtils.isBlank(employeeNumber)){

            return false;
        }
        if(StringUtils.isBlank(attendanceDateRange)){
            return  false;
        }
        return true;
    }

    /**
     * 将requestModel中的String 类型的两个日期转换成Date类型
     * @param requestModel
     */
    private void dateStringToDate(RequestModel requestModel) throws ParseException {
        String attendanceDateRange = (String)requestModel.getParams().get("attendanceDateRange");
        String[] attendanceDateArr = attendanceDateRange.split(" - ");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        requestModel.getParams().put("startDate",sdf.parse(attendanceDateArr[0]));
        requestModel.getParams().put("endDate",sdf.parse(attendanceDateArr[1]));

    }
    public static void main(String[] agrs) throws ParseException {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2015-01-02");
//
//        System.out.print(date);
//            Boolean a=StringUtils.isBlank("  ");
//            System.out.print(a);
    }

}
