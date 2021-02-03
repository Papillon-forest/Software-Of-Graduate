package com.ks.glxt.subjectHead.dao.impl;

import com.ks.glxt.subjectHead.dao.courseCrud;
import com.ks.glxt.subjectHead.entity.course;
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
public class courseCrudImpl implements courseCrud {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public course saveCourseInfo(course info) {
        String sql = "INSERT INTO Course (c_id,c_name,c_num,c_time,c_term,c_type,c_obj,c_pop,c_year,c_nums,c_money,c_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        int update = jdbc.update(sql, info.getcId(), info.getcName(), info.getcNum(), info.getcTime(), info.getcTerm(), info.getcType(), info.getcObj(), info.getcPop(), info.getcYear(), info.getcNums(), info.getcMoney(), info.getcCount());
        if(update>0){
            return info;
        }
        return null;
    }

    @Override
    public List<course> findByCourseInfoList() {
        String sql = "SELECT * FROM Course";
        List<Map<String, Object>> maps;
        List<Map<String,Object>> listMap = new ArrayList<>();
        try{
            maps = jdbc.queryForList(sql);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
        List<course> courses = new ArrayList<>();
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
            course c = new course();
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
    public course findByCidCourseInfo(String Cid) {
        String sql ="SELECT * FROM Course where c_id = ?";
        Map<String, Object> stringObjectMap = null;
        try{
            stringObjectMap  = jdbc.queryForMap(sql, Cid);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

        Map<String,Object> ms = new HashMap<>();
        course se = new course();
        for(String s: stringObjectMap.keySet()){
            String[] s1 = s.split("_");
            if(s1.length==2){
                ms.put(s1[0]+s1[1].substring(0,1).toUpperCase()+s1[1].substring(1),stringObjectMap.get(s));
            }else if( s1.length==3){
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
}
