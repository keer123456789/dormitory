package com.keer.dormitory.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.keer.dormitory.constant.ExeclConstant;
import com.keer.dormitory.entity.Block;
import com.keer.dormitory.entity.Floor;
import com.keer.dormitory.entity.Room;
import com.keer.dormitory.service.BlockService;
import com.keer.dormitory.service.FileService;
import com.keer.dormitory.service.FloorService;
import com.keer.dormitory.service.RoomService;
import jdk.internal.org.objectweb.asm.Handle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author: linhui
 * @Date: 2021/3/25
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    @Resource
    BlockService blockService;
    @Resource
    FloorService floorService;
    @Resource
    RoomService roomService;

    @Override
    public void asyncCreateBlock(String path)  {
//        new Thread(() -> {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet blockInfos = wb.getSheet(ExeclConstant.SHEET_BLOCKINFO);
        for (int i = 1; i <= blockInfos.getLastRowNum(); i++) {
            Row row = blockInfos.getRow(i);
            Block block = new Block();
            block.setName(row.getCell(1).getStringCellValue());
            block.setRoomSize((int) row.getCell(2).getNumericCellValue());
            block.setFloorSize((int) row.getCell(3).getNumericCellValue());
            blockService.save(block);

            int floorNum = (int) row.getCell(3).getNumericCellValue();
            List<Floor> floors = new ArrayList<>();
            for (int j = 0; j < floorNum; j++) {
                Floor floor = new Floor();
                floor.setName((j + 1) + "层");
                floor.setFloorNum(j + 1);
                floor.setBlockId(block.getId());
                floors.add(floor);
            }
            floorService.saveBatch(floors);
            Map<Integer, Integer> numToId = floors.stream().collect(Collectors.toMap(Floor::getFloorNum, Floor::getId));
            Sheet roomInfo = wb.getSheet(i + ExeclConstant.SHEET_ROOMINFO);
            int roomSize = roomInfo.getLastRowNum();
            List<Room> rooms = new ArrayList<>();
            for (int k = 1; k <= roomSize; k++) {
                Row roomRow = roomInfo.getRow(k);
                Room room = new Room();
                room.setName((int)roomRow.getCell(1).getNumericCellValue()+"");
                room.setFloorId(numToId.get((int)roomRow.getCell(2).getNumericCellValue()));
                room.setSize(block.getRoomSize());
                room.setEmptySize(block.getRoomSize());
                rooms.add(room);
                if (rooms.size() > 100 || k == roomSize) {
                    roomService.saveBatch(rooms);
                    rooms = new ArrayList<>();
                }
            }
        }
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }).start();
    }

    @Override
    public void asyncCreateStudent(String path) {

    }

    public static void main(String[] args) {
        List<Floor> floors = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Floor floor = new Floor();
            floor.setId(j + 20);
            floor.setName((j + 1) + "层");
            floor.setFloorNum(j + 1);
            floor.setBlockId(2);
            floors.add(floor);
        }
        Map<Integer, Integer> numToId = floors.stream().collect(Collectors.toMap(Floor::getFloorNum, Floor::getId));
        System.out.println(numToId);
    }
}
