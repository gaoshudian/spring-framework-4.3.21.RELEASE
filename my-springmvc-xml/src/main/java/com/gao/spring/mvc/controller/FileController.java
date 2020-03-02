package com.gao.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 测试文件上传功能
 */
@RestController
public class FileController {

    @RequestMapping(value = "fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file")MultipartFile file, @RequestParam Map map){
        System.out.println(map.get("name"));
        return "上传成功";
    }
}
