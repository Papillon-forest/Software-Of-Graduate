package com.ks.glxt.graduateStudent.dao.impl;

import com.ks.glxt.graduateStudent.dao.xueshuReportDaoI;
import com.ks.glxt.graduateStudent.entity.xueshuReport;
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
public class xueshuReportDaoImpl implements xueshuReportDaoI {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public xueshuReport saveXueshuReportInfo(xueshuReport xr) {
        String sql = "insert into Xueshu_report (xr_id,s_id,xr_prove,xr_china,xr_english,xr_remark,xr_status,tt_id,xe_name,xe_country,xe_time) values (?,?,?,?,?,?,?,?,?,?,?)";
        int update = jdbc.update(sql, xr.getXrId(),xr.getsId(), xr.getXrProve(), xr.getXrChina(), xr.getXrEnglish(), xr.getXrRemark(), xr.getXrStatus(), xr.getTtId(), xr.getXeName(), xr.getXeCountry(), xr.getXeTime());
        if(update>0){
            return xr;
        }
        return null;
    }

    @Override
    public List<xueshuReport> findByXueshuReportInfoList() {
        String sql = "select *  from Xueshu_report ";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<xueshuReport> courses = new ArrayList<>();
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
            xueshuReport c = new xueshuReport();
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
    public List<xueshuReport> findBytTidXueshuReportInfoList(String tId) {
        String sql = "select *  from Xueshu_report where tt_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,tId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<xueshuReport> courses = new ArrayList<>();
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
            xueshuReport c = new xueshuReport();
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
    public List<xueshuReport> findBysIdXueshuReportInfoList(String sId) {
        String sql = "select *  from Xueshu_report where s_id = ?";
        List<Map<String, Object>> maps = null;
        try{
            maps = jdbc.queryForList(sql,sId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        List<Map<String,Object>> listMap = new ArrayList<>();
        List<xueshuReport> courses = new ArrayList<>();
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
            xueshuReport c = new xueshuReport();
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
    public xueshuReport findByxRIdXueshuReportInfo(String xrId) {
        String sql = "SELECT * FROM Xueshu_report WHERE xr_id = ?";
        Map<String, Object> stringObjectMap = null;
        try{
            stringObjectMap  = jdbc.queryForMap(sql, xrId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        Map<String,Object> ms = new HashMap<>();
        xueshuReport se = new xueshuReport();
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
    public int updBytIdXueshuReportInfo(String xrId, String upd0, String upd1, String upd2) {
        String sql = "UPDATE Xueshu_report SET xr_status = ?,xr_tt_time = ?,tt_is=? WHERE xr_id = ?";
        int update = jdbc.update(sql, upd0, upd1, upd2, xrId);
        return update;
    }

    @Override
    public int updByXkXueshuReportInfo(String xrId, String upd0, String upd1, String upd2) {
        String sql = "UPDATE Xueshu_report SET xr_status = ?,xr_tl_time = ?,tl_is=? where xr_id = ?";
        return jdbc.update(sql,upd0,upd1,upd2,xrId);
    }
}
