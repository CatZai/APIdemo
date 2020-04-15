package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

@RestController
public class PageAPI {
    @Autowired
    PageService pageService;

    @PostMapping("/pages")
    public Object pages_create(@RequestBody Page page){
        JSONObject jsonObject=new JSONObject();

        pageService.addPage(page);


//        List<String> mcodelist = Arrays.asList(page.getKeywords());
//        System.out.println(mcodelist);
//
    jsonObject.put("keywords",page.getKeywords().split(","));

        return jsonObject;

}
}
