package com.ks.glxt.publics.dao;

import com.ks.glxt.publics.entity.user;

/**
 * 登陆
 */
public interface userDao {
    /**
     * 用户查询 (通过名字)
     * @param userName
     *
     * @return
     */
    user findUserInfo(String userName,Integer uId);

    /**
     * 用户注册
     * @param info
     * @return
     */
    user userReg(user info);


}
