package com.pjb.springbootjjwt.entity;

import java.util.List;

public class Page {

    /**
     * link : https://cn.vuejs.org/v2/guide/
     * title : 介绍 — Vue.js
     * keywords : ["阿甲","阿牛"]
     * categoryId : 123334
     */

    private String link;
    private String title;
    private String categoryId;
    private List<String> keywords;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

//    public List<String> getKeywords() {
//        return keywords;
//    }
    public String getKeywords(){
        String join = String.join(",", keywords);
        return join;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
