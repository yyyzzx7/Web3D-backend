package com.example.springboottest1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface CollegeMapper {


    // 查询所有学院ID
    List<Object> collegeAllID();
    // 查询学院描述信息
    Map<String, Object> collegeDescription(@Param("uuid") String uuid);
    // 查询学院包含的工作室
    List<Map<String, Object>> collegeStudio(@Param("uuid") String uuid);



    // 查询学院模型的信息
    List<Map<String, Object>> collegeModel();



    // 查询学院楼层信息
    Map<String, Object> collegeInf(@Param("c_uuid") String c_uuid);
    // 查询楼层信息
    List<Integer> collegeAllFloor(@Param("c_uuid") String c_uuid);
    // 查询该楼层的学院信息
    List<Map<String, Object>> floorAllStudio(@Param("c_uuid") String c_uuid, @Param("f_uuid") String f_uuid);
}
