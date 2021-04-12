package com.keer.dormitory.dto;

import java.util.List;

/**
 * /user POST接口 对象
 */
public class SetBlockManagerDTO {
    private String userName;
    private List<Integer> block;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getBlock() {
        return block;
    }

    public void setBlock(List<Integer> block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "SetBlockManagerDTO{" +
                "userName='" + userName + '\'' +
                ", block=" + block +
                '}';
    }
}
