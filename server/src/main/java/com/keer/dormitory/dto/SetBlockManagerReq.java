package com.keer.dormitory.dto;

import java.util.List;

/**
 * /user POST接口 对象
 */
public class SetBlockManagerReq {
    private String name;
    private Integer buildId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    @Override
    public String toString() {
        return "SetBlockManagerReq{" +
                "name='" + name + '\'' +
                ", buildId=" + buildId +
                '}';
    }
}
