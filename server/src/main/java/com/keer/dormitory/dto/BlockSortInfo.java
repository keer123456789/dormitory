package com.keer.dormitory.dto;

import java.util.List;

public class BlockSortInfo {
    private int roomSize;
    private int roomNum;
    private int studentNum;
    private List<SortInfo> maleInfo;
    private List<SortInfo> femaleInfo;

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public List<SortInfo> getMaleInfo() {
        return maleInfo;
    }

    public void setMaleInfo(List<SortInfo> maleInfo) {
        this.maleInfo = maleInfo;
    }

    public List<SortInfo> getFemaleInfo() {
        return femaleInfo;
    }

    public void setFemaleInfo(List<SortInfo> femaleInfo) {
        this.femaleInfo = femaleInfo;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "BlockSortInfo{" +
                "roomSize=" + roomSize +
                ", roomNum=" + roomNum +
                ", studentNum=" + studentNum +
                ", maleInfo=" + maleInfo +
                ", femaleInfo=" + femaleInfo +
                '}';
    }
}
