package com.pjb.springbootjjwt.entity;

import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
@NoArgsConstructor//public Category(){}
public class Category {

    /**
     * name : 分类名称2
     * categoryId : 546546546045
     */

    private String name;
    private String categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
