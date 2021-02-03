package com.ks.glxt.graduateStudent.server;

import com.ks.glxt.graduateStudent.entity.project;

import java.util.List;

public interface projectServerI  {
    /**
     * project 保存信息
     * @param pr
     * @return
     */
    project saveProjectInfo (project pr);


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
     * 通过pId查看信息
     * @param pId
     * @return
     */
    List<project> findBypIdProject(String pId);
}
