package com.keer.dormitory.dto;


import java.util.List;

/**
 * 用户列表信息
 */
public class UserInfoDTO {
    private String userName;
    private Integer role;
    private List<BlockInfo> blockInfos;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<BlockInfo> getBlockInfos() {
        return blockInfos;
    }

    public void setBlockInfos(List<BlockInfo> blockInfos) {
        this.blockInfos = blockInfos;
    }

    public void addBlockInfo(Integer blockId,String blockName){
        this.blockInfos.add(new BlockInfo(blockId,blockName));
    }

    @Override
    public String toString() {
        return "UserInfoDTO{}";
    }

    public class BlockInfo{
        private Integer blockId;
        private String blockName;

        public BlockInfo(Integer blockId,String blockName){
            this.blockId=blockId;
            this.blockName=blockName;
        }

        public Integer getBlockId() {
            return blockId;
        }

        public void setBlockId(Integer blockId) {
            this.blockId = blockId;
        }

        public String getBlockName() {
            return blockName;
        }

        public void setBlockName(String blockName) {
            this.blockName = blockName;
        }

        @Override
        public String toString() {
            return "BlockInfo{" +
                    "blockId='" + blockId + '\'' +
                    ", blockName='" + blockName + '\'' +
                    '}';
        }
    }

}
