package com.jiangpw.entity.film;

import java.util.List;

public class DouBan {

    private List<SubjectsBean> subjects;

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rate : 5.4
         * cover_x : 1477
         * title : 了不起的高二八班
         * url : https://movie.douban.com/subject/27109950/
         * playable : true
         * cover : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2526935106.webp
         * id : 27109950
         * cover_y : 2068
         * is_new : true
         */

        private String rate;
        private int cover_x;
        private String title;
        private String url;
        private boolean playable;
        private String cover;
        private String id;
        private int cover_y;
        private boolean is_new;

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public int getCover_x() {
            return cover_x;
        }

        public void setCover_x(int cover_x) {
            this.cover_x = cover_x;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isPlayable() {
            return playable;
        }

        public void setPlayable(boolean playable) {
            this.playable = playable;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getCover_y() {
            return cover_y;
        }

        public void setCover_y(int cover_y) {
            this.cover_y = cover_y;
        }

        public boolean isIs_new() {
            return is_new;
        }

        public void setIs_new(boolean is_new) {
            this.is_new = is_new;
        }
    }
}
