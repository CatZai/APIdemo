package com.pjb.springbootjjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
@NoArgsConstructor//public Category(){}
public class Category {
    String Id;
   private String name;
   private String fCategoryId;
    String create_time;
    String update_time;

    public Category(String name, String fCategoryId) {
        this.name = name;
        this.fCategoryId = fCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfCategoryId() {
        return fCategoryId;
    }

    public void setfCategoryId(String fCategoryId) {
        this.fCategoryId = fCategoryId;
    }

}
