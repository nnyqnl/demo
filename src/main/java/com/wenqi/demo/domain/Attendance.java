package com.wenqi.demo.domain;

import java.util.Date;

public class Attendance {
    private Integer id;
    private Float workingHours;
    private Integer type;
    private String employeeNumber;
    private Date attendanceDate;

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", workingHours=" + workingHours +
                ", type=" + type +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", attendancDate=" + attendanceDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Float workingHours) {
        this.workingHours = workingHours;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
