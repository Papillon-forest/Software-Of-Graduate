package com.ks.glxt.instructor.server;

import com.ks.glxt.subjectHead.entity.finals;

import java.util.List;

public interface InstructorFinalServerI {
    /**
     * 修改 评论和助教结论
     * @param upd0
     * @param upd1
     * @param sId
     * @return
     */
    int updateFinalsInfo(String upd0,String upd1, String sId);

    /**
     *
     * @param tId
     * @return
     */
    List<finals> selectFinalsInfo(String tId);

    /**
     * 通过志愿表Id查最终表ID
     * @param vId
     * @return
     */
    finals selectByvIdFinalsInfo(String vId);
}
