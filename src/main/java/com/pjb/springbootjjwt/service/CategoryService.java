package com.pjb.springbootjjwt.service;

import com.pjb.springbootjjwt.entity.Category;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CategoryService")
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public Category findfCategoryId(Category category) {
        return categoryMapper.findfCategoryId(category.getfCategoryId());
    }

    public int addCategory(String name, String fCategoryId){return categoryMapper.addCategory(name, fCategoryId);}
}
