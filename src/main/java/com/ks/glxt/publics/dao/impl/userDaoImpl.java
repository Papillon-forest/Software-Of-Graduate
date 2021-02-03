package com.ks.glxt.publics.dao.impl;

import com.ks.glxt.publics.dao.userDao;
import com.ks.glxt.publics.entity.user;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component
public class userDaoImpl implements userDao {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public user findUserInfo(String userName,Integer uId) {
        user u = new user();
        String sql = "select * from User where u_name=? or u_id=?";
        Map<String, Object> stringObjectMap =null;
        try{
            stringObjectMap = jdbc.queryForMap(sql, userName,uId);
        }catch(EmptyResultDataAccessException e){
            return  null;
        }

        Map<String,Object> maps = new HashMap<>();
        for(String x: stringObjectMap.keySet()){
            String[] s = x.split("_");
            if(s.length==2){
                maps.put(s[0]+s[1].substring(0,1).toUpperCase()+s[1].substring(1),stringObjectMap.get(x));
            }else if( s.length==3){
                maps.put(s[0]+s[1].substring(0,1).toUpperCase()+s[1].substring(1)+s[2].substring(0,1).toUpperCase()+s[2].substring(1),stringObjectMap.get(x));
            }else{
                maps.put(s[0],stringObjectMap.get(x));
            }
            try {
                BeanUtils.populate(u,maps);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    @Override
    public user userReg(user info) {
        String sql = "INSERT INTO User (u_id,u_name,u_pwd,u_role) VALUES (?,?,?,?)";
        int update = jdbc.update(sql, info.getuId(), info.getuName(), info.getuPwd(), info.getuRole());
        if(update>0){
            return info;
        }
        return null;
    }
}
