package com.example.hospitalward.model;

import java.util.Date;

public class Reserve {
    private Long id;

    private String name;

    private String phone;

    private Long bedId;

    private Date presetTime;

    private Date prelivedTime;

    private Boolean isDeleted;

    private Date createDate;

    private Date updateDate;

    private Long createStaff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getBedId() {
        return bedId;
    }

    public void setBedId(Long bedId) {
        this.bedId = bedId;
    }

    public Date getPresetTime() {
        return presetTime;
    }

    public void setPresetTime(Date presetTime) {
        this.presetTime = presetTime;
    }

    public Date getPrelivedTime() {
        return prelivedTime;
    }

    public void setPrelivedTime(Date prelivedTime) {
        this.prelivedTime = prelivedTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }
}