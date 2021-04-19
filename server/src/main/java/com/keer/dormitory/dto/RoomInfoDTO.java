package com.keer.dormitory.dto;

public class RoomInfoDTO {
    private String name;
    private int floorNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    @Override
    public String toString() {
        return "RoomInfoDTO{" +
                "name='" + name + '\'' +
                ", floorNum=" + floorNum +
                '}';
    }
}
