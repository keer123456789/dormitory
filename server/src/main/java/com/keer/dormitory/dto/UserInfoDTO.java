package com.keer.dormitory.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * 用户列表信息
 */
public class UserInfoDTO {
    private String name;
    private Integer role;
    private String buildName;
    private Integer buildId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", buildName='" + buildName + '\'' +
                ", buildId=" + buildId +
                '}';
    }
}
