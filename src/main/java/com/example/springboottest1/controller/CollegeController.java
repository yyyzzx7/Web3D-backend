package com.example.springboottest1.controller;

import com.example.springboottest1.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping
@CrossOrigin
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // 学院信息
    @RequestMapping(value = "/college", method = GET, produces = "application/json;charset = UTF-8")
    public List<Map<String, Object>> colleges(){
        return collegeService.collegeModel();
    }

    // 学院信息 + 学院地图
    @RequestMapping(value = "/college/map", method = GET, produces = "application/json;charset = UTF-8")
    public Map<String, Object> collegeMap(){
        List<Map<String, Object>> list = collegeService.collegeModel();
        Map<String, Object> map = new HashMap<>();
        map.put("colleges", list);
        map.put("mapModelURL", "model/map.glb");
        return map;
    }



    // 工作室信息
    @RequestMapping(value = "/college/description", method = GET, produces = "application/json;charset = UTF-8")
    public List<Map<String, Object>> collegeAllDescription(){
        return collegeService.collegeAllDescription();
    }

    @RequestMapping(value = "/college/description/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public Map<String, Object> collegeDescription(@PathVariable("uuid") String uuid){
        return collegeService.collegeDescription(uuid);
    }



    // collegeFloor
    @RequestMapping(value = "/college/floor/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public Map<String, Object> collegeFloor(@PathVariable("uuid") String uuid){
        return collegeService.collegeFloor(uuid);
    }
}
