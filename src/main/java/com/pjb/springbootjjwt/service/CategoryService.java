package com.pjb.springbootjjwt.service;

import com.pjb.springbootjjwt.entity.Category;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public Category findfCategoryId(Category category) {
        return categoryMapper.findfCategoryId(category.getCategoryId());
    }
    public List finduserId(String userId){
        return categoryMapper.finduserId(userId);
    }
    public int addCategory(Category category){return categoryMapper.addCategory(category);}
}
