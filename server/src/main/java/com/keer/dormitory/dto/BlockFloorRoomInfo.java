package com.keer.dormitory.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockFloorRoomInfo {
    private List<Menu> blocks;
    private Map<String, List<Menu>> floors;
    private Map<String, List<Menu>> rooms;

    public List<Menu> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Menu> blocks) {
        this.blocks = blocks;
    }

    public Map<String, List<Menu>> getFloors() {
        return floors;
    }

    public void setFloors(Map<String, List<Menu>> floors) {
        this.floors = floors;
    }

    public Map<String, List<Menu>> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, List<Menu>> rooms) {
        this.rooms = rooms;
    }

    public void addBlockMenu(Menu menu) {
        if (this.blocks == null) {
            this.blocks = new ArrayList<>();
        }
        this.blocks.add(menu);
    }

    public void putFloor(String blockId, Menu menu) {
        if (this.floors == null) {
            this.floors = new HashMap<>();
        }
        if (this.floors.get(blockId) == null) {
            this.floors.put(blockId, new ArrayList<>());
        }
        this.floors.get(blockId).add(menu);
    }

    public void putRoom(String floorId, Menu menu) {
        if (this.rooms == null) {
            this.rooms = new HashMap<>();
        }
        if (this.rooms.get(floorId) == null) {
            this.rooms.put(floorId, new ArrayList<>());
        }
        this.rooms.get(floorId).add(menu);
    }
}
