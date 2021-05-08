package com.keer.dormitory.dto;

import io.swagger.annotations.ApiModelProperty;

public class ObjectInfo {
    private Integer key;

    @ApiModelProperty(value = "物品名称")
    private String name;

    @ApiModelProperty(value = "楼层")
    private String floor;

    private String block;
    @ApiModelProperty(value = "楼层平面图中的标记位置")
    private String x;

    @ApiModelProperty(value = "楼层平面图中的标记位置")
    private String y;

    @ApiModelProperty(value = "物品类别")
    private String type;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
