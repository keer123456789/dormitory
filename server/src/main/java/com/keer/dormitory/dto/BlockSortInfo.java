package com.keer.dormitory.dto;

import java.util.List;

public class BlockSortInfo {
    private int roomSizeMale;
    private int roomSizeFemale;
    private int roomNumMale;
    private int roomNumFemale;
    private int maleNum;
    private int femaleNum;
    private List<SortInfo> maleInfo;
    private List<SortInfo> femaleInfo;

    public int getRoomNumMale() {
        return roomNumMale;
    }

    public void setRoomNumMale(int roomNumMale) {
        this.roomNumMale = roomNumMale;
    }

    public int getRoomNumFemale() {
        return roomNumFemale;
    }

    public void setRoomNumFemale(int roomNumFemale) {
        this.roomNumFemale = roomNumFemale;
    }

    public int getRoomSizeMale() {
        return roomSizeMale;
    }

    public void setRoomSizeMale(int roomSizeMale) {
        this.roomSizeMale = roomSizeMale;
    }

    public int getRoomSizeFemale() {
        return roomSizeFemale;
    }

    public void setRoomSizeFemale(int roomSizeFemale) {
        this.roomSizeFemale = roomSizeFemale;
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

    public int getMaleNum() {
        return maleNum;
    }

    public void setMaleNum(int maleNum) {
        this.maleNum = maleNum;
    }

    public int getFemaleNum() {
        return femaleNum;
    }

    public void setFemaleNum(int femaleNum) {
        this.femaleNum = femaleNum;
    }

    @Override
    public String toString() {
        return "BlockSortInfo{" +
                "roomSizeMale=" + roomSizeMale +
                ", roomSizeFemale=" + roomSizeFemale +
                ", roomNumMale=" + roomNumMale +
                ", roomNumFemale=" + roomNumFemale +
                ", maleNum=" + maleNum +
                ", femaleNum=" + femaleNum +
                ", maleInfo=" + maleInfo +
                ", femaleInfo=" + femaleInfo +
                '}';
    }
}
