package com.keer.dormitory.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 任务表
 * </p>
 *
 * @author linhui
 * @since 2021-04-12
 */
@ApiModel(value="Task对象", description="任务表")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键 自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "宿舍楼号")
    private Integer blockId;

    @ApiModelProperty(value = "房间大小")
    private Integer roomSize;

    @ApiModelProperty(value = "线程id")
    private String threadId;

    @ApiModelProperty(value = "任务状态 0-未开始 1-正在运行 2-运行结束 1-任务失败")
    private Integer status;

    @ApiModelProperty(value = "导入学生信息文件（excel）位置")
    private String filePath;

    @ApiModelProperty(value = "用户id")
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Task{" +
        "id=" + id +
        ", blockId=" + blockId +
        ", roomSize=" + roomSize +
        ", threadId=" + threadId +
        ", status=" + status +
        ", filePath=" + filePath +
        ", userId=" + userId +
        "}";
    }
}
