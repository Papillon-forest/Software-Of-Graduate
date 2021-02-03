package com.ks.glxt.subjectHead.server;

import com.ks.glxt.subjectHead.entity.lesson;
import com.ks.glxt.util.ok;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface lessonI {
    /**
     * 添加学科
     * @param info
     * @return
     */
    ok<lesson> addLessonInfo(lesson info) throws InvocationTargetException, IllegalAccessException;


    /**
     * 查看所有学科
     * @return
     */
    List<lesson> selectListLesson();


    /**
     * 删除学科
     * @param lId
     * @return
     */
    int deleteLesson(Integer lId);
}
