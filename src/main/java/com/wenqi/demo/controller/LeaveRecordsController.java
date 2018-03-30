package com.wenqi.demo.controller;

import com.wenqi.demo.domain.LeaveRecords;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.service.LeaveRecordsService;
import com.wenqi.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/leaveRecords")
public class LeaveRecordsController extends BaseController<LeaveRecords>{

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveRecordsController.class);
    @Autowired
    private LeaveRecordsService LeaveRecordsService;
    @PostMapping("/askFor")
    public ResultModel login(HttpServletRequest request){
        RequestModel requestModel = super.getRequestModel(request);
        //入参校验
        if(!validateRequest(requestModel)){
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }

        //日期转换
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date LeaveRecordsDate = sdf.parse((String) requestModel.getParams().get("leaveDate"));
            requestModel.getParams().put("LeaveRecordsDate",LeaveRecordsDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResultUtil.buildErrorResultDto(MsgEnum.ParseException);
        }
        LOGGER.info("调用service的入参："+requestModel.getParams());
        LeaveRecordsService.askFor(requestModel.getParams());
        return ResultModel.ok(null);
    }

    private boolean validateRequest(RequestModel requestModel) {
        String type = (String)requestModel.getParams().get("leaveType");
        String hours = (String)requestModel.getParams().get("hours");
        String LeaveRecordsDate = (String)requestModel.getParams().get("leaveDate");
        String reason = (String)requestModel.getParams().get("reason");
        if(StringUtils.isBlank(type)){
            return false;
        }
        if(StringUtils.isBlank(hours)){
            return false;
        }
        if(StringUtils.isBlank(LeaveRecordsDate)){
            return false;
        }
        if(StringUtils.isBlank(reason)){
            return false;
        }
        return true;
    }
}
