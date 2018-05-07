package com.jiangpw.entity;

import java.util.Date;

public class Note {
    private Integer id;

    private Integer userid;

    private Integer imgid;

    private Integer likeid;

    private Integer labelid;

    private Integer checkid;

    private Integer categoryid;

    private Date createtiem;

    private Date updatetime;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public Integer getLikeid() {
        return likeid;
    }

    public void setLikeid(Integer likeid) {
        this.likeid = likeid;
    }

    public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }

    public Integer getCheckid() {
        return checkid;
    }

    public void setCheckid(Integer checkid) {
        this.checkid = checkid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Date getCreatetiem() {
        return createtiem;
    }

    public void setCreatetiem(Date createtiem) {
        this.createtiem = createtiem;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}