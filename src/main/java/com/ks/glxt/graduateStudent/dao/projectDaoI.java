package com.ks.glxt.graduateStudent.dao;

import com.ks.glxt.graduateStudent.entity.project;

import java.util.List;

public interface projectDaoI {
    /**
     * 保存project
     * @param po
     * @return
     */
    project saveProjectInfo(project po);

    /**
     * 通过 pId 查看 project
     * @param pId
     * @return
     */
    project findBypIdProjectInfo(String pId);

    /**
     * 查看所有project
     * @return
     */
    List<project> findByProjectInfoList();

    /**
     * 通过pId修改(这个是研究生修改项目跟进用的)
     *
     */
    int updProjectInfo(String pId,String text);

    /**
     * 这个是导师审核用的
     * @param pId
     * @param pTime
     * @param pStatus
     * @return
     */

    int updProjectInfo(String pId,String pTime,String pStatus);

    /**
     * 通过导师Id 查找 学生申请的资料
     * @param tId
     * @return
     */
    List<project> findBytIdProjectInfoList(String tId);

    /**
     *
     * @param sId 研究生Id
     * @return
     */
    List<project> findBysIdProjectInfoList(String sId);
}
