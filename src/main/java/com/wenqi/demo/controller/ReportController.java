package com.wenqi.demo.controller;

import com.sun.deploy.net.HttpResponse;
import com.wenqi.demo.domain.Attendance;
import com.wenqi.demo.domain.Employee;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.enums.MsgEnum;
import com.wenqi.demo.service.AttendanceService;
import com.wenqi.demo.utils.ExcelUtil;
import com.wenqi.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResultModel attendanceSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestModel requestModel = super.getRequestModel(request);

        //校验入参
        if (!validateRequest(requestModel)) {
            return ResultUtil.buildErrorResultDto(MsgEnum.ParamsUnValidDetails);
        }
        try {
            dateStringToDate(requestModel);
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResultModel(MsgEnum.ParseException.getCode(), MsgEnum.ParseException.getMsg());
        }
        //查询处境
        Employee employee = (Employee) SecurityUtils.getSubject().getPrincipal();
        requestModel.getParams().put("employeeNumber", employee.getNumber());
        LOGGER.info("调用service入参：" + requestModel.toString());
        List<Attendance> list = attendanceService.attendanceSearch(requestModel);

        //poi导出
        String[] title = {"序号", "员工号", "日期", "出勤时间", "考勤类型"};
        //excel文件名
        String fileName = employee.getName() + "考勤信息表" + System.currentTimeMillis() + ".xls";
        String sheetName = "考勤信息表";

        String[][] content = new String[list.size()][5];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list.size(); i++) {

            Attendance att = list.get(i);
            content[i][0] = ((Integer) (i + 1)).toString();
            content[i][1] = att.getEmployeeNumber();
            content[i][2] = sdf.format(att.getAttendanceDate());
            content[i][3] = att.getWorkingHours().toString();
            if(att.getType()==0){
                //异常
                content[i][4] = "异常";
            }else {
                content[i][4] = "正常";
            }

        }
        OutputStream os=null;
        try{
            //创建HSSFWorkbook
            HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
            //响应到客户端
            this.setResponseHeader(response, fileName);
            os= response.getOutputStream();
            wb.write(os);
            os.flush();

        }catch (Exception e){
            ResultUtil.buildErrorResultDto(MsgEnum.ExportException);
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
                ResultUtil.buildErrorResultDto(MsgEnum.IOException);
            }
        }





        return ResultModel.ok(null);
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {

        fileName = new String(fileName.getBytes(), "ISO8859-1");

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//        response.addHeader("Pargam", "no-cache");
//        response.addHeader("Cache-Control", "no-cache");

    }



//    private void exportAttendance(List<Attendance> list) {
//        LOGGER.info("excel开始导出===========================》");
//        //poi生成excel步骤，新建excel文档，新建sheet,新建row,新建cell单元格，写单元数据
//        //poi可生成HSSF（xls）和XSSF(xlsx)
//        HSSFWorkbook wb = new HSSFWorkbook();
//        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet("考勤记录");
//
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
//        HSSFRow row = sheet.createRow(0);
//
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
//
//        //声明列对象
//        HSSFCell cell = null;
//
//        //创建标题
//        String[] title={"序号","员工号","日期","出勤时间","考勤类型"};
//        for(int i=0;i<title.length;i++){
//            cell = row.createCell(i);
//            cell.setCellValue(title[i]);
//            cell.setCellStyle(style);
//        }
//
//        //创建内容
//        for (int i=0;i<list.size();i++){
//            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
//            dataRow.createCell(0).setCellValue(i+1);
//            dataRow.createCell(1).setCellValue(list.get(i).getAttendanceDate());
//            dataRow.createCell(2).setCellValue(list.get(i).getEmployeeNumber());
//            dataRow.createCell(3).setCellValue(list.get(i).getWorkingHours());
//            dataRow.createCell(4).setCellValue(list.get(i).getType());
//        }
//    }

    private boolean validateRequest(RequestModel requestModel) {
        String employeeNumber = (String) requestModel.getParams().get("employeeNumber");
        String attendanceDateRange = (String) requestModel.getParams().get("attendanceDateRange");

        //isBlank比isEmpty强大
        //  对应a="   ";isBlank返回true
        //isEmpty返回false

        if (StringUtils.isBlank(attendanceDateRange)) {
            return false;
        }
        return true;
    }

    /**
     * 将requestModel中的String 类型的两个日期转换成Date类型
     *
     * @param requestModel
     */
    private void dateStringToDate(RequestModel requestModel) throws ParseException {
        String attendanceDateRange = (String) requestModel.getParams().get("attendanceDateRange");
        String[] attendanceDateArr = attendanceDateRange.split(" - ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        requestModel.getParams().put("startDate", sdf.parse(attendanceDateArr[0]));
        requestModel.getParams().put("endDate", sdf.parse(attendanceDateArr[1]));

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
