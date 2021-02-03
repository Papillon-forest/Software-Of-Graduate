package com.ks.glxt.subjectHead.server.impl;

import com.ks.glxt.graduateStudent.dao.volunteerDaoI;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.subjectHead.server.subjectVolunteerServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class subjectVolunteerServerImpl implements subjectVolunteerServerI {
    @Resource
    private volunteerDaoI vd;
    @Resource
    private FinalDaoI fd;
    @Override
    public int updateVolunteerInfo(finals info) {
        int i = vd.updateVolunteerInfo("1", info.getvId());
        if(i>0){
            finals finals = fd.saveFinals(info);
            if(finals!=null){
                return i;
            }else{
                vd.updateVolunteerInfo("2", info.getvId());
            }

        }
        return 0;
    }

    @Override
    public List<volunteer> selectBySendIdVolunteerInfoList(String sendId) {
        return vd.findBySendIdVolunteerInfoList(sendId);
    }
}
