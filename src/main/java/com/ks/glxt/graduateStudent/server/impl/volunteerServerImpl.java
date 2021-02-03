package com.ks.glxt.graduateStudent.server.impl;

import com.ks.glxt.graduateStudent.dao.volunteerDaoI;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.graduateStudent.server.volunteerServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class volunteerServerImpl implements volunteerServerI {
    @Resource
    private volunteerDaoI vd;
    @Override
    public volunteer addVolunteerInfo(volunteer info) {
        info.setvId(UUID.randomUUID().toString());
        info.setSendId("3");//3是申请中 2是教师审核通过 1是教师和学科老师申请通过。
        volunteer byvIdVolunteerInfo = vd.findByvIdVolunteerInfo(info.getvId());
        if(byvIdVolunteerInfo==null || byvIdVolunteerInfo.getvId()==null){
            return vd.saveVolunteer(info);
        }
        return null;
    }

    @Override
    public volunteer selectVolunteerInfo(String vid) {

        return vd.findByvIdVolunteerInfo(vid);
    }

    @Override
    public List<volunteer> selectVolunteerInfoList() {
        return vd.findByVolunteerInfoList();
    }

    @Override
    public List<volunteer> findBySidVolunteerInfoList(String sId) {
        return vd.findBySidVolunteerInfoList(sId);
    }
}
