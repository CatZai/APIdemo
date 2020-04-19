package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Category;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.service.CategoryService;
import com.pjb.springbootjjwt.service.TokenService;
import com.pjb.springbootjjwt.service.UserService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryAPI {
    @Autowired
    CategoryService categoryService;

    @UserLoginToken
    @PostMapping("/categories")
    public Object category_create(@RequestBody Category category){
        JSONObject jsonObject=new JSONObject();
        Category categoryForBase=categoryService.findfCategoryId(category);
        if(categoryForBase==null){
            category.setUserId(TokenUtil.getTokenUserId());
            categoryService.addCategory(category);
            jsonObject.put("message","创建成功");
            return jsonObject;
        }else {

            jsonObject.put("message","创建失败，ID存在");
            return jsonObject;
        }
    }

    @UserLoginToken
    @GetMapping("/categories")
    public List category_list(){
        //JSONObject jsonObject=new JSONObject();
        //Category category_val=categoryService.finduserId(TokenUtil.getTokenUserId());
        List category_val2=categoryService.finduserId(TokenUtil.getTokenUserId());
        if(category_val2!=null){
            return category_val2;
        }
        else{
            return category_val2;
        }
    }

    @UserLoginToken
    //@GetMapping("/categories/{categoryId}/**")
    @RequestMapping(value="/categories/{categoryId}",method = RequestMethod.DELETE)
    @ResponseBody
    public String category_remove(@PathVariable("categoryId") String categoryId){
        int status = categoryService.deleteOfcategoryId(categoryId,TokenUtil.getTokenUserId());
        if(status == 1){
            return "删除成功";
        }
        else{
            return "删除失败";
        }
    }


    @RequestMapping(value = "/categories/{categoryId}",method = RequestMethod.PATCH)
    public String update_category(@PathVariable("categoryId")String categoryId,@RequestBody Category category){
        int status = categoryService.upadteCategory(TokenUtil.getTokenUserId(),categoryId,category.getName());
        if(status != 0){
            return "category更新"+status+"行";
        }
        else{
            return "update失败";
        }
    }

}
