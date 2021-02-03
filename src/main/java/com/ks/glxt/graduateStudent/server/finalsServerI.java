package com.ks.glxt.graduateStudent.server;

import com.ks.glxt.subjectHead.entity.finals;

public interface finalsServerI {
    /**
     * 研究生修改工作自述的
     * @param sId
     * @param text
     * @return
     */
    int updateFinalsInfo(String sId,String text);

    /**
     * 通过自愿表Id来查finals 最终表的数据
     * @param vId
     * @return
     */
    finals selectFinals(String vId);

}
