package com.example.springboottest1.service;

import com.example.springboottest1.mapper.StudioMapper;
import com.example.springboottest1.util.DataConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudioService {
    @Autowired
    private StudioMapper studioMapper;

    // 查询一个学院信息
    public Map<String,Object> studio(String uuid){
        Map<String,Object> map = studioMapper.studio(uuid);

        // playerRotateYAxis
        String playerRotateYAxis = (String) map.get("playerRotateYAxis");
        Double value = Double.parseDouble(DataConvert.StringValue(playerRotateYAxis));
        map.put("playerRotateYAxis", value);


        // directionalLightDirection
        String directionalLightDirection = (String) map.get("directionalLightDirection");
        map.put("directionalLightDirection", DataConvert.StringToDoubleArray(directionalLightDirection));

        // directionalLightPosition
        String directionalLightPosition = (String) map.get("directionalLightPosition");
        map.put("directionalLightPosition", DataConvert.StringToDoubleArray(directionalLightPosition));

        // collisionBox
        String collisionBox = (String) map.get("collisionBox");
        map.put("collisionBox", DataConvert.StringToStringArray(collisionBox));

        // receiveShadowName
        if(map.get("receiveShadowName") != null){
            String receiveShadowName = (String) map.get("receiveShadowName");
            map.put("receiveShadowName",DataConvert.StringToStringArray(receiveShadowName));
        }
        else{
            map.put("receiveShadowName",new String[0]);
        }

        // receptionistConfig接待人员信息
        Map<String,Object> receptionistMap = studioMapper.studioReceptionist(uuid);
        if(receptionistMap != null && receptionistMap.get("receptionistRotateYAxis") != null){
            String receptionistRotateYAxis = (String) receptionistMap.get("receptionistRotateYAxis");
            receptionistMap.put("receptionistRotateYAxis", Double.parseDouble(DataConvert.StringValue(receptionistRotateYAxis)));
            map.put("receptionistConfig",receptionistMap);
        }
        else{
            map.put("receptionistConfig",null);
        }

        // rotateCamera相机信息
        List<Map<String,Object>> rotateCameraList = studioMapper.studioRotateCamera(uuid);
        if(rotateCameraList.size() != 0){
            for(int i = 0; i < rotateCameraList.size(); i++){
                Map<String, Object> oneCamera = rotateCameraList.get(i);
                String rotate = (String) oneCamera.get("rotate");
                oneCamera.put("rotate", Double.parseDouble(DataConvert.StringValue(rotate)));
            }
        }

        map.put("rotateCamera",rotateCameraList);

        // studioAIs工作室AI人员信息
        List<Map<String,Object>> studioAIList = studioMapper.studioAI(uuid);
        if(studioAIList.size() != 0){
            for(int i = 0; i < studioAIList.size(); i++){
                Integer AIid = (Integer) studioAIList.get(i).get("AIid");
                List<Map<String,Object>> studioAIPathList = studioMapper.studioAIPath(uuid, AIid.toString()); // 搜索当前AI的路径
                studioAIList.get(i).put("path", studioAIPathList);
                studioAIList.get(i).remove("AIid");// 前端不需要显示AI的id

                // info
                String info = (String) studioAIList.get(i).get("info");
                studioAIList.get(i).put("info",DataConvert.StringToStringArray(info));

                // infoSoundURL
                String infoSoundURL = (String) studioAIList.get(i).get("infoSoundURL");
                studioAIList.get(i).put("infoSoundURL",DataConvert.StringToStringArray(infoSoundURL));
            }
        }


        map.put("studioAIs", studioAIList);
        return map;
    }




    // studio/book/工作室ID
    // 查询视频书
    public List<Map<String,Object>> studioBook(String uuid){
        return studioMapper.studioBook(uuid);
    }



    // studio/ebook/工作室ID
    // 查询电子书
    public List<Map<String,Object>> studioEBook(String uuid){
        return studioMapper.studioEBook(uuid);
    }





    // studio/task/｛工作室uuid｝
    // 任务
    public List<Map<String,Object>> studioTask(String uuid){
        List<Map<String,Object>> taskList = studioMapper.studioTask(uuid);
        for(int i = 0; i < taskList.size(); i++){
            Integer tid = (Integer) taskList.get(i).get("uuid");// tid字段改名uuid
            taskList.get(i).remove("rate");// 不显示

            List<Map<String, Object>> subTaskList = studioMapper.studioSubTask(tid.toString());

            for(int j = 0; j < subTaskList.size(); j++){
                subTaskList.get(j).remove("rate"); // 不显示rate
            }
            taskList.get(i).put("subTask",subTaskList);
        }
        return taskList;
    }

    // studio/task/score/{任务tid}
    // 任务
    public Map<String,Object> studioTaskScore(String tid){
        Map<String,Object> taskMap = studioMapper.task(tid);

        taskMap.put("rate", 5);        // 默认5

        List<Map<String, Object>> subTaskList = studioMapper.studioSubTask(tid);
        for(int i = 0; i < subTaskList.size(); i++){
            subTaskList.get(i).put("rate", 5);
        }
        taskMap.put("subTask", subTaskList);
        return taskMap;
    }
}
