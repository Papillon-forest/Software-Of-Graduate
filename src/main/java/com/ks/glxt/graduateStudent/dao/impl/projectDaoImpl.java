package com.ks.glxt.graduateStudent.dao.impl;

import com.ks.glxt.graduateStudent.dao.projectDaoI;
import com.ks.glxt.graduateStudent.entity.project;
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
public class projectDaoImpl implements projectDaoI {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public project saveProjectInfo(project po) {
        String sql = "insert into Project (p_id,p_num,p_name,p_type,p_start,p_end,p_work,p_money,tp_id,tt_id) values(?,?,?,?,?,?,?,?,?,?)";
        int update = jdbc.update(sql, po.getpId(), po.getpNum(), po.getpName(), po.getpType(), po.getpStart(), po.getpEnd(), po.getpWork(), po.getpMoney(), po.getTpId(), po.getTtId());
        if(update>0){
            return po;
        }
        return null;
    }

    @Override
    public project findBypIdProjectInfo(String pId) {
        String sql = "select * from Project where p_id=?";
        Map<String, Object> stringObjectMap = null;
        try{
            stringObjectMap  = jdbc.queryForMap(sql,pId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        Map<String,Object> ms = new HashMap<>();
        project se = new project();
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
    public List<project> findByProjectInfoList() {
        String sql = "SELECT * FROM Project";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<project> courses = new ArrayList<>();
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
            project c = new project();

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
    public int updProjectInfo(String pId, String text) {
        String sql = "UPDATE Project SET tp_is = ? WHERE p_id = ?";
        int update = jdbc.update(sql,text,pId);
        return update;
    }

    /**
     *
     * @param pId 项目Id
     * @param pTime 审批时间
     * @param pStatus 状态 1是通过  2是不通过
     * @return
     */
    @Override
    public int updProjectInfo(String pId, String pTime, String pStatus) {
        String sql = "UPDATE Project SET p_time = ?,p_status = ? WHERE p_id = ?";
        int update = jdbc.update(sql,pTime,pStatus,pId);
        return update;
    }

    @Override
    public List<project> findBytIdProjectInfoList(String tId) {
        String sql = "SELECT * FROM Project where tt_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,tId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<project> courses = new ArrayList<>();
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
            project c = new project();

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
    public List<project> findBysIdProjectInfoList(String sId) {
        String sql = "SELECT * FROM Project where tp_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,sId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<project> courses = new ArrayList<>();
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
            project c = new project();

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
