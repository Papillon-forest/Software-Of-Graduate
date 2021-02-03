package com.ks.glxt.graduateStudent.server.impl;

import com.ks.glxt.graduateStudent.dao.projectDaoI;
import com.ks.glxt.graduateStudent.entity.project;
import com.ks.glxt.graduateStudent.server.projectServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class projectServerImpl implements projectServerI {
    @Resource
    private projectDaoI pd;
    @Override
    public project saveProjectInfo(project pr) {
        project bypIdProjectInfo = pd.findBypIdProjectInfo(pr.getpId());
        if(bypIdProjectInfo==null || bypIdProjectInfo.getpId()==null){
            return pd.saveProjectInfo(pr);
        }
        return null;
    }

    @Override
    public project findBypIdProjectInfo(String pId) {
        project bypIdProjectInfo = pd.findBypIdProjectInfo(pId);
        return bypIdProjectInfo;
    }

    @Override
    public List<project> findByProjectInfoList() {
        return pd.findByProjectInfoList();
    }

    @Override
    public int updProjectInfo(String pId, String text) {
        return pd.updProjectInfo(pId,text);
    }

    /**
     * 研究生Id查看请求内容
     * @param pId
     * @return
     */
    @Override
    public List<project> findBypIdProject(String pId) {

        return pd.findBysIdProjectInfoList(pId);
    }
}
