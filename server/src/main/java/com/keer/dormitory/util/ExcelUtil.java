package com.keer.dormitory.util;

import com.keer.dormitory.constant.ExeclConstant;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelUtil {
    public static void main(String[] args) throws Exception {

        System.out.println(checkExcelBlockModel("file/宿舍楼导入模板.xlsx"));
        System.out.println(checkExcelStudentModel("file/学生信息导入模板.xlsx"));

    }

    /**
     * 检查宿舍楼信息导入文件格式是否正确
     *
     * @param path 文件路径
     * @return
     */
    public static boolean checkExcelBlockModel(String path) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet block = wb.getSheet(ExeclConstant.SHEET_BLOCKINFO);
        if (block == null) {
            return false;
        }
        Row r = block.getRow(0);
        if (!r.getCell(ExeclConstant.CELL_NUM_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_NUM)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_BLOCK_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_BLOCK)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_ROOM_SIZE_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_ROOM_SIZE)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_FlOOR_NUM_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_FlOOR_NUM)) {
            return false;
        }
        System.out.println(block.getLastRowNum());
        for (int i = 1; i <= block.getLastRowNum(); i++) {
            Sheet room = wb.getSheet(i + ExeclConstant.SHEET_ROOMINFO);
            if (room == null) {
                return false;
            }
            Row info = room.getRow(0);
            if (!info.getCell(ExeclConstant.CELL_NUM_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_NUM)) {
                return false;
            }
            if (!info.getCell(ExeclConstant.CELL_ROOM_NAME_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_ROOM_NAME)) {
                return false;
            }
            if (!info.getCell(ExeclConstant.CELL_ROOM_FLOOR_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_ROOM_FLOOR)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查学生信息导入文件格式是否正确
     * @param path 文件路径
     * @return
     */
    public static boolean checkExcelStudentModel(String path) {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet student = wb.getSheetAt(0);
        if (student == null) {
            return false;
        }
        Row r = student.getRow(0);
        if (!r.getCell(ExeclConstant.CELL_NUM_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_NUM)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_STUDENT_NAME_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_STUDENT_NAME)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_IDENTITY_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_IDENTITY)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_NATION_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_NATION)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_SEX_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_SEX)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_ACADEMY_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_ACADEMY)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_MAJOR_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_MAJOR)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_CLASS_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_CLASS)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_REGION_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_REGION)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_PHONE_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_PHONE)) {
            return false;
        }
        if (!r.getCell(ExeclConstant.CELL_ADD_LOCATION).getStringCellValue().equals(ExeclConstant.CELL_ADD)) {
            return false;
        }
        return true;
    }
}
