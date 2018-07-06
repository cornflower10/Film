package com.jiangpw.entity.film;

public class Cast {
    private Integer id;

    private String cast_name;

    private Integer douban_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCast_name() {
        return cast_name;
    }

    public void setCast_name(String cast_name) {
        this.cast_name = cast_name == null ? null : cast_name.trim();
    }

    public Integer getDouban_id() {
        return douban_id;
    }

    public void setDouban_id(Integer douban_id) {
        this.douban_id = douban_id;
    }
}