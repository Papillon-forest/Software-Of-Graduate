package com.ks.glxt.instructor.server.impl;

import com.ks.glxt.graduateStudent.dao.volunteerDaoI;
import com.ks.glxt.graduateStudent.entity.volunteer;

import com.ks.glxt.instructor.server.instructorVolunteerServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InstructorVolunteerServerImpl implements instructorVolunteerServerI {
    @Resource
    private volunteerDaoI vd;
    @Override
    public Integer updateVolunteer(String vId) {
        int i = vd.updateVolunteerInfo("2",vId);//授课教师审核通过后状态是2
        return i;
    }

    @Override
    public List<volunteer> findBytIdVolunteerInfoList(String tId) {
        List<volunteer> bytIdVolunteerInfoList = vd.findBytIdVolunteerInfoList(tId);
        return bytIdVolunteerInfoList;
    }
}
