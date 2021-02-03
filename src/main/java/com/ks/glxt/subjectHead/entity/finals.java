package com.ks.glxt.subjectHead.entity;

/**
 *  fId 主键，终选ID
 *  fResult 审核结果
 *  fTime 审核时间
 *  sId 研究生id
 *  workText 工作自述
 *  tId 教师id
 *  reviewResult 评价结果
 *  reviewSuggestion 评价意见
 *  vId 志愿Id
 */
public class finals {
   private String  fId;
   private String fResult;
   private String fTime;
   private String sId;
   private String workText;
   private String tId;
   private String reviewResult;
   private String reviewSuggestion;
   private String  vId;

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getfResult() {
        return fResult;
    }

    public void setfResult(String fResult) {
        this.fResult = fResult;
    }

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getReviewResult() {
        return reviewResult;
    }

    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    public String getReviewSuggestion() {
        return reviewSuggestion;
    }

    public void setReviewSuggestion(String reviewSuggestion) {
        this.reviewSuggestion = reviewSuggestion;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    @Override
    public String toString() {
        return "finals{" +
                "fId='" + fId + '\'' +
                ", fResult='" + fResult + '\'' +
                ", fTime='" + fTime + '\'' +
                ", sId='" + sId + '\'' +
                ", workText='" + workText + '\'' +
                ", tId='" + tId + '\'' +
                ", reviewResult='" + reviewResult + '\'' +
                ", reviewSuggestion='" + reviewSuggestion + '\'' +
                ", vId='" + vId + '\'' +
                '}';
    }
}
