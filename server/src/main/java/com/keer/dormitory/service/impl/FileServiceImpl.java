package com.keer.dormitory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.keer.dormitory.constant.ExeclConstant;
import com.keer.dormitory.dto.SortInfo;
import com.keer.dormitory.entity.*;
import com.keer.dormitory.service.*;
import io.swagger.models.Info;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: linhui
 * @Date: 2021/3/25
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    @Resource
    private BlockService blockService;
    @Resource
    private FloorService floorService;
    @Resource
    private RoomService roomService;
    @Resource
    private StudentService studentService;
    @Resource
    private TaskService taskService;

    @Value("${image-location.type1.room-num}")
    private int roomNum;
    @Value("${image-location.type1.room-distance}")
    private int roomDistance;
    @Value("${image-location.type1.room-size}")
    private int roomSize;
    @Value("${image-location.type1.up.stop-x}")
    private Integer[] upStopX;
    @Value("${image-location.type1.down.stop-x}")
    private Integer[] downStopX;
    @Value("${image-location.type1.up.start-x}")
    private int upStartX;
    @Value("${image-location.type1.up.start-y}")
    private int upStartY;
    @Value("${image-location.type1.down.start-x}")
    private int downStartX;
    @Value("${image-location.type1.down.start-y}")
    private int downStartY;

    @Override
    public void asyncCreateBlock(String path) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet blockInfos = wb.getSheet(ExeclConstant.SHEET_BLOCKINFO);
        List<Floor> allfloors = new ArrayList<>();
        for (int i = 1; i <= blockInfos.getLastRowNum(); i++) {
            Row row = blockInfos.getRow(i);
            Block block = new Block();
            block.setName(row.getCell(1).getStringCellValue());
            block.setRoomSize((int) row.getCell(2).getNumericCellValue());
            block.setFloorSize((int) row.getCell(3).getNumericCellValue());
            block.setSex(row.getCell(4).getStringCellValue());
            blockService.save(block);

            List<Floor> floors = new ArrayList<>();
            int floorNum = (int) row.getCell(3).getNumericCellValue();
            for (int j = 0; j < floorNum; j++) {
                Floor floor = new Floor();
                floor.setName((j + 1) + "层");
                floor.setFloorNum(j + 1);
                floor.setBlockId(block.getId());
                floors.add(floor);
                allfloors.add(floor);
            }
            floorService.saveBatch(floors);
            Map<Integer, Integer> numToId = floors.stream().collect(Collectors.toMap(Floor::getFloorNum, Floor::getId));
            Sheet roomInfo = wb.getSheet(i + ExeclConstant.SHEET_ROOMINFO);
            int roomSize = roomInfo.getLastRowNum();
            List<Room> rooms = new ArrayList<>();
            for (int k = 1; k <= roomSize; k++) {
                Row roomRow = roomInfo.getRow(k);
                Room room = new Room();
                room.setName((int) roomRow.getCell(1).getNumericCellValue() + "");
                room.setFloorId(numToId.get((int) roomRow.getCell(2).getNumericCellValue()));
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
        for (Floor floor : allfloors) {
            QueryWrapper<Room> queryWrapperDown = new QueryWrapper<>();
            queryWrapperDown.eq("floor_id", floor.getId());
            queryWrapperDown.eq("mod(`name`,2)", 0);
            List<Room> downRooms = roomService.list(queryWrapperDown);
            for (int i = 0, j = 0; j < roomNum && i < downRooms.size(); j++) {
                Integer x = downStartX + j * roomDistance;
                List<Integer> downStopXs = Arrays.asList(downStopX);
                if (downStopXs.contains(x)) {
                    continue;
                }
                downRooms.get(i).setX(x.toString());
                downRooms.get(i).setY(downStartY + "");
                i++;
            }
            roomService.updateBatchById(downRooms);

            QueryWrapper<Room> queryWrapperUp = new QueryWrapper<>();
            queryWrapperUp.eq("floor_id", floor.getId());
            queryWrapperUp.eq("mod(`name`,2)", 1);
            List<Room> upRooms = roomService.list(queryWrapperUp);
            for (int i = 0, j = 0; j < roomNum && i < upRooms.size(); j++) {
                Integer x = upStartX + j * roomDistance;
                List<Integer> upStopXs = Arrays.asList(upStopX);
                if (upStopXs.contains(x)) {
                    continue;
                }
                upRooms.get(i).setX(x.toString());
                upRooms.get(i).setY(upStartY * roomSize + "");
                i++;
            }
            roomService.updateBatchById(upRooms);

        }
    }

    @Override
    @Async(value = "asyncThreadExecutor")
    public void asyncCreateStudent(int taskId) {
        Task task = taskService.getById(taskId);
        task.setThreadId(Thread.currentThread().getId() + "");
        task.setStatus(1);
        taskService.updateById(task);

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(task.getFilePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet studentInfos = wb.getSheetAt(0);
        List<Student> students = new ArrayList<>();
        /**
         * 先将文件数据存入数据库
         */
        for (int i = 1; i < studentInfos.getLastRowNum(); i++) {
            Row row = studentInfos.getRow(i);
            Student student = new Student();
            student.setId(row.getCell(0).getStringCellValue());
            student.setName(row.getCell(1).getStringCellValue());
            student.setIdentityNum(row.getCell(2).getStringCellValue());
            student.setNation(row.getCell(3).getStringCellValue());
            student.setSex(row.getCell(4).getStringCellValue());
            student.setAcademy(row.getCell(5).getStringCellValue());
            student.setMajor(row.getCell(6).getStringCellValue());
            student.setClassNum(row.getCell(7).getStringCellValue());
            student.setRegion(row.getCell(8).getStringCellValue());
            student.setPhoneNum(row.getCell(9).getStringCellValue());
            student.setAddress(row.getCell(10).getStringCellValue());
            student.setTaskId(taskId);
            students.add(student);
            if (students.size() == 50) {
                studentService.saveBatch(students);
                students = new ArrayList<>();
            }
        }
        studentService.saveBatch(students);
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
