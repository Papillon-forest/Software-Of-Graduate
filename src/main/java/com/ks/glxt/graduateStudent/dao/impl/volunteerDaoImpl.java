package com.ks.glxt.graduateStudent.dao.impl;

import com.ks.glxt.graduateStudent.dao.volunteerDaoI;
import com.ks.glxt.graduateStudent.entity.volunteer;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class volunteerDaoImpl implements volunteerDaoI {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public volunteer saveVolunteer(volunteer info) {
        String sql = "INSERT INTO Volunteer (v_id,v_time,send_id,send_time,s_id,t_id,c_id) VALUES (?,?,?,?,?,?,?)";
        int update = jdbc.update(sql, info.getvId(), info.getvTime(), info.getSendId(), info.getSendTime(), info.getsId(), info.gettId(), info.getcId());
        if(update>0){
            return info;
        }
        return null;
    }

    @Override
    public volunteer findByvIdVolunteerInfo(String vId) {
        String sql = "SELECT * FROM Volunteer WHERE v_id = ?";
        Map<String, Object> stringObjectMap = null;
        try{
            stringObjectMap  = jdbc.queryForMap(sql, vId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        Map<String,Object> ms = new HashMap<>();
        volunteer se = new volunteer();
        for(String s: stringObjectMap.keySet()){
            String[] s1 = s.split("_");
            if(s1.length==2){
                ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),stringObjectMap.get(s));
            }else if(s1.length==3){
                ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1)+s1[2].substring(0,1).toUpperCase()+s1[2].substring(1),stringObjectMap.get(s));

            }else{
                ms.put(s1[0],stringObjectMap.get(s));

            }
        }
        try {
            BeanUtils.populate(se,ms);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return se;
    }

    @Override
    public List<volunteer> findByVolunteerInfoList() {
        String sql = "SELECT * FROM Volunteer";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<volunteer> courses = new ArrayList<>();
        maps.forEach(x->{
            Map<String,Object> ms = new HashMap<>();
            for(String s: x.keySet()){
                String[] s1 = s.split("_");
                if(s1.length==2){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),x.get(s));
                }else if( s1.length==3){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1)+s1[2].substring(0,1).toUpperCase()+s1[2].substring(1),x.get(s));
                }else{
                    ms.put(s1[0],x.get(x));
                }
            }
            listMap.add(ms);
        });
        listMap.forEach(x->{
            volunteer c = new volunteer();
            try {
                BeanUtils.populate(c,x);
                courses.add(c);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return courses;
    }

    @Override
    public int updateVolunteerInfo(String sendId,String vId) {
        String sql = "UPDATE Volunteer SET send_id = ? WHERE v_id = ?";
        int update = jdbc.update(sql,sendId,vId);
        return update;
    }

    @Override
    public int delVolunteerInfo(String vId) {
        String sql ="DELETE FROM Volunteer WHERE v_id = ?";
        int update = jdbc.update(sql, vId);
        return update;
    }

    @Override
    public List<volunteer> findBytIdVolunteerInfoList(String tId) {
        String sql = "SELECT * FROM Volunteer WHERE t_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,tId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<volunteer> courses = new ArrayList<>();
        maps.forEach(x->{
            Map<String,Object> ms = new HashMap<>();
            for(String s: x.keySet()){
                String[] s1 = s.split("_");
                if(s1.length==2){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),x.get(s));
                }else if( s1.length==3){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1)+s1[2].substring(0,1).toUpperCase()+s1[2].substring(1),x.get(s));
                }else{
                    ms.put(s1[0],x.get(x));
                }
            }
            listMap.add(ms);
        });
        listMap.forEach(x->{
            volunteer c = new volunteer();
            try {
                BeanUtils.populate(c,x);
                courses.add(c);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return courses;

    }

    @Override
    public List<volunteer> findBySendIdVolunteerInfoList(String type){
        String sql = "SELECT * FROM Volunteer WHERE send_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,type);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<volunteer> courses = new ArrayList<>();
        maps.forEach(x->{
            Map<String,Object> ms = new HashMap<>();
            for(String s: x.keySet()){
                String[] s1 = s.split("_");
                if(s1.length==2){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),x.get(s));
                }else if( s1.length==3){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1)+s1[2].substring(0,1).toUpperCase()+s1[2].substring(1),x.get(s));
                }else{
                    ms.put(s1[0],x.get(x));
                }
            }
            listMap.add(ms);
        });
        listMap.forEach(x->{
            volunteer c = new volunteer();
            try {
                BeanUtils.populate(c,x);
                courses.add(c);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return courses;

    }

    @Override
    public List<volunteer> findBySidVolunteerInfoList(String sId) {
        String sql = "SELECT * FROM Volunteer WHERE s_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,sId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<volunteer> courses = new ArrayList<>();
        maps.forEach(x->{
            Map<String,Object> ms = new HashMap<>();
            for(String s: x.keySet()){
                String[] s1 = s.split("_");
                if(s1.length==2){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),x.get(s));
                }else if( s1.length==3){
                    ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1)+s1[2].substring(0,1).toUpperCase()+s1[2].substring(1),x.get(s));
                }else{
                    ms.put(s1[0],x.get(x));
                }
            }
            listMap.add(ms);
        });
        listMap.forEach(x->{
            volunteer c = new volunteer();
            try {
                BeanUtils.populate(c,x);
                courses.add(c);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return courses;
    }
}
