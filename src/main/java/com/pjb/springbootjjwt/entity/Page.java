package com.pjb.springbootjjwt.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    private String link;
    private String title;
    private String categoryId;
    private List<String> keywords;
    private String userId;
    private Timestamp create_time;
    private Timestamp update_time;

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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

//    public List<String> getKeywords() {
//        return keywords;
//    }

        public String getKeywords(){
        String join = String.join(",", keywords);
        return join;
    }
//get   list
//    public void setKeywords(String keywords) {
//        this.keywords = Arrays.asList(keywords.split(","));;
//    }

    //post create
public void setKeywords(List<String> keywords) {
    this.keywords = keywords;
    }


}
