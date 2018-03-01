package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: xieyougen
 * @email: xieyougen@tuandai.com
 * @description:
 * @date: 2018/2/1 9:30
 */
public class UploadUtil {

    public static String  upload(MultipartFile file, String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists())
            dir.mkdirs();
        //获取文件后缀名
        //String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = file.getOriginalFilename();
        File tagetFile = new File(path+fileName);
        file.transferTo(tagetFile);
        return fileName;
    }

}
