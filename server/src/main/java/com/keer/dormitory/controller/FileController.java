package com.keer.dormitory.controller;

import com.keer.dormitory.core.base.BaseController;
import com.keer.dormitory.core.model.Result;
import com.keer.dormitory.service.FileService;
import com.keer.dormitory.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author: keer
 * @Date: 2021/3/25
 * @Description:
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件上传管理接口")
public class FileController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${file.block-path}")
    private String blockPath;

    @Value("${file.student-path}")
    private String studentPath;

    @Resource
    private FileService fileService;

    @ApiOperation(value = "上传宿舍楼信息文件接口")
    @PostMapping("/block/upload")
    @ResponseBody
    public Result<String> uploadBlock(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(blockPath + fileName);
        try {
            file.transferTo(dest);
            if (ExcelUtil.checkExcelBlockModel(blockPath + fileName)) {
                fileService.asyncCreateBlock(blockPath + fileName);
                return Result.ok();
            } else {
                dest.delete();
                return Result.error("校验文件失败，请按照模板正确填写");
            }

        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return Result.error("上传失败，请选择文件");
    }

    @ApiOperation(value = "校验宿舍楼信息文件接口")
    @PostMapping("/block/valid")
    @ResponseBody
    public Result<String> validBlockFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(blockPath + fileName);
        try {
            file.transferTo(dest);
            if (ExcelUtil.checkExcelBlockModel(blockPath + fileName)) {
                return Result.ok();
            } else {
                dest.delete();
                return Result.error("校验文件失败，请按照模板正确填写");
            }

        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return Result.error("上传失败，请选择文件");
    }


    @ApiOperation(value = "上传学生信息文件接口")
    @PostMapping("/student/upload")
    @ResponseBody
    public Result<String> uploadStudent(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(studentPath + fileName);
        try {
            file.transferTo(dest);
            if (ExcelUtil.checkExcelStudentModel(studentPath + fileName)) {
                //TODO 批量导入学生信息
                return Result.ok();
            } else {
                dest.delete();
                return Result.error("校验文件失败，请按照模板正确填写");
            }

        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return Result.error("上传失败，请选择文件");
    }


    @GetMapping("/test")
    public Result uploadStudent() {
//        fileService.asyncCreateStudent("file/学生信息导入模板.xlsx");
        fileService.asyncCreateBlock("file/宿舍楼导入模板.xlsx");
        return Result.ok();
    }

    @ApiOperation(value = "校验学生信息文件接口")
    @PostMapping("/student/valid")
    @ResponseBody
    public Result validStudent(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(studentPath + fileName);
        try {
            file.transferTo(dest);
            if (ExcelUtil.checkExcelStudentModel(studentPath + fileName)) {
                return Result.ok();
            } else {
                dest.delete();
                return Result.error("校验文件失败，请按照模板正确填写");
            }

        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return Result.error("上传失败，请选择文件");
    }

}
