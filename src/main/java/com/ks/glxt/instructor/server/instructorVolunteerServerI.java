package com.ks.glxt.instructor.server;

import com.ks.glxt.graduateStudent.entity.volunteer;

import java.util.List;

public interface instructorVolunteerServerI {
    /**
     * 通过 申请表Id修改申请状态 教师同意后 将状态修改成2
     * @param vId
     * @return
     */
    Integer updateVolunteer(String vId);

    /**
     * 通过教师Id 查看申请表
     * @param tId
     * @return
     */
    List<volunteer>  findBytIdVolunteerInfoList(String tId);
}
