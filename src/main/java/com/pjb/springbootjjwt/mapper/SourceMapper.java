package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.Source;
import org.apache.ibatis.annotations.Param;

public interface SourceMapper {
    int addSource(Source source);
    int deleteSource(@Param("sourceId") String sourceId, String userId);

}
