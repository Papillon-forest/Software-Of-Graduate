package com.ks.glxt.instructor.controller;

import com.ks.glxt.graduateStudent.entity.volunteer;
import com.ks.glxt.instructor.server.InstructorFinalServerI;
import com.ks.glxt.instructor.server.instructorVolunteerServerI;
import com.ks.glxt.subjectHead.entity.finals;
import com.ks.glxt.util.ok;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class instructorController {

    @Resource
    private instructorVolunteerServerI ivs;
    @Resource
    private InstructorFinalServerI ifs;

    @PostMapping("/updVol")
    public ok<String> updateVolunteerController(@NotEmpty(message = "不能为空") @RequestParam String vId){
        ok<String> ko = new ok<>();
        Integer integer = ivs.updateVolunteer(vId);
        if(integer>0){
            ko.setMessage("提交成功！");
            ko.setStart("200");

        }else{
            ko.setMessage("失败！");
            ko.setStart("400");
        }
        return ko;
    }

    @PostMapping("/select")
    public ok<List<volunteer>> selectVolunteerListInfo(@NotEmpty @RequestParam String tId){
        ok<List<volunteer>> ok = new  ok<>();
        List<volunteer> bytIdVolunteerInfoList = ivs.findBytIdVolunteerInfoList(tId);
        ok.setStart("200");
        ok.setMessage("success");
        ok.setObject(bytIdVolunteerInfoList);
        return ok;
    }


    @PostMapping(value = "/updFinalsInfo")
    public ok<String> updateFinalsInfo(@NotEmpty @RequestParam(name = "upd0") String upd0,@NotEmpty @RequestParam(name = "upd1") String upd1,@NotEmpty @RequestParam(name = "sId") String sId){
        ok<String> oks = new ok<>();
        int i = ifs.updateFinalsInfo(upd0, upd1, sId);
        if(i>0){
            oks.setMessage("成功");
            oks.setStart("200");
        }else{
            oks.setMessage("失败");
            oks.setStart("400");
        }
        return oks;
    }


    @PostMapping(value = "/selFinalsInfo")
    public ok<List<finals>> selectFinalsInfo(@NotEmpty @RequestParam(name = "tId") String tId){
        List<finals> finals = ifs.selectFinalsInfo(tId);
        ok<List<finals>> oks =new ok<>();
        if(finals.size()>0){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(finals);
        }else{
            oks.setStart("200");
            oks.setMessage("查询成功，无结果");
        }
        return oks;
    }


    /**
     * 通过志愿Id查找最终表
     * @param vId
     * @return
     */
    @RequestMapping(value = "/selectFinalsInfo",method = RequestMethod.GET)
    public ok<finals> selectFinalsInfos(@NotEmpty @RequestParam(value = "vId") String vId){
        ok<finals> oks = new ok<>();
        finals finals = ifs.selectByvIdFinalsInfo(vId);
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
