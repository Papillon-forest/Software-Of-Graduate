package com.ks.glxt.graduateStudent.dao;

import com.ks.glxt.graduateStudent.entity.xueshuReport;

import java.util.List;

public interface xueshuReportDaoI  {
    /**
     * 添加学术交流的
     * @param xr
     * @return
     */
    xueshuReport saveXueshuReportInfo(xueshuReport xr);

    /**
     * 查看所有学术交流
     * @return
     */
    List<xueshuReport> findByXueshuReportInfoList();


    /**
     * 通过导师Id查看学术交流
     * @param tId 通过导师Id 查看学术交流
     * @return
     */
    List<xueshuReport> findBytTidXueshuReportInfoList(String tId);

    /**
     * 通过研究生Id查看学术交流
     * @param sId
     * @return
     */
    List<xueshuReport> findBysIdXueshuReportInfoList(String sId);

    /**
     * 通过学术交流表Id查
     * @param xrId
     * @return
     */
    xueshuReport findByxRIdXueshuReportInfo(String xrId);

    /**
     * 导师修改
     * @param xrId 学术Id
     * @param upd0 审核状态 导师是2
     * @param upd1 审核时间
     * @param upd2 签字
     * @return
     */
    int updBytIdXueshuReportInfo(String xrId,String upd0,String upd1,String upd2);

    /**
     * 学科负责人
     * @param xrId 学术表Id
     * @param upd0 审核状态 学科负责人是1
     * @param upd1 审核时间
     * @param upd2 签字
     * @return
     */
    int updByXkXueshuReportInfo(String xrId,String upd0,String upd1,String upd2);

}
