package com.ks.glxt.subjectHead.dao.impl;

import com.ks.glxt.subjectHead.dao.lessonCrud;
import com.ks.glxt.subjectHead.entity.lesson;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LessonCrudImpl implements lessonCrud {
    @Resource
    private JdbcTemplate jdbc;
    @Override
    public lesson saveLessonInfo(lesson info) {
        String sql = "INSERT into Lesson (l_id,l_name,l_intro,a_id,l_type_id) VALUES (?,?,?,?,?)";
        int update = jdbc.update(sql, info.getlId(), info.getlName(), info.getlIntro(), info.getaId(), info.getlTypeId());
        if(update>0){
            return info;
        }
        return null;
    }

    @Override
    public List<lesson> findByLessonInfo() {
        String sql = "select * from lesson";
        List<lesson> lessons = jdbc.queryForList(sql, lesson.class);
        return lessons;
    }

    @Override
    public lesson findByIdLessonInfo(Integer lid) throws InvocationTargetException, IllegalAccessException {
        lesson se = new lesson();
        String sql = "select * from lesson where l_id = ?";
        Map<String, Object> stringObjectMap = jdbc.queryForMap(sql, lid);
        Map<String,Object> maps = new HashMap();
        for(String x :stringObjectMap.keySet()){
            String[] s = x.split("_");
            if(s.length==2){
                maps.put(s[0]+s[1].substring(0,1).toUpperCase()+s[1].substring(1),stringObjectMap.get(x));
            }else if( s.length==3){
                maps.put(s[0]+s[1].substring(0,1).toUpperCase()+s[1].substring(1)+s[2].substring(0,1).toUpperCase()+s[2].substring(1),stringObjectMap.get(x));
            }else{
                maps.put(s[0],stringObjectMap.get(x));
            }
        }
        BeanUtils.populate(se,maps);
        return se;
    }

    @Override
    public int deleteLessonInfo(Integer lId) {
        String sql = "delete from lesson where l_id = ?";
        int update = jdbc.update(sql, lId);
        return update;
    }
}
