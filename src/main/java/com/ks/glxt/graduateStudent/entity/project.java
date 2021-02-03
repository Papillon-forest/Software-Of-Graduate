package com.ks.glxt.graduateStudent.entity;

import javax.validation.constraints.NotEmpty;

/**
 * pId 主键，项目ID
 * pNum 项目编号
 * pName 项目名称
 * pType 项目类型
 * pStart 开始时间
 * pEnd 结束时间
 * pWork 承担工作
 * pMoney 折合经费
 * pStatus 审批状态
 * pTime 审批时间
 * tpId 研究生id
 * ttId 导师id
 * tpIs 项目跟进描述
 * ttIs （保留字段）
 */
public class project {
    @NotEmpty
   private String pId;
    @NotEmpty
   private String pNum;
    @NotEmpty
   private String pName;
    @NotEmpty
   private String pType;
    @NotEmpty
   private String pStart;
    @NotEmpty
   private String pEnd;
    @NotEmpty
   private String pWork;
    @NotEmpty
   private String pMoney;
   private String pStatus;
   private String pTime;
   @NotEmpty
   private String tpId;
   @NotEmpty
   private String ttId;
   private String tpIs;
   private String ttIs;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpStart() {
        return pStart;
    }

    public void setpStart(String pStart) {
        this.pStart = pStart;
    }

    public String getpEnd() {
        return pEnd;
    }

    public void setpEnd(String pEnd) {
        this.pEnd = pEnd;
    }

    public String getpWork() {
        return pWork;
    }

    public void setpWork(String pWork) {
        this.pWork = pWork;
    }

    public String getpMoney() {
        return pMoney;
    }

    public void setpMoney(String pMoney) {
        this.pMoney = pMoney;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getTpIs() {
        return tpIs;
    }

    public void setTpIs(String tpIs) {
        this.tpIs = tpIs;
    }

    public String getTtIs() {
        return ttIs;
    }

    public void setTtIs(String ttIs) {
        this.ttIs = ttIs;
    }

    @Override
    public String toString() {
        return "project{" +
                "pId='" + pId + '\'' +
                ", pNum='" + pNum + '\'' +
                ", pName='" + pName + '\'' +
                ", pType='" + pType + '\'' +
                ", pStart='" + pStart + '\'' +
                ", pEnd='" + pEnd + '\'' +
                ", pWork='" + pWork + '\'' +
                ", pMoney='" + pMoney + '\'' +
                ", pStatus='" + pStatus + '\'' +
                ", pTime='" + pTime + '\'' +
                ", tpId='" + tpId + '\'' +
                ", ttId='" + ttId + '\'' +
                ", tpIs='" + tpIs + '\'' +
                ", ttIs='" + ttIs + '\'' +
                '}';
    }
}

