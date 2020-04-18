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
    public int addPage(Page page){
        return  pageMapper.addPage(page);
    }
}
