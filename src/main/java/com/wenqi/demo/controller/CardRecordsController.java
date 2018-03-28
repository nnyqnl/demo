package com.wenqi.demo.controller;

import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.service.CardRecordsService;
import com.wenqi.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@RestController
@RequestMapping("/card/records")
public class CardRecordsController extends BaseController{

    @Autowired
    private CardRecordsService cardrecordsService;
    @PostMapping("/record")
    public ResultModel record(HttpServletRequest request) {
        RequestModel requestModel = super.getRequestModel(request);
        //入参校验
        if(!validateRequest(requestModel)){
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }
        try {
            cardrecordsService.record(requestModel);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResultModel(ResultUtil.buildErrorResultDto(MsgEnum.ParseException));
        }
        return ResultModel.ok(null);
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
        return true;
    }

}
