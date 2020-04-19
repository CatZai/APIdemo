package com.pjb.springbootjjwt.service;

import com.pjb.springbootjjwt.entity.Source;
import com.pjb.springbootjjwt.entity.Source;
import com.pjb.springbootjjwt.mapper.SourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SourceService")
public class SourceService {
    @Autowired
    SourceMapper sourceMapper;

    public int addSource(Source source){
        return sourceMapper.addSource(source);
    }
    public  int deleteSource(String sourceId,String userId){
        return sourceMapper.deleteSource(sourceId,userId);
    }
    public int updateSource(String userId ,String sourceId,String note){
        return  sourceMapper.updateSource(userId,sourceId,note);
    }
}
