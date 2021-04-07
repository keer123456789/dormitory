package com.keer.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 学生信息表
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@ApiModel(value="Student对象", description="学生信息表")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学号")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "学生姓名")
    private String name;

    @ApiModelProperty(value = "身份证号")
    private String identityNum;

    @ApiModelProperty(value = "房间号")
    private Integer roomId;

    @ApiModelProperty(value = "床位号")
    private Integer bedNum;

    @ApiModelProperty(value = "民族")
    private String nation;

    @ApiModelProperty(value = "性别 0-男  1-女")
    private Integer sex;

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

    @ApiModelProperty(value = "学生状态  0-正常 1-休学  2-退宿")
    private Integer state;

    @ApiModelProperty(value = "任务id 表示学生属于的批次")
    private Integer taskId;


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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "Student{" +
        "id=" + id +
        ", name=" + name +
        ", identityNum=" + identityNum +
        ", roomId=" + roomId +
        ", bedNum=" + bedNum +
        ", nation=" + nation +
        ", sex=" + sex +
        ", academy=" + academy +
        ", major=" + major +
        ", classNum=" + classNum +
        ", region=" + region +
        ", phoneNum=" + phoneNum +
        ", address=" + address +
        ", state=" + state +
        ", taskId=" + taskId +
        "}";
    }
}
