package com.ks.glxt.subjectHead.server.impl;

import com.ks.glxt.subjectHead.dao.courseCrud;


import com.ks.glxt.subjectHead.entity.course;
import com.ks.glxt.subjectHead.server.courseI;
import com.ks.glxt.util.ok;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class courseImpl implements courseI {
    @Resource
    private courseCrud cd;
    @Override
    public ok<course> saveCourseInfo(course info) {
        course byCidCourseInfo = cd.findByCidCourseInfo(info.getcId());
        ok<course> oks = new ok<>();
        if(byCidCourseInfo!=null && byCidCourseInfo.getcId()!=null){
            oks.setMessage("error,已存在");
            oks.setStart("200");
        }else{
            course course = cd.saveCourseInfo(info);
            if(course!=null){
                oks.setStart("200");
                oks.setMessage("成功");
            }
        }
        return oks;
    }

    @Override
    public List<course> selectList() {
        return cd.findByCourseInfoList();
    }
}
