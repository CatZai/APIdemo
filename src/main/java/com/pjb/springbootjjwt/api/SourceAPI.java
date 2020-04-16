package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pjb.springbootjjwt.entity.Source;
import com.pjb.springbootjjwt.service.SourceService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SourceAPI {
    @Autowired
    SourceService sourceService;

    @PostMapping("/sources")
    public Object sources_create(@RequestBody Source source){
        JSONObject jsonObject=new JSONObject();
        source.setUserId(TokenUtil.getTokenUserId());

        sourceService.addSource(source);
        //return source.getEndMeta().getTextOffset();
        return "ok";
    }
}
