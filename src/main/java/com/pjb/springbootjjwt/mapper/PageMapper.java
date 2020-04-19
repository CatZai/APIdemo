package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.annotation.PassToken;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.entity.Page_Get;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
//import com.pjb.springbootjjwt.entity.Page;
public interface PageMapper {

    Page_Get findPageByUserIdAndCategoryId(@Param("userId") String userId, @Param("categoryId") String categoryId);
    Page_Get findPageByLink(@Param("userId") String userId,@Param("link")String link);

    int deletePage(@Param("userId") String userId,@Param("link") String link);
    int addPage(Page page);
    int updatePage(@Param("userId")String userId,String link,String categoryId);
}


