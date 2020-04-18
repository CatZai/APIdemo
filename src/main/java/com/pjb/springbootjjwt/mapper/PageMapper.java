package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.annotation.PassToken;
import com.pjb.springbootjjwt.entity.Page;
import com.pjb.springbootjjwt.entity.Page_Get;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//import com.pjb.springbootjjwt.entity.Page;
public interface PageMapper {

    Page_Get findPageByUserIdAndCategoryId(@Param("userId") String userId, @Param("categoryId") String categoryId);
    int addPage(Page page);
}
