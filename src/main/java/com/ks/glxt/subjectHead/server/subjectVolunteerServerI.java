package com.ks.glxt.subjectHead.server;

import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.subjectHead.entity.finals;

import java.util.List;

public interface subjectVolunteerServerI {
    /**
     * 通过志愿表Id修改志愿状态 学科老师 的状态为1
     * @param info
     * @return
     */
    int updateVolunteerInfo(finals info);

    /**
     * 通过状态查看状态为2的志愿
     * @param sendId
     * @return
     */
    List<volunteer> selectBySendIdVolunteerInfoList(String sendId);
}
