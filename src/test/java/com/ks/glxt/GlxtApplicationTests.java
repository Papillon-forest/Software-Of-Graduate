package com.ks.glxt;

import com.ks.glxt.graduateStudent.dao.projectDaoI;
import com.ks.glxt.graduateStudent.dao.volunteerDaoI;
import com.ks.glxt.graduateStudent.dao.xueshuReportDaoI;
import com.ks.glxt.graduateStudent.entity.project;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.graduateStudent.entity.xueshuReport;
import com.ks.glxt.graduateStudent.server.finalsServerI;
import com.ks.glxt.graduateStudent.server.impl.finalsServerImpl;
import com.ks.glxt.graduateStudent.server.volunteerServerI;
import com.ks.glxt.publics.entity.user;
import com.ks.glxt.publics.server.userServerI;
import com.ks.glxt.subjectHead.dao.FinalDaoI;
import com.ks.glxt.subjectHead.dao.courseCrud;
import com.ks.glxt.subjectHead.dao.lessonCrud;
import com.ks.glxt.subjectHead.entity.course;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.subjectHead.entity.lesson;
import com.ks.glxt.subjectHead.server.courseI;
import com.ks.glxt.subjectHead.server.subjectHeadFinalsServerI;
import com.ks.glxt.subjectHead.server.subjectVolunteerServerI;
import com.ks.glxt.util.MD5Util;
import com.ks.glxt.util.ok;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@SpringBootTest
class GlxtApplicationTests {
//    @Resource
//    private projectDaoI ps;
//
//    @Resource
//    private subjectHeadFinalsServerI shs;
@Resource
private xueshuReportDaoI xrd;
    @Test
    void contextLoads() throws InvocationTargetException, IllegalAccessException {
//        lesson byIdLessonInfo = s.findByIdLessonInfo(12345678);
//        System.out.println(byIdLessonInfo.toString());
//        System.out.println(MD5Util.getMD5Str("123456"));
//
//        user user = us.login("张三", "123456");
//        System.out.println(user.toString());
//        List<course> courses = c.selectList();
//        courses.forEach(x->{System.out.println(x.toString());});
//        course byCidCourseInfo = c.findByCidCourseInfo("8789798324");
//        System.out.println(byCidCourseInfo.toString());
//        course cs = new course();
//
//        cs.setcId("asdas");
//        cs.setcMoney("sdfs");
//        cs.setcName("fgf");
//        cs.setcNum("asdgg");
//        cs.setcNums("tygh");
//        cs.setcObj("sadcxc");
//        cs.setcCount("grtwe");
//        cs.setcPop(10);
//        cs.setcTerm("sacc");
//        cs.setcTime("teq");
//        cs.setcType("dagg");
//        cs.setcYear("dfgdf");
//        ok<course> courseok = c.saveCourseInfo(cs);
//        System.out.println(courseok.getMessage());
//        user info = new user();
//        info.setuPwd("123456");
//        info.setuId(1234222);
//        info.setuName("asdggg");
//        info.setuRole(1);
//        ok<user> reg = us.reg(info);
//        System.out.println(reg.getMessage());

//        volunteer byvIdVolunteerInfo = vd.findByvIdVolunteerInfo("dasdads");
//        System.out.println(byvIdVolunteerInfo.toString());

//        List<volunteer> byVolunteerInfoList = vd.findByVolunteerInfoList();
//        byVolunteerInfoList.forEach(x->{System.out.println(x.toString());});

//        List<finals> finalsInfoList = s.findFinalsInfoList();
//        finalsInfoList.forEach(x->System.out.println(x.toString()));
//        List<finals> asdas = s.findByfIdFinalsInfoList("asdas");
//        asdas.forEach(x->{System.out.println(x.toString());});
//        s.updateBysIdFinalsInfo("空哦为我们球迷前往","抛开我离开了我的","grggfg");
//        finals f = new finals();
//        f.setfId("sadsadgg");
//        f.setfResult("faskjlkjowiuf");
//        f.setfTime("sjafjioiegg");
//        f.setReviewResult("asdjhjefef");
//        f.setReviewSuggestion("dajshfjhgkr");
//        f.setsId("adfgfghgh");
//        f.settId("fgfhgfhgfhfgh");
//        f.setvId("dasdads");
//        f.setWorkText("fpsiopfiops");
//        int i = sb.updateVolunteerInfo(f);
//        System.out.println(i);
//        volunteer v = new volunteer();
//        v.setcId("sdasd");
//        v.setsId("1");
//        v.setSendTime("dadgg");
//        v.settId("sadggg");
//        v.setvTime("dasfff");
//        volunteer volunteer = vs.addVolunteerInfo(v);
//        System.out.println(volunteer.toString());
//        finals d = new finals();
//        d.setvId("dasdads");
//        d.settId("fwyy");
//        d.setsId("rwqsd");
//        d.setfTime("sdadads");
//        d.setfResult("4");
//        d.setfId("fdlkfoefoefk");
//        int i = s.updateVolunteerInfo(d);
//        System.out.println(i);
//        List<project> byProjectInfoList = ps.findByProjectInfoList();
//        byProjectInfoList.forEach(x->System.out.println(x.toString()));

//        List<finals> finalsInfoList = shs.findFinalsInfoList();
//        finalsInfoList.forEach(x->{System.out.println(x.toString());});
        xueshuReport xs = new xueshuReport();
        xs.setsId("1");
        xs.setTlId("sdff");
        xs.setTlIs("qwerr");
        xs.setXrChina("adsds");
        xs.setXrId("dss");
        xrd.saveXueshuReportInfo(xs);
    }

}
