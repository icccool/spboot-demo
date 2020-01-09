package com.spboot.bean;

import java.util.Date;

public class Twareunite {
    private Long uniteId;

    private Long groupId;

    private Long companyId;

    private String schemeName;

    private Byte uniteStatus;

    private Byte classify;

    private String indications;

    private Integer posShowOrder;

    private String checkerScript;

    private String notes;

    private Long createUser;

    private Date createTime;

    private Long modifyUser;

    private Date modifyTime;

    public Long getUniteId() {
        return uniteId;
    }

    public void setUniteId(Long uniteId) {
        this.uniteId = uniteId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Byte getUniteStatus() {
        return uniteStatus;
    }

    public void setUniteStatus(Byte uniteStatus) {
        this.uniteStatus = uniteStatus;
    }

    public Byte getClassify() {
        return classify;
    }

    public void setClassify(Byte classify) {
        this.classify = classify;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public Integer getPosShowOrder() {
        return posShowOrder;
    }

    public void setPosShowOrder(Integer posShowOrder) {
        this.posShowOrder = posShowOrder;
    }

    public String getCheckerScript() {
        return checkerScript;
    }

    public void setCheckerScript(String checkerScript) {
        this.checkerScript = checkerScript;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}