package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Source;
import com.pjb.springbootjjwt.service.SourceService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SourceAPI {
    @Autowired
    SourceService sourceService;
    @UserLoginToken
    @PostMapping("/sources")
    public Object sources_create(@RequestBody Source source){
        JSONObject jsonObject=new JSONObject();
        source.setUserId(TokenUtil.getTokenUserId());
        sourceService.addSource(source);
        //return source.getEndMeta().getTextOffset();
        return "ok";
    }

    @RequestMapping(value="/sources/{sourceId}/**",method = RequestMethod.DELETE)
    public String sources_remove(@PathVariable("sourceId")String sourceId){
        int status = sourceService.deleteSource(sourceId,TokenUtil.getTokenUserId());
        if(status==1){
            return "删除source成功";
        }
        else{
            return "失败";
        }
    }

    @RequestMapping(value = "/sources/{sourceId}",method = RequestMethod.PATCH)
    public String source_update(@PathVariable("sourceId")String sourceId,@RequestBody Source source){
        int status = sourceService.updateSource(TokenUtil.getTokenUserId(),sourceId,source.getNote());
        if(status!=0){
            return "source更新"+status+"行";
        }else{
            return "更新失败";
        }
    }

}
