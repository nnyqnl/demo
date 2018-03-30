package com.wenqi.demo.domain;

import java.util.Date;

public class Employee {
    private Integer id;//主键id
    private String number;//工号
    private String name;//姓名
    private String gender;//性别
    private String eduLever;//教育水平
    private Date startDate;// 入职日期
    private Integer stratAge;// 入职时的年龄
    private String cardId;//省份证号
    private String telephone;//电话号
    private String type;//员工类型
    private String password;//登录密码
    private Integer departmentId;//部门id
    private Integer levelId;//职位id
    private String leaderNumber;//直接领导的工号
    private String email;//邮箱

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", eduLever='" + eduLever + '\'' +
                ", startDate=" + startDate +
                ", stratAge=" + stratAge +
                ", cardId='" + cardId + '\'' +
                ", telephone='" + telephone + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                ", departmentId=" + departmentId +
                ", levelId=" + levelId +
                ", leaderNumber='" + leaderNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEduLever() {
        return eduLever;
    }

    public void setEduLever(String eduLever) {
        this.eduLever = eduLever;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStratAge() {
        return stratAge;
    }

    public void setStratAge(Integer stratAge) {
        this.stratAge = stratAge;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLeaderNumber() {
        return leaderNumber;
    }

    public void setLeaderNumber(String leaderNumber) {
        this.leaderNumber = leaderNumber;
    }
}
