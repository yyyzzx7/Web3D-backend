package com.example.springboottest1.controller;

import com.example.springboottest1.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @RequestMapping(value = "/practice/{studyUuid}", method = GET, produces = "application/json;charset = UTF-8")
    public Map<String,Object> studioPractice(@PathVariable("studyUuid") String studyUuid){
        return practiceService.practice(studyUuid);
    }
}
