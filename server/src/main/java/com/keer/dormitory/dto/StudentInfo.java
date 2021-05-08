package com.keer.dormitory.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

public class StudentInfo {
    @ApiModelProperty(value = "学号")
    private String id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String identityNum;

    @ApiModelProperty(value = "房间名称")
    private String room;

    @ApiModelProperty(value = "楼层")
    private String floor;

    @ApiModelProperty(value = "宿舍楼")
    private String block;

    @ApiModelProperty(value = "楼层Id")
    private Integer floorId;

    @ApiModelProperty(value = "宿舍楼Id")
    private Integer blockId;

    @ApiModelProperty(value = "房间id")
    private Integer roomId;

    @ApiModelProperty(value = "床位号")
    private Integer bedNum;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "性别 0-男  1-女")
    private String sex;

    @ApiModelProperty(value = "学院：信息，物流")
    private String academy;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "行政班级号")
    private String classNum;

    @ApiModelProperty(value = "地区")
    private String region;

    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @ApiModelProperty(value = "家庭地址")
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", room='" + room + '\'' +
                ", floor='" + floor + '\'' +
                ", block='" + block + '\'' +
                ", floorId=" + floorId +
                ", blockId=" + blockId +
                ", roomId=" + roomId +
                ", bedNum=" + bedNum +
                ", nation='" + nation + '\'' +
                ", sex='" + sex + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", classNum='" + classNum + '\'' +
                ", region='" + region + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
