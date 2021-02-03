package com.ks.glxt.subjectHead.dao.impl;

import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.entity.finals;
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
public class FinalDaoImpl implements FinalDaoI {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public finals saveFinals(finals info) {
        String sql = "insert into Final (f_id,f_result,f_time,s_id,work_text,t_id,review_result,review_suggestion,v_id) VALUES (?,?,?,?,?,?,?,?,?)";
        int update = jdbc.update(sql, info.getfId(), info.getfResult(), info.getfTime(), info.getsId(), info.getWorkText(), info.gettId(), info.getReviewResult(), info.getReviewSuggestion(), info.getvId());
        if(update>0){
            return info;
        }
        return null;
    }

    @Override
    public List<finals> findFinalsInfoList() {
        String sql = "SELECT * FROM Final";
        List<Map<String, Object>> maps;
        List<Map<String,Object>> listMap = new ArrayList<>();
        try{
            maps = jdbc.queryForList(sql);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        List<finals> courses = new ArrayList<>();
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
            finals c = new finals();
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
    public List<finals> findBysIdFinalsInfoList(String sId) {
        String sql = "SELECT * FROM Final where s_id = ?";
        List<Map<String, Object>> maps;
        List<Map<String,Object>> listMap = new ArrayList<>();
        try{
            maps = jdbc.queryForList(sql,sId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        List<finals> courses = new ArrayList<>();
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
            finals c = new finals();
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
    public List<finals> findBytIdFinalsInfoList(String tId) {
        String sql = "SELECT * FROM Final where t_id = ?";
        List<Map<String, Object>> maps;
        List<Map<String,Object>> listMap = new ArrayList<>();
        try{
            maps = jdbc.queryForList(sql,tId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        List<finals> courses = new ArrayList<>();
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
            finals c = new finals();
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
    public List<finals> findByfIdFinalsInfoList(String fId) {
        String sql = "SELECT * FROM Final where f_id = ?";
        List<Map<String, Object>> maps;
        List<Map<String,Object>> listMap = new ArrayList<>();
        try{
            maps = jdbc.queryForList(sql,fId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        List<finals> courses = new ArrayList<>();
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
            finals c = new finals();
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

    /**
     * 志愿Id
     * @param vId
     * @return
     */
    @Override
    public finals findByvIdFinalsInfo(String vId) {
        String sql = "SELECT * FROM Final WHERE v_id = ?";
        Map<String, Object> stringObjectMap = null;
        try{
            stringObjectMap  = jdbc.queryForMap(sql, vId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        Map<String,Object> ms = new HashMap<>();
        finals se = new finals();
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

    /**
     *
     * @param upd1 评价结果
     * @param upd2 评价意见
     * @param vId  研究生Id
     * @return
     */
    @Override
    public int updateBysIdFinalsInfo(String upd1,String upd2,String vId) {
        String sql = "UPDATE  Final SET review_result= ?,review_suggestion=? WHERE v_id = ?";
        int update = jdbc.update(sql,upd1, upd2,vId);
        return update;
    }

    /**
     * 工作自述的
     * @param upd0 工作自述
     * @param vId 研究生id
     * @return
     */
    @Override
    public int updateBysIdFinalsInfoText(String upd0, String vId) {
        String sql = "UPDATE  Final SET work_text = ? WHERE v_id = ?";
        int update = jdbc.update(sql,upd0,vId);
        return update;
    }
}
