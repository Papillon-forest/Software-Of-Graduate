package com.ks.glxt.subjectHead.server.impl;

import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.subjectHead.server.subjectHeadFinalsServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class subjectHeadFinalsServerImpl implements subjectHeadFinalsServerI {
    @Resource
    private FinalDaoI fi;
    @Override
    public List<finals> findFinalsInfoList() {
        return fi.findFinalsInfoList();
    }
}
