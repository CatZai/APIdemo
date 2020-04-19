package com.pjb.springbootjjwt.api;
import com.alibaba.fastjson.JSONObject;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.Category;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.entity.Page_Get;
import com.pjb.springbootjjwt.service.PageService;
import com.pjb.springbootjjwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
   //@GetMapping("/pages/{link}")
    @RequestMapping(value="/pages/{link}/**",method = RequestMethod.GET)
    @ResponseBody
    public Object get_pages_find(HttpServletRequest request, @PathVariable("link") String link){
        final String path =
                request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        final String bestMatchingPattern =
                request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);
        String link2=link+'/'+'/'+arguments;
        //--------------------------------------------------------------------------------------
        JSONObject jsonObject = new JSONObject();
        Page_Get findFotBase = pageService.findPageByLink(TokenUtil.getTokenUserId(), link2);
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

    @UserLoginToken
    @RequestMapping(value="/pages/{link}/**",method = RequestMethod.DELETE)
    public String pages_remove(HttpServletRequest request,@PathVariable("link") String link){
        final String path =
                request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        final String bestMatchingPattern =
                request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);
         link=link+'/'+'/'+arguments;
        int status = pageService.deletePage(TokenUtil.getTokenUserId(),link);
        if(status != 0){
            return "删除成功";
        }
        else{
            return "删除失败";
        }
    }

    @RequestMapping(value = "/pages/{link}/**",method = RequestMethod.PATCH)
    public String pages_update(HttpServletRequest request,@PathVariable("link") String link,@RequestBody Category category){
        final String path =
                request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        final String bestMatchingPattern =
                request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);
        link=link+'/'+'/'+arguments;
        //-------------------------------------------------------------------
        int status = pageService.updatePage(TokenUtil.getTokenUserId(),link,category.getCategoryId());
        if(status != 0){
            return "更新"+status+"行";
        }
        else{
            return "update失败";
        }

    }

}
