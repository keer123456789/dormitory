package com.keer.dormitory.dto;

import com.keer.dormitory.entity.Block;

import java.util.List;

/**
 * 增加宿舍楼接口 ：[POST] /block
 * RequestBody
 */
public class BlockInfoReq {
    private Block block;
    private List<RoomInfoDTO> rooms;

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public List<RoomInfoDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomInfoDTO> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "BlockInfoDTO{" +
                "block=" + block +
                ", rooms=" + rooms +
                '}';
    }
}
