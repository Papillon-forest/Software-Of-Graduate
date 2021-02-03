package com.ks.glxt.subjectHead.dao;

import com.ks.glxt.subjectHead.entity.course;

import java.util.List;

public interface courseCrud {
    /**
     * 添加学科
     * @param info
     * @return
     */
    course saveCourseInfo(course info);

    /**
     * 查询所有课程信息信息
     * @return
     */
    List<course> findByCourseInfoList();

    /**
     * 通过ID查找课程信息
     */
    course findByCidCourseInfo(String Cid);
}
