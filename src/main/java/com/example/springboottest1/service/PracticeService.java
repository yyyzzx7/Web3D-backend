package com.example.springboottest1.service;

import com.example.springboottest1.mapper.PracticeMapper;
import com.example.springboottest1.util.DataConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service

public class PracticeService {
    @Autowired
    private PracticeMapper practiceMapper;

    // 查询练习任务
    public Map<String,Object> practice(String studyUuid){
        Map<String,Object> practiceMap = practiceMapper.practice(studyUuid);
        List<Map<String, Object>> subPracticeList = practiceMapper.subPractice(studyUuid);
        // 如果choice字符为空，则删除; 否则转为JSON格式
        for(int j = 0; j < subPracticeList.size(); j++){
            if(subPracticeList.get(j).get("choice").toString().equals("")){
                subPracticeList.get(j).remove("choice");
            }else{
                String choice = (String)subPracticeList.get(j).get("choice");
                subPracticeList.get(j).put("choice", DataConvert.StringToStringArray(choice));
            }
        }
        practiceMap.put("subTasks",subPracticeList);
        return practiceMap;
    }


}
