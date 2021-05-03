package com.keer.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 物品信息表
 * </p>
 *
 * @author linhui
 * @since 2021-04-12
 */
@ApiModel(value="Object对象", description="物品信息表")
public class Object implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "物品名称")
    private String name;

    @ApiModelProperty(value = "楼层id")
    private Integer floorId;

    @ApiModelProperty(value = "楼层平面图中的标记位置")
    private String x;

    @ApiModelProperty(value = "楼层平面图中的标记位置")
    private String y;

    @ApiModelProperty(value = "物品类别")
    private String type;


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

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
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

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floorId=" + floorId +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
