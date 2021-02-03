package com.ks.glxt.graduateStudent.entity;

import javax.validation.constraints.NotEmpty;

/**
 * 主键，学术报告ID xrId
 * 参会证明 xrProve
 * 报告中文名称 xrChina
 * 报告英文名称 xrEnglish
 * 备注 xrRemark
 * 审批状态 xrStatus   2是导师通过 3是导师不通过   0是学科负责人通过   1是学科负责人不通过
 * 导师审批时间 xrTtTime
 * 学科负责人审批时间 xrTlTime
 * 导师id       ttId
 * 学科负责人id  tlId
 * 导师是否签字  ttIs
 * 学科负责人是否签字  tlIs
 * 学术交流名称  xeName
 * 活动国家  xeCountry
 * 活动省   xeProvince
 * 活动市   xeCity
 * 活动时间  xeTime
 * 审核状态 type  2是导师通过  1是学科负责人通过
 * sId 研究生Id
 */
public class xueshuReport {
    @NotEmpty
   private String xrId;
   private String xrProve;
   private String xrChina;
   private String xrEnglish;
   private String xrRemark;
   private String xrStatus;
   private String xrTtTime;
   private String xrTlTime;
   private String ttId;
   private String tlId;
   private String ttIs;
   private String tlIs;
   private String xeName;
   private String xeCountry;
   private String xeProvince;
   private String xeCity;
   private String xeTime;
   private String sId;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getXrId() {
        return xrId;
    }

    public void setXrId(String xrId) {
        this.xrId = xrId;
    }

    public String getXrProve() {
        return xrProve;
    }

    public void setXrProve(String xrProve) {
        this.xrProve = xrProve;
    }

    public String getXrChina() {
        return xrChina;
    }

    public void setXrChina(String xrChina) {
        this.xrChina = xrChina;
    }

    public String getXrEnglish() {
        return xrEnglish;
    }

    public void setXrEnglish(String xrEnglish) {
        this.xrEnglish = xrEnglish;
    }

    public String getXrRemark() {
        return xrRemark;
    }

    public void setXrRemark(String xrRemark) {
        this.xrRemark = xrRemark;
    }

    public String getXrStatus() {
        return xrStatus;
    }

    public void setXrStatus(String xrStatus) {
        this.xrStatus = xrStatus;
    }

    public String getXrTtTime() {
        return xrTtTime;
    }

    public void setXrTtTime(String xrTtTime) {
        this.xrTtTime = xrTtTime;
    }

    public String getXrTlTime() {
        return xrTlTime;
    }

    public void setXrTlTime(String xrTlTime) {
        this.xrTlTime = xrTlTime;
    }

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getTlId() {
        return tlId;
    }

    public void setTlId(String tlId) {
        this.tlId = tlId;
    }

    public String getTtIs() {
        return ttIs;
    }

    public void setTtIs(String ttIs) {
        this.ttIs = ttIs;
    }

    public String getTlIs() {
        return tlIs;
    }

    public void setTlIs(String tlIs) {
        this.tlIs = tlIs;
    }


    public String getXeName() {
        return xeName;
    }

    public void setXeName(String xeName) {
        this.xeName = xeName;
    }

    public String getXeCountry() {
        return xeCountry;
    }

    public void setXeCountry(String xeCountry) {
        this.xeCountry = xeCountry;
    }

    public String getXeProvince() {
        return xeProvince;
    }

    public void setXeProvince(String xeProvince) {
        this.xeProvince = xeProvince;
    }

    public String getXeCity() {
        return xeCity;
    }

    public void setXeCity(String xeCity) {
        this.xeCity = xeCity;
    }

    public String getXeTime() {
        return xeTime;
    }

    public void setXeTime(String xeTime) {
        this.xeTime = xeTime;
    }

    @Override
    public String toString() {
        return "xueshuReport{" +
                "xrId='" + xrId + '\'' +
                ", xrProve='" + xrProve + '\'' +
                ", xrChina='" + xrChina + '\'' +
                ", xrEnglish='" + xrEnglish + '\'' +
                ", xrRemark='" + xrRemark + '\'' +
                ", xrStatus='" + xrStatus + '\'' +
                ", xrTtTime='" + xrTtTime + '\'' +
                ", xrTlTime='" + xrTlTime + '\'' +
                ", ttId='" + ttId + '\'' +
                ", tlId='" + tlId + '\'' +
                ", ttIs='" + ttIs + '\'' +
                ", tlIs='" + tlIs + '\'' +
                ", xeName='" + xeName + '\'' +
                ", xeCountry='" + xeCountry + '\'' +
                ", xeProvince='" + xeProvince + '\'' +
                ", xeCity='" + xeCity + '\'' +
                ", xeTime='" + xeTime + '\'' +
                '}';
    }
}
