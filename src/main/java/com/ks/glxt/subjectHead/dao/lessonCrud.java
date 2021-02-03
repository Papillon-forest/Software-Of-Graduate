package com.ks.glxt.subjectHead.dao;

import com.ks.glxt.subjectHead.entity.lesson;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 科目管理员的增删改查
 */
public interface lessonCrud {
    /**
     * 添加学科信息
     * @param info 学科信息
     * @return
     */
    lesson saveLessonInfo(lesson info);

    /**
     * 查询所有学科信息
     * @return
     */
    List<lesson> findByLessonInfo();

    /**
     * 通过学科Id查询学科信息
     * @param lid
     * @return
     */
    lesson findByIdLessonInfo(Integer lid) throws InvocationTargetException, IllegalAccessException;

    /**
     * 通过学科id删除学科信息
     * @param lId 学科id
     * @return
     */
    int deleteLessonInfo(Integer lId);
}
