package com.ks.glxt.graduateStudent.server.impl;

import com.ks.glxt.graduateStudent.server.finalsServerI;
import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.entity.finals;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class finalsServerImpl implements finalsServerI {
    @Resource
    private FinalDaoI  fd;
    @Override
    public int updateFinalsInfo(String sId, String text) {
        int i = fd.updateBysIdFinalsInfoText(text, sId);
        return i;
    }

    @Override
    public finals selectFinals(String vId) {
        return fd.findByvIdFinalsInfo(vId);
    }
}
