package com.jiangpw.entity;

import java.util.Date;

public class Reply {
    private Integer id;

    private Integer commentid;

    private Integer fromuserid;

    private Integer touserid;

    private String replaycontent;

    private Date createtime;

    private Date updatetime;

    private User user;

    private User user1;

    public User getUser() {
        return user;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getReplaycontent() {
        return replaycontent;
    }

    public void setReplaycontent(String replaycontent) {
        this.replaycontent = replaycontent == null ? null : replaycontent.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}