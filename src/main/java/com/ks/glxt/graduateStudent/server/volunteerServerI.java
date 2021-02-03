package com.ks.glxt.graduateStudent.server;

import com.ks.glxt.graduateStudent.entity.volunteer;

import java.util.List;

public interface volunteerServerI  {
    /**
     * 保存
     * @param info
     * @return
     */
    volunteer addVolunteerInfo(volunteer info);

    /**
     * 通过Id查看
     * @param vid
     * @return
     */
    volunteer selectVolunteerInfo(String vid);

    /**
     * 查看所有(志愿)
     * @return
     */
    List<volunteer> selectVolunteerInfoList();

    /**
     * 通过研究生Id 查看申报的志愿信息
     * @param sId
     * @return
     */
    List<volunteer> findBySidVolunteerInfoList(String sId);
}
