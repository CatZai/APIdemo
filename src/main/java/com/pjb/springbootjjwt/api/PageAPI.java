package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.service.PageService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageAPI {
    @Autowired
    PageService pageService;

    @PostMapping("/pages")
    public Object pages_create(@RequestBody Page page){
        JSONObject jsonObject=new JSONObject();
        page.setUserId(TokenUtil.getTokenUserId());
        pageService.addPage(page);


//        List<String> mcodelist = Arrays.asList(page.getKeywords());
//        System.out.println(mcodelist);
//
    jsonObject.put("keywords",page.getKeywords().split(","));

        return jsonObject;

}
}
