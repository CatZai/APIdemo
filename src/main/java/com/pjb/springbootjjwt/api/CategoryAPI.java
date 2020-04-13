package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.entity.Category;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.service.CategoryService;
import com.pjb.springbootjjwt.service.TokenService;
import com.pjb.springbootjjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/categories")
    public Object category_create(@RequestBody Category category){
        JSONObject jsonObject=new JSONObject();
        Category categoryForBase=categoryService.findfCategoryId(category);
        if(categoryForBase==null){
            categoryService.addCategory(category.getName(),category.getfCategoryId());
            jsonObject.put("message","创建成功");
            return jsonObject;
        }else {

            jsonObject.put("message","创建失败，ID存在");
            return jsonObject;

        }
    }
}