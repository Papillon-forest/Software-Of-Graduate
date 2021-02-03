package com.ks.glxt.graduateStudent.controller;

import com.ks.glxt.exception.addValidation;
import com.ks.glxt.graduateStudent.entity.project;
import com.ks.glxt.graduateStudent.server.projectServerI;
import com.ks.glxt.util.ok;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequestMapping(value = "/project")
public class projectController {
    @Resource
    private projectServerI psi;
    @RequestMapping(value = "/addPro",method = RequestMethod.POST,produces = "application/json")
    public ok<project> saveProjectInfo (@Validated({addValidation.class}) @RequestBody project info){
        project project = psi.saveProjectInfo(info);
        ok<project> oks = new ok<>();
        if(project==null){
            oks.setMessage("保存失败，主键已存在");
            oks.setStart("400");
        } else if(Integer.parseInt(project.getpMoney())<=60000) {
            oks.setMessage("项目经费不符合要求");
            oks.setStart("400");
        } else {
            oks.setMessage("成功");
            oks.setStart("200");
            oks.setObject(project);
        }
        return oks;
    }

    @RequestMapping(value = "/selPro",method = RequestMethod.POST)
    public ok<project> selectProjectInfo(@NotEmpty @RequestParam(name = "pId") String pId) {
        project bypIdProjectInfo = psi.findBypIdProjectInfo(pId);
        ok<project> oks = new ok<>();
        if(bypIdProjectInfo!=null){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(bypIdProjectInfo);
        }else{
            oks.setMessage("查询成功，没有数据");
            oks.setStart("200");
        }

        return oks;
    }

    /**
     * 通过申请后学生填写的后续内容（学生修改）
     * @param pId
     * @param text
     * @return
     */
    @RequestMapping(value = "/updPro",method = RequestMethod.POST)
    public ok<String> updateProInfo(@NotEmpty @RequestParam(name = "pId") String pId,@NotEmpty @RequestParam(name = "text") String text){
        ok<String> oks = new ok<>();
        int i = psi.updProjectInfo(pId, text);
        if(i>0){
            oks.setMessage("修改成功");
            oks.setStart("200");
        }else{
            oks.setMessage("修改失败");
            oks.setStart("400");
        }
        return oks;
    }


    /**
     * 通过 研究生Id查找
     * @param pId
     * @return
     */
    @RequestMapping(value = "/findProjectInfo")
    public ok<List<project>> selectProject(@NotEmpty @RequestParam(name = "pId") String pId){
        ok<List<project>> oks = new ok<>();
        List<project> bypIdProject = psi.findBypIdProject(pId);
        if(bypIdProject.size()>0){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(bypIdProject);
        }else{
            oks.setStart("200");
            oks.setMessage("查询成功，没有数据");
        }
        return oks;
    }
}
