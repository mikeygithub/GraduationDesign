package com.mikey.design.entity;

public class Design {
    private Integer designId;

    private Integer designOfTeacher;

    private String designTitle;

    private Integer designNum;

    private String designRequire;

    public Integer getDesignId() {
        return designId;
    }

    public void setDesignId(Integer designId) {
        this.designId = designId;
    }

    public Integer getDesignOfTeacher() {
        return designOfTeacher;
    }

    public void setDesignOfTeacher(Integer designOfTeacher) {
        this.designOfTeacher = designOfTeacher;
    }

    public String getDesignTitle() {
        return designTitle;
    }

    public void setDesignTitle(String designTitle) {
        this.designTitle = designTitle == null ? null : designTitle.trim();
    }

    public Integer getDesignNum() {
        return designNum;
    }

    public void setDesignNum(Integer designNum) {
        this.designNum = designNum;
    }

    public String getDesignRequire() {
        return designRequire;
    }

    public void setDesignRequire(String designRequire) {
        this.designRequire = designRequire == null ? null : designRequire.trim();
    }
}