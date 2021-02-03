package com.ks.glxt.mentor.controller;

import com.ks.glxt.graduateStudent.entity.project;
import com.ks.glxt.mentor.server.mentorProjectServerI;
import com.ks.glxt.util.ok;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/mentorPro")
public class mentorProjectController {
    @Resource
    private mentorProjectServerI mps;

    /**
     * 通过老师Id查看研究生的申请
     * @param tId
     * @return
     */
    @RequestMapping(value = "/selProList",method = RequestMethod.POST)
    public ok<List<project>> selectProjectList(@NotEmpty @RequestParam(name = "tId") String tId){
        ok<List<project>> list = new ok<>();
        List<project> bytIdProjectInfoList = mps.findBytIdProjectInfoList(tId);
        list.setStart("200");
        list.setMessage("success");
        list.setObject(bytIdProjectInfoList);
        return list;
    }

    /**
     * 通过老师 申请表Id 修改申请和审批
     * @param pId
     * @param time
     * @param start
     * @return
     */
    @RequestMapping(value = "/updPro",method = RequestMethod.POST)
    public ok<String> updProjectInfo(@NotEmpty @RequestParam(name = "pId") String pId,@NotEmpty @RequestParam(name = "time") String time,@NotEmpty @RequestParam(name = "start") String start){
        ok<String> s = new ok<>();
        int i = mps.updateProjectInfo(pId, time, start);
        if(i>0){
            s.setMessage("修改成功");
            s.setStart("200");
        }else{
            s.setMessage("修改失败");
            s.setStart("400");
        }
        return s;
    }

    @RequestMapping(value = "/findProjectInfo")
    public ok<project> selectProjectInfo(@NotEmpty @RequestParam(name = "pId") String pId){
        ok<project> oks = new ok<>();
        project bypIdProjectInfoList = mps.findBypIdProjectInfoList(pId);
        if(bypIdProjectInfoList!=null){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(bypIdProjectInfoList);

        }else{
            oks.setMessage("查询成功，没有值");
            oks.setStart("200");
        }
        return oks;
    }
}
