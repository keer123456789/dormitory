package com.keer.dormitory.dto;

import java.util.List;

public class CreateTask {
    private List<Integer> maleBlocks;
    private List<Integer> femaleBlocks;
    private Integer roomSize;

    public List<Integer> getMaleBlocks() {
        return maleBlocks;
    }

    public void setMaleBlocks(List<Integer> maleBlocks) {
        this.maleBlocks = maleBlocks;
    }

    public List<Integer> getFemaleBlocks() {
        return femaleBlocks;
    }

    public void setFemaleBlocks(List<Integer> femaleBlocks) {
        this.femaleBlocks = femaleBlocks;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    @Override
    public String toString() {
        return "CreateTask{" +
                "maleBlocks=" + maleBlocks +
                ", femaleBlocks=" + femaleBlocks +
                ", roomSize=" + roomSize +
                '}';
    }
}
