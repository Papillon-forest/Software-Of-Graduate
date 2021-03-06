package com.ks.glxt.subjectHead.controller;

import com.ks.glxt.graduateStudent.entity.xueshuReport;
import com.ks.glxt.graduateStudent.server.xueshuReportServerI;
import com.ks.glxt.util.ok;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/subXueShu")
public class subjectXueshuReportController {
    @Resource
    private xueshuReportServerI xrsi;

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public ok<List<xueshuReport>> findXueShuReportInfoList(){
        ok<List<xueshuReport>> oks = new ok<>();
        List<xueshuReport> byXueshuReportInfoList = xrsi.findByXueshuReportInfoList();
        if(byXueshuReportInfoList.size()>0){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(byXueshuReportInfoList);
        }else{
            oks.setMessage("查询成功，无数据");
            oks.setStart("200");
        }
        return oks;
    }

    @RequestMapping(value = "/findXrId",method = RequestMethod.POST)
    public ok<xueshuReport> findBypIdXueShuReportInfoList(@NotEmpty @RequestParam(value = "xrId") String xrId){
        ok<xueshuReport> oks = new ok<>();
        xueshuReport byxRIdXueshuReportInfo = xrsi.findByxRIdXueshuReportInfo(xrId);
        if(byxRIdXueshuReportInfo!=null){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(byxRIdXueshuReportInfo);
        }else{
            oks.setMessage("查询成功，无数据");
            oks.setStart("200");
        }
        return oks;
    }


    @RequestMapping(value = "/updReportInfo",method = RequestMethod.POST)//学科负责人0是通过 1是不通过
    public ok<String> updReportInfo(String xrId,String upd0,String upd1,String upd2){
        int i = xrsi.updByXkXueshuReportInfo(xrId, upd0, upd1, upd2);
        ok<String> oks = new ok<>();
        if(i>0){
            oks.setStart("200");
            oks.setMessage("修改成功");
        }else{
            oks.setStart("400");
            oks.setMessage("修改失败");
        }
        return oks;
    }
}
