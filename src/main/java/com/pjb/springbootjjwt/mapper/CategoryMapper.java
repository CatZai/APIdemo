package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    Category findfCategoryId(@Param("categoryId") String categoryId);
    List finduserId(@Param("userId")String userId);
    int deleteOfcategoryId(@Param("categoryId") String categoryId,@Param("userId") String userId);
    int addCategory(Category category);

}
