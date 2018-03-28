package com.wenqi.demo.domain;

import java.util.Date;

public class CardRecords {
    private Integer Id;
    private String employeeNumber;
    private Date StartTime;
    private Date EndTime;
    private Date CardRecordsDate;//打卡日期

    @Override
    public String toString() {
        return "CardRecords{" +
                "Id=" + Id +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", CardRecordsDate='" + CardRecordsDate + '\'' +
                '}';
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setemployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public void setCardRecordsDate(Date cardRecordsDate) {
        CardRecordsDate = cardRecordsDate;
    }

    public Integer getId() {

        return Id;
    }

    public String getemployeeNumber() {
        return employeeNumber;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public Date getCardRecordsDate() {
        return CardRecordsDate;
    }
}
