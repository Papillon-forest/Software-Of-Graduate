package com.ks.glxt.graduateStudent.controller;

import com.ks.glxt.graduateStudent.entity.xueshuReport;
import com.ks.glxt.graduateStudent.server.xueshuReportServerI;
import com.ks.glxt.util.ok;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping(value = "/xsReport")
public class xueshuReportController {
    @Resource
    private xueshuReportServerI xrsi;

    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {
        try (FileOutputStream out = new FileOutputStream("/" + file.getOriginalFilename())){
            out.write(file.getBytes());
            System.out.println(file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();

            return "uploading failure";
        }

        return file.getOriginalFilename();
    }


    @RequestMapping("/download")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String xrId = request.getParameter("xrId");
        xueshuReport byxRIdXueshuReportInfo = xrsi.findByxRIdXueshuReportInfo(xrId);
        File file = new File("/"+byxRIdXueshuReportInfo.getXrProve());
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("点赞字段.png","utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json")
    public ok<xueshuReport> saveXueshuReportInfo(@RequestBody xueshuReport xr){
        ok<xueshuReport> oks = new ok<>();
        xueshuReport xueshuReport = xrsi.saveXueshuReportInfo(xr);
        if(xueshuReport==null){
            oks.setMessage("添加失败，请检查学术报告ID是否与数据库中存在的Id重复");
            oks.setStart("200");
        }else{
            oks.setMessage("成功");
            oks.setObject(xueshuReport);
            oks.setStart("200");
        }
        return null;
    }
    @RequestMapping(value = "/findsId",method = RequestMethod.POST)
    public ok<List<xueshuReport>> findXueShuReportInfoList(@NotEmpty @RequestParam(name = "sId") String sId){
        List<xueshuReport> bysIdXueshuReportInfoList = xrsi.findBysIdXueshuReportInfoList(sId);
        ok<List<xueshuReport>> oks = new ok<>();
        if(bysIdXueshuReportInfoList.size()>0){
            oks.setStart("200");
            oks.setMessage("查询成功");
            oks.setObject(bysIdXueshuReportInfoList);
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

}
