package com.ks.glxt.subjectHead.dao;

import com.ks.glxt.subjectHead.entity.finals;

import java.util.List;

public interface FinalDaoI {
    /**
     * 保存最终结果
     * @param info
     * @return
     */
    finals saveFinals(finals info);

    /**
     * 查看所有最终结果
     * @return
     */
    List<finals> findFinalsInfoList();

    /**
     * 通过研究生Id 查看最终结果
     *  @param sId
     * @return
     */
   List<finals> findBysIdFinalsInfoList(String sId);

    /**
     * 通过授课老师Id查看 最终结果
     * @param tId
     * @return
     */
   List<finals> findBytIdFinalsInfoList(String tId);


    /**
     * 通过最终结果表Id查看
     * @param fId
     * @return
     */
   List<finals> findByfIdFinalsInfoList(String fId);

    /**
     * 通过志愿Id查看最终
     * @param vId
     * @return
     */
   finals findByvIdFinalsInfo(String vId);
    /**
     * 通过研究生修改最终表结果（ 这个是导师修改的结果表）
     * @param sId
     * @return
     */
   int updateBysIdFinalsInfo(String upd1,String upd2,String sId);

    /**
     * 研究生工作自述（研究生自己修改的）
     * @param upd0
     * @param sId
     * @return
     */
   int updateBysIdFinalsInfoText(String upd0,String sId);

}
