package com.jiangpw.entity;

import java.util.Date;

public class Favor {
    private Integer id;

    private Integer likecount;

    private Integer unlikecount;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    public Integer getUnlikecount() {
        return unlikecount;
    }

    public void setUnlikecount(Integer unlikecount) {
        this.unlikecount = unlikecount;
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