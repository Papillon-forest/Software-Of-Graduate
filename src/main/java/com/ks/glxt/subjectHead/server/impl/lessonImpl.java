package com.ks.glxt.subjectHead.server.impl;

import com.ks.glxt.subjectHead.dao.lessonCrud;
import com.ks.glxt.subjectHead.entity.lesson;
import com.ks.glxt.subjectHead.server.lessonI;
import com.ks.glxt.util.ok;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class lessonImpl implements lessonI {
    @Resource
    private lessonCrud less ;
    @Override
    public ok<lesson> addLessonInfo(lesson info) throws InvocationTargetException, IllegalAccessException {
        lesson byIdLessonInfo = less.findByIdLessonInfo(info.getlId());
        ok<lesson> s = new ok<>();
        if(byIdLessonInfo==null || byIdLessonInfo.getlId()==null){
            lesson lesson = less.saveLessonInfo(info);
            if(lesson!=null){
                s.setStart("200");
                s.setMessage("成功");
                s.setObject(lesson);
            }else{
                s.setStart("401");
                s.setMessage("服务器异常");
            }
        }else{
            s.setMessage("已存在");
            s.setStart("400");

        }
        return s;
    }

    @Override
    public List<lesson> selectListLesson() {

        return less.findByLessonInfo();
    }

    @Override
    public int deleteLesson(Integer lId) {
        return less.deleteLessonInfo(lId);
    }
}
