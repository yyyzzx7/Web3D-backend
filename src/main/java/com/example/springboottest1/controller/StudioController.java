package com.example.springboottest1.controller;

import com.example.springboottest1.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/studio")
@CrossOrigin
public class StudioController {

    @Autowired
    private StudioService studioService;

    @RequestMapping(value = "/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public Map<String,Object> studio(@PathVariable("uuid") String uuid){
        return studioService.studio(uuid);
    }

    @RequestMapping(value = "/book/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public List<Map<String,Object>> studioBook(@PathVariable("uuid") String uuid){
        return studioService.studioBook(uuid);
    }
    @RequestMapping(value = "/ebook/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public List<Map<String,Object>> studioEBook(@PathVariable("uuid") String uuid){
        return studioService.studioEBook(uuid);
    }
    @RequestMapping(value = "/task/{uuid}", method = GET, produces = "application/json;charset = UTF-8")
    public List<Map<String,Object>> studioTask(@PathVariable("uuid") String uuid){
        return studioService.studioTask(uuid);
    }

}
