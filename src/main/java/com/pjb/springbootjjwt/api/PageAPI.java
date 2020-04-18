package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.service.PageService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageAPI {
    @Autowired
    PageService pageService;

    @UserLoginToken
    @PostMapping("/pages1")
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
       Page page = new Page();
        JSONObject jsonObject = new JSONObject();
        Page listFotBase = pageService.findPageByUserIdAndCategoryId(TokenUtil.getTokenUserId(), categoryId);//select
        if (listFotBase != null) {
            jsonObject.put("userId", listFotBase.getUserId());
            jsonObject.put("link", listFotBase.getLink());
            jsonObject.put("title", listFotBase.getTitle());
            jsonObject.put("keywords", listFotBase.getKeywords().split(","));
            jsonObject.put("category", listFotBase.getCategoryId());
            jsonObject.put("create_time", listFotBase.getCreate_time());
            jsonObject.put("update_time", listFotBase.getUpdate_time());
            return jsonObject;
        } else {
            return "categoryId查不到";
        }
    }
}
