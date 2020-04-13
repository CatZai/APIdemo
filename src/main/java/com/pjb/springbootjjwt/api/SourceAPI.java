package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pjb.springbootjjwt.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SourceAPI {
    @PostMapping("/sources")
    public Object sources_create(@RequestBody Source source){
        JSONObject jsonObject=new JSONObject();
        return source.getEndMeta().getTextOffset();
    }
}
