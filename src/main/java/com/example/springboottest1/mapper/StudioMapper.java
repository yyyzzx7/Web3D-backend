package com.example.springboottest1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface StudioMapper {
    // studio/工作室ID
    // 查询工作室信息
    Map<String,Object> studio(@Param("uuid") String uuid);
    // 查询工作室的相机
    List<Map<String,Object>> studioRotateCamera(@Param("uuid") String uuid);
    // 查询工作室的接待人员
    Map<String,Object> studioReceptionist(@Param("uuid") String uuid);
    // 查询工作室的AI
    List<Map<String,Object>> studioAI(@Param("uuid") String uuid);
    // 查询该AI的路径
    List<Map<String,Object>> studioAIPath(@Param("uuid") String uuid, @Param("AIid") String AIid);



    // 查询该工作室的视频书
    List<Map<String,Object>> studioBook(@Param("uuid") String uuid);


    // 查询该工作室的电子书
    List<Map<String,Object>> studioEBook(@Param("uuid") String uuid);


    // 工作室任务
    List<Map<String,Object>> studioTask(@Param("uuid") String uuid);
    // 工作室子任务
    List<Map<String,Object>> studioSubTask(@Param("uuid") String uuid,  @Param("tid") String tid);


}
