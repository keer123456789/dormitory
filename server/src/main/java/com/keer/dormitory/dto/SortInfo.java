package com.keer.dormitory.dto;

public class SortInfo {
    private int blockId;
    private String blockName;
    private int emptyRoom;

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getEmptyRoom() {
        return emptyRoom;
    }

    public void setEmptyRoom(int emptyRoom) {
        this.emptyRoom = emptyRoom;
    }

    @Override
    public String toString() {
        return "SortInfo{" +
                "blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                ", emptyRoom=" + emptyRoom +
                '}';
    }
}
