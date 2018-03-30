package com.wenqi.demo.domain;

import java.util.Date;

/**
 * 请假表
 */
public class LeaveRecords {
    private Integer id;//主键
    private String employeeNumber;//'员工号',
    private String leaveType;//'请假类型',
    private Float hours;//'请假时长',
    private Date LeaveDate;//请哪天的假
    private String reason;//'请假理由',
    private Date commitTime;// '什么时候请的假',
    private Integer isHandle;//'是否处理：0未处理，1已处理',
    private Integer handleResult;//'处理结果：0不同意，1同意',
    private Date handleTime;//处理时间


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }

    public Date getLeaveDate() {
        return LeaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        LeaveDate = leaveDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Integer getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(Integer handleResult) {
        this.handleResult = handleResult;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}
