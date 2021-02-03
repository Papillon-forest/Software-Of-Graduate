package com.ks.glxt.pta.controller;

import com.ks.glxt.exception.addValidation;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.publics.entity.user;
import com.ks.glxt.publics.server.userServerI;
import com.ks.glxt.subjectHead.entity.course;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.subjectHead.server.courseI;
import com.ks.glxt.subjectHead.server.subjectVolunteerServerI;
import com.ks.glxt.util.ok;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/pat")
public class ptaController {
    @Resource
    private userServerI us;
    @Resource
    private courseI co;
    @Resource
    private subjectVolunteerServerI sb;
    /**
     * 注册用户
     * @param info
     * @return
     */
    @RequestMapping(value = "/reg",method = RequestMethod.POST,produces = "application/json")
    public ok<user> reg(@Validated({addValidation.class}) @RequestBody user info){
        ok<user> reg = us.reg(info);
        return reg;
    }


//    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json")
//    public ok<course>  saveCourseInfo(@Validated({addValidation.class}) @RequestBody course cos){
//        ok<course> o = new ok<>();
//        ok<course> courseok = co.saveCourseInfo(cos);
//        return courseok;
//    }

    /**
     * 研究生查看课程信息也是这个接口（课程查看）
     * @return
     */
    @RequestMapping(value = "/findList")
    public List<course> selectCourseInfoList(){
        return co.selectList();
    }

    /**
     * 通过状态查看 2
     * @return
     */
    @GetMapping("/selVolunteerInfo")
    public List<volunteer> selectBySendIdVolunteerInfo(@NotEmpty(message = "不能为空") @RequestParam String type){
        return sb.selectBySendIdVolunteerInfoList(type);
    }


    /**
     * 最终表(修改自愿表并且添加最终表) 查看助教志愿
     * @param info
     * @return
     */
    @PostMapping(value = "/updateVolInfo",produces = "application/json")
    public ok<String> updateVolunteerInf(@NotEmpty(message = "不能为空") @RequestBody finals info){
        int i = sb.updateVolunteerInfo(info);
        ok<String> ok = new ok<>();
        if(i>0){
            ok.setMessage("成功");
            ok.setStart("200");
        }else{
            ok.setMessage("失败");
            ok.setStart("400");
        }
        return ok;
    }


}
