package com.ks.glxt.subjectHead.controller;

import com.ks.glxt.exception.addValidation;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.subjectHead.entity.course;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.subjectHead.server.courseI;
import com.ks.glxt.subjectHead.server.subjectHeadFinalsServerI;
import com.ks.glxt.subjectHead.server.subjectVolunteerServerI;
import com.ks.glxt.util.ok;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * 学科负责人（controller）
 */
@RestController
@RequestMapping("/subjectHead")
public class subjectHeadController {
    @Resource
    private courseI co;
    @Resource
    private subjectVolunteerServerI sb;
    @Resource
    private subjectHeadFinalsServerI shs;
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json")
    public ok<course>  saveCourseInfo(@Validated({addValidation.class}) @RequestBody course cos){
        ok<course> o = new ok<>();
        ok<course> courseok = co.saveCourseInfo(cos);
        return courseok;
    }

    /**
     * 研究生查看课程信息也是这个接口
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
     * 最终表(修改自愿表并且添加最终表)
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

    @RequestMapping(value = "/findsList")
    public List<finals> findList(){
        return shs.findFinalsInfoList();
    }
}
