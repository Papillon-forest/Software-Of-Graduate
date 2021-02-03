package com.ks.glxt.instructor.server.impl;

import com.ks.glxt.instructor.server.InstructorFinalServerI;
import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.entity.finals;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InstructorFinalServerImpl implements InstructorFinalServerI {
    @Resource
    private FinalDaoI fd;
    @Override
    public int updateFinalsInfo(String upd0, String upd1, String sId) {
        int i = fd.updateBysIdFinalsInfo(upd0, upd1, sId);
        return i;
    }

    @Override
    public List<finals> selectFinalsInfo(String tId) {
        List<finals> bytIdFinalsInfoList = fd.findBytIdFinalsInfoList(tId);
        return bytIdFinalsInfoList;
    }

    @Override
    public finals selectByvIdFinalsInfo(String vId) {
        return fd.findByvIdFinalsInfo(vId);
    }
}
