package com.pjb.springbootjjwt.service;

import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.entity.Page_Get;
import com.pjb.springbootjjwt.mapper.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("PageService")
public class PageService {
    @Autowired
    PageMapper pageMapper;

    public Page_Get findPageByUserIdAndCategoryId(String userId, String categoryId){
        return pageMapper.findPageByUserIdAndCategoryId(userId,categoryId);
    }

    public Page_Get findPageByLink(String userId,String link){
        return pageMapper.findPageByLink(userId,link);
    }

    public int deletePage(String userId,String link){
        return pageMapper.deletePage(userId,link);
    }
    public int addPage(Page page){
        return  pageMapper.addPage(page);
    }
    public int updatePage(String userId,String link,String categoryId){
        return pageMapper.updatePage(userId,link,categoryId);

    }
}
