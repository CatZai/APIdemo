package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.entity.Page_Get;
import com.pjb.springbootjjwt.service.PageService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class PageAPI {
    @Autowired
    PageService pageService;

    @UserLoginToken
    @PostMapping("/pages")
    public Object pages_create(@RequestBody Page page) {
        JSONObject jsonObject = new JSONObject();
        page.setUserId(TokenUtil.getTokenUserId());
        pageService.addPage(page);
        jsonObject.put("keywords", page.getKeywords().split(","));
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/pages")
    public Object get_pages_list(String categoryId) {
       //Page page = new Page();
        JSONObject jsonObject = new JSONObject();
        Page_Get listFotBase = pageService.findPageByUserIdAndCategoryId(TokenUtil.getTokenUserId(), categoryId);//select
        if (listFotBase != null) {
            jsonObject.put("userId", listFotBase.getUserId());
            jsonObject.put("link", listFotBase.getLink());
            jsonObject.put("title", listFotBase.getTitle());
            jsonObject.put("keywords", listFotBase.getKeywords().split(","));
            jsonObject.put("category", listFotBase.getCategoryId());
            jsonObject.put("create_time", listFotBase.getCreateTime());
            jsonObject.put("update_time", listFotBase.getUpdateTime());
            return jsonObject;
        } else {
            return "categoryId查不到";
        }
    }

    @UserLoginToken
   @GetMapping("/pages/{link}")
    public Object get_pages_find(@PathVariable("link") String link){
        JSONObject jsonObject = new JSONObject();
        Page_Get findFotBase = pageService.findPageByLink(TokenUtil.getTokenUserId(), link);
        if(findFotBase != null){
            jsonObject.put("userId", findFotBase.getUserId());
            jsonObject.put("link", findFotBase.getLink());
            jsonObject.put("title", findFotBase.getTitle());
            jsonObject.put("keywords", findFotBase.getKeywords().split(","));
            jsonObject.put("category", findFotBase.getCategoryId());
            jsonObject.put("create_time", findFotBase.getCreateTime());
            jsonObject.put("update_time", findFotBase.getUpdateTime());
            return jsonObject;
        } else {
            return "link查不到";
        }
    }
}
