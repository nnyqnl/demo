package com.wenqi.demo.utils;

import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import org.apache.commons.lang3.StringUtils;


public class ResultUtil
{
    public static final String RESPONSE_CODE = "responseCode";
    public static final String RESPONSE_messageEnum = "responsemessageEnum";
    public static final String RESPONSE_DATA = "responseData";

    public static ResultModel buildResponsemessageEnum(MsgEnum messageEnum)
    {
        return new ResultModel(messageEnum.getCode(), messageEnum.getMsg(), null);
    }

    public static ResultModel buildResponsemessageEnum(MsgEnum msgEnum, Object responseData)
    {
        return new ResultModel(msgEnum.getCode(), msgEnum.getMsg(), responseData);
    }

    public static ResultModel buildResponsemessageEnumOnSuccess()
    {
        return buildResponsemessageEnum(MsgEnum.SUCCESS);
    }

    public static ResultModel buildResponsemessageEnumOnSuccess(Object responseData)
    {
        return buildResponsemessageEnum(MsgEnum.SUCCESS, responseData);
    }

    public static ResultModel buildSuccessResultDto(Object resultData)
    {
        return getResultDto(MsgEnum.SUCCESS, null, resultData);
    }

    public static ResultModel buildSuccessResultDto(String msg, Object resultData)
    {
        return getResultDto(MsgEnum.SUCCESS, msg, resultData);
    }

    public static ResultModel buildErrorResultDto(MsgEnum MsgEnum)
    {
        return getResultDto(MsgEnum, null, null);
    }

    public static ResultModel buildErrorResultDto(MsgEnum MsgEnum, String msg)
    {
        return getResultDto(MsgEnum, msg, null);
    }

    public static ResultModel getResultDto(MsgEnum MsgEnum, String msg, Object resultData)
    {
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(MsgEnum.getCode());
        if (StringUtils.isNotBlank(msg)) {
            resultModel.setMsg(msg);
        } else {
            resultModel.setMsg(MsgEnum.getMsg());
        }
        resultModel.setData(resultData);
        return resultModel;
    }

//    public static ResultModel buildErrorResultDto(String responseJson)
//    {
//
//        return (ResultModel)JSONObject.parseObject(responseJson, ResultModel.class);
//    }
}
