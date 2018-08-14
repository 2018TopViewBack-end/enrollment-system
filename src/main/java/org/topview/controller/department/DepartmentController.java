package org.topview.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.topview.entity.department.po.Department;
import org.topview.service.department.DepartmentService;
import org.topview.util.ImgUtil;
import org.topview.util.Result;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @param file  文件对象
     * @param department  要保存的部门对象
     * @return Result
     */
    @PostMapping("/saveDepartment")
    @ResponseBody
    public Result saveDepartment(@RequestParam(value = "file",required = false) MultipartFile file,
                                 Department department
    ) {
        //接收返回的要保存到数据库的路径
        String filePath = ImgUtil.savePicture(file);
        if(filePath !=null){
            department.setLogoUrl(filePath);
            departmentService.saveDepartment(department);
            return Result.success(department);
        }else {
            return Result.fail("上传图片失败");
        }

    }
}