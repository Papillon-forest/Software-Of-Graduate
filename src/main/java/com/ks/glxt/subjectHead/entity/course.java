package com.ks.glxt.subjectHead.entity;

import com.ks.glxt.exception.addValidation;

import javax.validation.constraints.NotEmpty;


/**
 *     cId ; 主键，课程ID(全部都不为空)
 *     cName 课程名称;
 *     cNum;课程编号
 *     cTime;授课时间
 *     cTerm;开设学期
 *     cType;课程性质
 *     cObj;授课对象
 *     cPop;授课人数
 *     cYear;开设年份
 *     cNums;志愿人数
 *     cMoney;参与项目的钱
 *     cCount;学术交流次数
 */
public class course {
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cId ;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cName;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cNum;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cTime;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cTerm;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cType;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cObj;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cPop;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cYear;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cNums;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cMoney;
    @NotEmpty(message = "不能为空",groups ={addValidation.class})
    private String cCount;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String getcTerm() {
        return cTerm;
    }

    public void setcTerm(String cTerm) {
        this.cTerm = cTerm;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcObj() {
        return cObj;
    }

    public void setcObj(String cObj) {
        this.cObj = cObj;
    }

    public String getcPop() {
        return cPop;
    }

    public void setcPop(String cPop) {
        this.cPop = cPop;
    }

    public String getcYear() {
        return cYear;
    }

    public void setcYear(String cYear) {
        this.cYear = cYear;
    }

    public String getcNums() {
        return cNums;
    }

    public void setcNums(String cNums) {
        this.cNums = cNums;
    }

    public String getcMoney() {
        return cMoney;
    }

    public void setcMoney(String cMoney) {
        this.cMoney = cMoney;
    }

    public String getcCount() {
        return cCount;
    }

    public void setcCount(String cCount) {
        this.cCount = cCount;
    }

    @Override
    public String toString() {
        return "courseI{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cNum='" + cNum + '\'' +
                ", cTime='" + cTime + '\'' +
                ", cTerm='" + cTerm + '\'' +
                ", cType='" + cType + '\'' +
                ", cObj='" + cObj + '\'' +
                ", cPop=" + cPop +
                ", cYear='" + cYear + '\'' +
                ", cNums='" + cNums + '\'' +
                ", cMoney='" + cMoney + '\'' +
                ", cCount='" + cCount + '\'' +
                '}';
    }
}
