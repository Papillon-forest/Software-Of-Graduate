package com.ks.glxt.subjectHead.server;

import com.ks.glxt.subjectHead.entity.course;
import com.ks.glxt.util.ok;

import java.util.List;

public interface courseI {
    /** 保存课程
     * @param info
     * @return
     */
    ok<course> saveCourseInfo(course info);

    /**
     * 查看课程（所有）
     * @return
     */
    List<course> selectList();
}
