package com.lzq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/files")
public class FilesUploadController {
    private static final Logger log = LoggerFactory.getLogger(FilesUploadController.class);

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @PostMapping("/upload")
    @ResponseBody
    public Map<String,String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        //控制台输出日志
        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());
        File newFile = new File("E:\\源码\\文件上传\\upload\\",file.getOriginalFilename());
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        file.transferTo(newFile);

        Map<String,String> result=new HashMap<>();

        result.put("contentType",file.getContentType());
        result.put("filename",file.getOriginalFilename());
        result.put("fileSize",file.getSize()+"");
        return result;
    }
}
