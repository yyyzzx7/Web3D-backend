package com.example.springboottest1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface PracticeMapper {

    // 查询该工作室的练习任务
    Map<String,Object> practice(@Param("studyUuid") String studyUuid);
    // 查询该工作室的练习任务的题目
    List<Map<String,Object>> subPractice(@Param("studyUuid") String studyUuid);

}
