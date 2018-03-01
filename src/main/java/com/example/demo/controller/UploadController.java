package com.example.demo.controller;

import com.example.demo.entity.PictureEntity;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.service.PictureService;
import com.example.demo.service.TeacherService;
import com.example.demo.utils.R;
import com.example.demo.utils.UploadUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: xieyougen
 * @email: xieyougen@tuandai.com
 * @description:
 * @date: 2018/2/28 11:29
 */
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private PictureService pictureService;

    @Autowired
    private TeacherService teacherService;

    @Value("${img.location}")
    private String location;

    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/avatar1",method = RequestMethod.POST)
    public R upload(HttpServletRequest request, MultipartFile file, int ddlCard){
        String storePath = "D:/upload/";
        String path = null;
        try {
            path= UploadUtil.upload(file,storePath);
        } catch (IOException e) {
            logger.info("上传文件失败");
            e.printStackTrace();
        }
        PictureEntity picture = new PictureEntity();
        picture.setPath(path);
        picture.setType(ddlCard);
        picture.setUploadTime(new Date());
        return R.ok();
    }

    @RequestMapping(value = "/avatar",method = RequestMethod.POST)
    public R upload1(HttpServletRequest request,Integer id) throws JsonProcessingException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String path = null;
        /** 页面控件的文件流* */
        MultipartFile multipartFile = null;
        Map map =multipartRequest.getFileMap();
        for (Iterator i = map.keySet().iterator(); i.hasNext();) {
            Object obj = i.next();
            multipartFile=(MultipartFile) map.get(obj);
        }
        try {
            path= UploadUtil.upload(multipartFile,location);
        } catch (IOException e) {
            logger.info("上传头像失败");
            return R.error();
        }
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setPath(path);
        pictureEntity.setTeacherId(id);
        pictureEntity.setType(0);
        pictureEntity.setUploadTime(new Date());
        pictureEntity.setStatus(0);
        pictureService.save(pictureEntity);
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(id);
        teacherEntity.setAvatar(path);
        teacherService.updateSelective(teacherEntity);
        return R.ok();
    }
}
