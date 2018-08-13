package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.Result;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class DepartmentController {
    private static final String IMAGES_PATH = "web/images/";
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/saveDepartment")
    @ResponseBody
    public Result saveDepartment(@RequestParam("file") MultipartFile file,
                                 @RequestBody Department department
                                 ) {
        System.out.println("HHH");
        //将图片保存到本地项目的web/images/....下
        File file1 = null;
        try (InputStream in = file.getInputStream();) {
            String fileName = UUID.randomUUID().toString();
            Path path = Paths.get(IMAGES_PATH, fileName);
            file1 = path.toFile();
            //将该文件复制到目标路径
            Files.copy(in, path);
            //获取图片的logoUrl路径
            department.setLogoUrl(IMAGES_PATH + fileName);
            System.out.println(department);
            //保存该部门
            departmentService.saveDepartment(department);
            return Result.success();
        } catch (IOException e) {
            //上传文件失败，删除文件
            file1.delete();
            String message = "上传文件失败";
            return Result.fail(message);
        }
    }
}
