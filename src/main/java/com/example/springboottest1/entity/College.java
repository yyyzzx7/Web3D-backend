package com.example.springboottest1.entity;

public class College {
    private int uuid;               // 学院ID
    private String name;            // 学院名称
    private int totalFloor;         // 总楼层数
    private String modeUrl;         // 学院模型Url
    private String imgUrl;          // 学院照片Url
    private String mapModelUrl;     // 学院地图Url
    private String position;        // 位置
    private String real_position;   // 真实位置
    private String description;     // 学院描述
    private String scale;           // 放缩

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    private String rotation;        // 旋转

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModeUrl() {
        return modeUrl;
    }

    public void setModeUrl(String modeUrl) {
        this.modeUrl = modeUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMapModelUrl() {
        return mapModelUrl;
    }

    public void setMapModelUrl(String mapModelUrl) {
        this.mapModelUrl = mapModelUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getReal_position() {
        return real_position;
    }

    public void setReal_position(String real_position) {
        this.real_position = real_position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }
}
