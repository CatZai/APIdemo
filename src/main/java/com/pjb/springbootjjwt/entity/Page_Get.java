package com.pjb.springbootjjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page_Get {
    private String link;
    private String title;
    private String categoryId;
    private List<String> keywords;
    private String userId;
    private Timestamp create_time;
    private Timestamp update_time;

    //get   list
    public void setKeywords(String keywords) {
        this.keywords = Arrays.asList(keywords.split(","));;
    }

    public String getKeywords(){
        String join = String.join(",", keywords);
        return join;
    }
}
