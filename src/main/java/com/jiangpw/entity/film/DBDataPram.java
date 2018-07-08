package com.jiangpw.entity.film;

public class DBDataPram {
    private String type;
    private String tag;
    private int page_limit;
    private int page_start;
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPage_limit() {
        return page_limit;
    }

    public void setPage_limit(int page_limit) {
        this.page_limit = page_limit;
    }

    public int getPage_start() {
        return page_start;
    }

    public void setPage_start(int page_start) {
        this.page_start = page_start;
    }
}
