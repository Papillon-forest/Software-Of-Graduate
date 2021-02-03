package com.ks.glxt.graduateStudent.entity;

import com.ks.glxt.exception.addValidation;

import javax.validation.constraints.NotEmpty;


/**
 *      vId; 志愿Id 系统生成 不需要前端给
 *      vTime; 填志愿的时间
 *      sendId; 审核状态码 （不用前端传值）
 *      sendTime; 申报时间（让用户自己填）
 *      sId; 研究生Id（登陆的哪个用户的Id）
 *      tId; 教师Id （用户自己填写）
 *      Cid; 课程Id（这个是后台返回的课程信息弄成select 选择器 用户选哪个就要哪个的id）
 */
public class volunteer {
    private String vId;
    @NotEmpty(message = "不能为空",groups = addValidation.class)
    private String vTime;
    private String sendId;
    @NotEmpty(message = "不能为空",groups = addValidation.class)
    private String sendTime;
    @NotEmpty(message = "不能为空",groups = addValidation.class)
    private String sId;
    @NotEmpty(message = "不能为空",groups = addValidation.class)
    private String tId;
    @NotEmpty(message = "不能为空",groups = addValidation.class)
    private String cId;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvTime() {
        return vTime;
    }

    public void setvTime(String vTime) {
        this.vTime = vTime;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "volunteer{" +
                "vId='" + vId + '\'' +
                ", vTime='" + vTime + '\'' +
                ", sendId='" + sendId + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", sId='" + sId + '\'' +
                ", tId='" + tId + '\'' +
                ", cId='" + cId + '\'' +
                '}';
    }
}
