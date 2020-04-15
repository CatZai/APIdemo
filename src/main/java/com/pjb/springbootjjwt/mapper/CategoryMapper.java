package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.Category;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {

    Category findfCategoryId(@Param("categoryId") String categoryId);
    int addCategory(Category category);

}
