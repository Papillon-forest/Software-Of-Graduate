package com.ks.glxt.graduateStudent.dao;

import com.ks.glxt.graduateStudent.entity.volunteer;

import java.util.List;

public interface volunteerDaoI {
    /**
     * 保存
     * @param info
     * @return
     */
    volunteer saveVolunteer(volunteer info);

    /**
     * 通过志愿Id 查找志愿信息
     * @param vId
     * @return
     */
    volunteer findByvIdVolunteerInfo(String vId);

    /**
     * 查询所有信息
     * @return
     */
    List<volunteer> findByVolunteerInfoList();

    /**
     * 修改
     * @param vId
     * @return
     */
    int updateVolunteerInfo(String sendId,String vId);

    /**
     * 删除
     * @param vId
     * @return
     */
    int delVolunteerInfo(String vId);

    /**
     * 通过老师Id查询已申请的志愿（授课老师是用这个接口）；
     * @param tId
     * @return
     */
    List<volunteer> findBytIdVolunteerInfoList(String tId);

    /**
     * 通过状态查找志愿申请情况
     * @param type
     * @return
     */
    List<volunteer> findBySendIdVolunteerInfoList(String type);

    /**
     * 通过研究生Id 查看申报的志愿信息
     * @param sId
     * @return
     */
    List<volunteer> findBySidVolunteerInfoList(String sId);
}
