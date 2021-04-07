package com.keer.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 房间表
 * </p>
 *
 * @author linhui
 * @since 2021-04-07
 */
@ApiModel(value="Room对象", description="房间表")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "宿舍房间id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "房间名称")
    private String name;

    @ApiModelProperty(value = "床位总个数")
    private Integer size;

    @ApiModelProperty(value = "空床位个数")
    private Integer emptySize;

    @ApiModelProperty(value = "宿舍所在楼层id")
    private Integer floorId;


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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getEmptySize() {
        return emptySize;
    }

    public void setEmptySize(Integer emptySize) {
        this.emptySize = emptySize;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    @Override
    public String toString() {
        return "Room{" +
        "id=" + id +
        ", name=" + name +
        ", size=" + size +
        ", emptySize=" + emptySize +
        ", floorId=" + floorId +
        "}";
    }
}
