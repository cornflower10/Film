package com.jiangpw.entity.film;

public class Info {
    private Integer id;

    private String rate;

    private String title;

    private String url;

    private String cover;

    private Integer douban_id;

    private String cover_x;

    private String cover_y;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public Integer getDouban_id() {
        return douban_id;
    }

    public void setDouban_id(Integer douban_id) {
        this.douban_id = douban_id;
    }

    public String getCover_x() {
        return cover_x;
    }

    public void setCover_x(String cover_x) {
        this.cover_x = cover_x == null ? null : cover_x.trim();
    }

    public String getCover_y() {
        return cover_y;
    }

    public void setCover_y(String cover_y) {
        this.cover_y = cover_y == null ? null : cover_y.trim();
    }
}