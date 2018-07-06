package com.jiangpw.entity.film;

public class Director {
    private String id;

    private String name;

    private Integer douban_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDouban_id() {
        return douban_id;
    }

    public void setDouban_id(Integer douban_id) {
        this.douban_id = douban_id;
    }
}