package com.ks.glxt.graduateStudent.server.impl;

import com.ks.glxt.graduateStudent.dao.xueshuReportDaoI;
import com.ks.glxt.graduateStudent.entity.xueshuReport;
import com.ks.glxt.graduateStudent.server.xueshuReportServerI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class xueshuReportServerImpl implements xueshuReportServerI {
    @Resource
    private xueshuReportDaoI xrd;
    @Override
    public xueshuReport saveXueshuReportInfo(xueshuReport xr) {
        xueshuReport byxRIdXueshuReportInfo = xrd.findByxRIdXueshuReportInfo(xr.getXrId());
        if(byxRIdXueshuReportInfo==null){
            xueshuReport xueshuReport = xrd.saveXueshuReportInfo(xr);
            return xueshuReport;
        }
        return null;
    }

    @Override
    public List<xueshuReport> findByXueshuReportInfoList() {
        return xrd.findByXueshuReportInfoList();
    }

    @Override
    public List<xueshuReport> findBytTidXueshuReportInfoList(String tId) {
        return xrd.findBytTidXueshuReportInfoList(tId);
    }

    @Override
    public List<xueshuReport> findBysIdXueshuReportInfoList(String sId) {
        return xrd.findBysIdXueshuReportInfoList(sId);
    }

    @Override
    public xueshuReport findByxRIdXueshuReportInfo(String xrId) {
        return xrd.findByxRIdXueshuReportInfo(xrId);
    }

    @Override
    public int updBytIdXueshuReportInfo(String xrId, String upd0, String upd1, String upd2) {
        return xrd.updBytIdXueshuReportInfo(xrId,upd0,upd1,upd2);
    }

    @Override
    public int updByXkXueshuReportInfo(String xrId, String upd0, String upd1, String upd2) {
        return xrd.updByXkXueshuReportInfo(xrId,upd0,upd1,upd2);
    }
}
