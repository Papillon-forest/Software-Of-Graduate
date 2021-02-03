package com.ks.glxt.subjectHead.entity;

/**
 * 学科
 * lId 学科id 不能为空 int类型（12345678）
 * lName 学科名称 不能为空 （字符串类型）
 * lIntro 学科简介 不能为空（字符串类型）
 * aId 学院id  可以为空 （int类型）（123456745）
 * lTypeId 学科类别 int类型 （0，1，2，3，4，5）
 */
public class lesson {
    private Integer lId;
    private String lName;
    private String lIntro;
    private Integer aId;
    private Integer lTypeId;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlIntro() {
        return lIntro;
    }

    public void setlIntro(String lIntro) {
        this.lIntro = lIntro;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getlTypeId() {
        return lTypeId;
    }

    public void setlTypeId(Integer lTypeId) {
        this.lTypeId = lTypeId;
    }

    @Override
    public String toString() {
        return "lesson{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", lIntro='" + lIntro + '\'' +
                ", aId=" + aId +
                ", lTypeId=" + lTypeId +
                '}';
    }
}
