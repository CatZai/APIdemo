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
    private String createTime;
    private String updateTime;



        public String getKeywords(){
        String join = String.join(",", keywords);
        return join;
    }
//get   list
//    public void setKeywords(String keywords) {
//        this.keywords = Arrays.asList(keywords.split(","));;
//    }

//    //post create
//public void setKeywords(List<String> keywords) {
//    this.keywords = keywords;
//    }
//

}
