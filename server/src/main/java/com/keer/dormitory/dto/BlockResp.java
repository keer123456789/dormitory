package com.keer.dormitory.dto;

/**
 * /block [GET] 接口返回值
 */
public class BlockResp {
    private Integer id;
    private String name;
    private String managerName;
    private Integer floorNum;
    private Integer studentNum;
    private Integer roomNum;

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "BlockResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", floorNum=" + floorNum +
                ", studentNum=" + studentNum +
                ", roomNum=" + roomNum +
                '}';
    }
}
