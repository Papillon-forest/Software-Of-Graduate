package com.ks.glxt.publics.controller;

import com.ks.glxt.exception.addValidation;
import com.ks.glxt.publics.entity.user;
import com.ks.glxt.publics.server.userServerI;
import com.ks.glxt.util.ok;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.validation.constraints.NotEmpty;


@RestController
@RequestMapping(value = "/user")
@Validated
public class userController {
    @Resource
    private userServerI us;
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ok<user> login(@NotEmpty(message = "不能为空",groups = addValidation.class)@RequestParam String uName,@NotEmpty(message = "不能为空",groups = addValidation.class) @RequestParam String uPwd){
        ok<user> o = new ok<>();
        user login = us.login(uName, uPwd);
        if(login!=null){
            login.setuPwd("");
            o.setObject(login);
            o.setStart("200");
            o.setMessage("登陆成功～");
        }else{
            o.setStart("400");
            o.setStart("登陆失败～");
        }
        return o;
    }

    @RequestMapping(value = "/reg",method = RequestMethod.POST,produces = "application/json")
    public ok<user> reg(@Validated({addValidation.class}) @RequestBody user info){
        ok<user> reg = us.reg(info);
        return reg;
    }
}
