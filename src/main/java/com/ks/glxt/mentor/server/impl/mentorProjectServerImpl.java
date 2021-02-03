package com.ks.glxt.mentor.server.impl;

import com.ks.glxt.graduateStudent.dao.projectDaoI;
import com.ks.glxt.graduateStudent.entity.project;
import com.ks.glxt.mentor.server.mentorProjectServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class mentorProjectServerImpl implements mentorProjectServerI {
    @Resource
    private projectDaoI pri;

    /**
     * 通过教师Id
     * @param tId
     * @return
     */
    @Override
    public List<project> findBytIdProjectInfoList(String tId) {
        List<project> bytIdProjectInfoList = pri.findBytIdProjectInfoList(tId);
        return bytIdProjectInfoList;
    }

    /**
     *
     * @param pId 申请表Id
     * @param upd0 审批时间
     * @param upd1 审批状态 1通过 2不通过
     * @return
     */
    @Override
    public int updateProjectInfo(String pId,String upd0,String upd1) {
        return pri.updProjectInfo(pId,upd0,upd1);
    }

    /**
     * 通过申请表Id查看 详细内容
     * @param pId
     * @return
     */
    @Override
    public project findBypIdProjectInfoList(String pId) {
        return pri.findBypIdProjectInfo(pId);
    }
}
