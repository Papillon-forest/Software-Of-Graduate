package com.ks.glxt.publics.entity;

import javax.validation.constraints.NotNull;
import  com.ks.glxt.exception.addValidation;

public class user {
    @NotNull(message = "用户Id不能为空",groups = {addValidation.class})
    private Integer uId;
    @NotNull(message = "用户名称不能为空",groups = {addValidation.class})
    private String uName;
    @NotNull(message = "用户密码不能为空",groups = {addValidation.class})
    private String uPwd;
    @NotNull(message = "用户权限不能为空",groups = {addValidation.class})
    private Integer uRole;

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Override
    public String toString() {
        return "user{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uRole=" + uRole +
                '}';
    }
}
