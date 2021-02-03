package com.ks.glxt.publics.server.impl;

import com.ks.glxt.publics.dao.userDao;
import com.ks.glxt.publics.entity.user;
import com.ks.glxt.publics.server.userServerI;
import com.ks.glxt.util.MD5Util;
import com.ks.glxt.util.ok;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class userServerImpl implements userServerI {
    @Resource
    private userDao us ;
    @Override
    public user login(String uName, String pwd) {
        String md5Str = MD5Util.getMD5Str(pwd);
        user userInfo = us.findUserInfo(uName, null);
        if(userInfo.getuPwd().equals(md5Str)){
            return userInfo;
        }
        return null;
    }

    @Override
    public ok<user> reg(user info) {
        ok<user> oks = new ok<>();
        user userInfo = us.findUserInfo(info.getuName(), info.getuId());
        if(userInfo!=null && userInfo.getuId()!=null){
            oks.setMessage("已存在");
            oks.setStart("200");
            oks.setObject(userInfo);
        }else{
            info.setuPwd(MD5Util.getMD5Str(info.getuPwd()));
            user user = us.userReg(info);
            if(user!=null){
                oks.setMessage("注册成功");
                oks.setStart("200");
                oks.setObject(user);
            }else{
                oks.setStart("401");
                oks.setMessage("注册失败，服务器异常");
            }

        }
        return oks;
    }
}
