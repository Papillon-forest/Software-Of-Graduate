package com.ks.glxt.mentor.server;

import com.ks.glxt.graduateStudent.entity.project;

import java.util.List;

public interface mentorProjectServerI {
    /**
     * 通过导师Id查找申请信息
     * @param tId
     * @return
     */
    List<project> findBytIdProjectInfoList(String tId);

    /**
     * 通过pId修改信息
     * @param pId
     * @return
     */
    int updateProjectInfo(String pId,String upd0,String upd1);

    /**
     * 通过申请表Id查看申请表状态
     * @param pId
     * @return
     */
    project findBypIdProjectInfoList(String pId);
}
