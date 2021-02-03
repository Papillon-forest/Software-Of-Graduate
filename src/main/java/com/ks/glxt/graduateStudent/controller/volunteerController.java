package com.ks.glxt.graduateStudent.controller;

import com.ks.glxt.exception.addValidation;
import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.graduateStudent.server.finalsServerI;
import com.ks.glxt.graduateStudent.server.volunteerServerI;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.util.ok;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class volunteerController {
    @Resource
    private volunteerServerI vs;
    @Resource
    private finalsServerI fs;
    @RequestMapping(value = "/addVol",method = RequestMethod.POST,produces = "application/json")
    public ok<volunteer> addVolunteer(@Validated({addValidation.class}) @RequestBody  volunteer info){
        ok<volunteer> ok = new ok<>();
        volunteer volunteer = vs.addVolunteerInfo(info);
        if(volunteer==null){
            ok.setMessage("添加失败");
            ok.setStart("200");
        }else{
            ok.setMessage("添加成功");
            ok.setStart("200");
            ok.setObject(volunteer);
        }
        return ok;
    }

    @RequestMapping(value = "/selByvId",method = RequestMethod.POST)
    public  ok<volunteer> selectByvIdVolunteerInfo(@NotEmpty(message = "不能为空") @RequestParam String vId){
        ok<volunteer>  ok = new ok<>();
        volunteer volunteer = vs.selectVolunteerInfo(vId);
        if(volunteer!=null){
            ok.setObject(volunteer);
            ok.setStart("200");
            ok.setMessage("成功");
        }else{
            ok.setStart("400");
            ok.setMessage("失败");
        }
        return ok;
    }

    /**
     * 通过研究生Id
     * @param sId
     * @return
     */
    @RequestMapping(value = "/selBySid",method = RequestMethod.POST)
    public  ok<List<volunteer>> selectBySidVolunteerInfo(@NotEmpty(message = "不能为空") @RequestParam String sId){
        ok<List<volunteer>> ok = new ok<>();
        List<volunteer> bySidVolunteerInfoList = vs.findBySidVolunteerInfoList(sId);
        if(bySidVolunteerInfoList.size()>0){
            ok.setObject(bySidVolunteerInfoList);
            ok.setStart("200");
            ok.setMessage("成功");
        }else{
            ok.setStart("400");
            ok.setMessage("失败");
        }
        return ok;
    }





    @RequestMapping(value = "/selList",method = RequestMethod.GET)
    public ok<List<volunteer>> selectByVolunteerList(){
        ok<List<volunteer>> oks = new ok<>();
        List<volunteer> volunteers = vs.selectVolunteerInfoList();
        if(volunteers.size()>0){
            oks.setMessage("查询成功");
            oks.setStart("200");
            oks.setObject(volunteers);
        }
        return oks ;
    }

    /**
     * 修改最终表的
     * @param text
     * @param sId
     * @return
     */
    @RequestMapping(value = "/updFinals",method = RequestMethod.POST)
    public ok<String> updateFinalsInfo(@NotEmpty @RequestParam(name = "text") String text,@NotEmpty @RequestParam(name = "sId") String sId){
        int i = fs.updateFinalsInfo(sId, text);
        ok<String> ok = new ok<>();
        if(i>0){
            ok.setStart("200");
            ok.setMessage("成功");
        }else{
            ok.setMessage("400");
            ok.setMessage("失败");
        }
        return ok;
    }

    /**
     * 通过志愿Id查找最终表
     * @param vId
     * @return
     */
    @RequestMapping(value = "/selectFinalsInfo",method = RequestMethod.POST)
    public ok<finals> selectFinalsInfo(@NotEmpty @RequestParam(value = "vId") String vId){
        ok<finals> oks = new ok<>();
        finals finals = fs.selectFinals(vId);
        if(finals!=null){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(finals);
        }else{
            oks.setStart("200");
            oks.setMessage("查询成功，无数据返回");
        }
        return oks;
    }

}
