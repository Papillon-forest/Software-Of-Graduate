package com.ks.glxt.publics.server;

import com.ks.glxt.publics.entity.user;
import com.ks.glxt.util.ok;

public interface userServerI {
    /**
     *
     * @param uName
     * @param pwd
     * @return
     */
    user login(String uName, String pwd);

    /**
     * 注册
     * @param info
     * @return
     */
    ok<user> reg(user info);
}
