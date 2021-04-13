package com.example.springboottest1.service;

import com.example.springboottest1.mapper.CollegeMapper;
import com.example.springboottest1.util.DataConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    // college/description
    // 查询所有学院描述信息
    public List<Map<String, Object>> collegeAllDescription(){
        List<Map<String, Object>> list = new LinkedList<>();
        List<Object> collegeAllIDList = collegeMapper.collegeAllID();
        for(int i = 0; i < collegeAllIDList.size(); i++){
            String uuid = (String) collegeAllIDList.get(i);
            Map<String, Object> collegeDescription = collegeMapper.collegeDescription(uuid);
            List<Map<String, Object>> studioList = collegeMapper.collegeStudio(uuid);
            collegeDescription.put("studios", studioList);
            // 将一个完整学院的信息添加到list
            list.add(collegeDescription);
        }
        return list;
    }

    // college/description/学院id
    // 查询某个学院描述信息
    public Map<String, Object> collegeDescription(String uuid){
        Map<String, Object> map = collegeMapper.collegeDescription(uuid);
        Integer c_uuid = (Integer) map.get("uuid");
        List<Map<String, Object>> studioList = collegeMapper.collegeStudio(c_uuid.toString());
        map.put("studios", studioList);
        return map;
    }




    // college/map
    // college摆放模型的信息
    public List<Map<String, Object>> collegeModel(){
        List<Map<String, Object>> list = collegeMapper.collegeModel();
        for(int i = 0; i < list.size(); i++){
            // scale
            String scale = (String) list.get(i).get("scale");
            list.get(i).put("scale", DataConvert.StringToDoubleArray(scale));
            // rotation
            String rotation = (String) list.get(i).get("rotation");
            list.get(i).put("rotation", DataConvert.StringToDoubleArray(rotation));
        }
        return list;
    }



    // college/floor/学院id
    public Map<String, Object> collegeFloor(String c_uuid){
        Map<String, Object> map = collegeMapper.collegeInf(c_uuid);
        List<Map<String, Object>> floors = new LinkedList<>();

        List<Integer> floorNumberList = collegeMapper.collegeAllFloor(c_uuid);// 该学院的所有楼层
        for(int j = 0; j < floorNumberList.size(); j++){
            Integer f_uuid = floorNumberList.get(j);// 获取当前楼层号
            List<Map<String, Object>> studioList = collegeMapper.floorAllStudio(c_uuid, String.valueOf(f_uuid));

            Map<String, Object> tempFloor = new HashMap<>();
            tempFloor.put("floorNumber",f_uuid);
            tempFloor.put("studios", studioList);

            floors.add(tempFloor); // 将当前楼层信息添加到floors的list中
        }
        map.put("floors", floors);
        return map;
    }
}
