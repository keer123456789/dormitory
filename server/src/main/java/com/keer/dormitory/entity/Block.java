package com.keer.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 宿舍楼信息
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@ApiModel(value="Block对象", description="宿舍楼信息")
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "宿舍楼id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "宿舍楼姓名")
    private String name;

    @ApiModelProperty(value = "房间大小  4-4人间 6-6人间")
    private Integer roomSize;

    @ApiModelProperty(value = "楼层数")
    private Integer floorSize;

    @ApiModelProperty(value = "宿管人员id")
    private Integer managerId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getFloorSize() {
        return floorSize;
    }

    public void setFloorSize(Integer floorSize) {
        this.floorSize = floorSize;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Block{" +
        "id=" + id +
        ", name=" + name +
        ", roomSize=" + roomSize +
        ", floorSize=" + floorSize +
        ", managerId=" + managerId +
        "}";
    }
}
