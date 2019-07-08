package com.zhongruan.controller;

import com.google.gson.Gson;
import com.zhongruan.bean.response.Result;
import com.zhongruan.bean.util.ImgUtil;
import com.zhongruan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("img")
public class ImageController {
    private Gson gson = new Gson();
    @Autowired
    ImageService imageService;

    @RequestMapping("uploadImg")
    public String uploadImage(@RequestParam("image") MultipartFile image,
                              HttpServletRequest request,int type,int id){
        Result result = imageService.uploadImage(type, id, image);
        return gson.toJson(result);
    }

    @GetMapping(value = "getImg",produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImg(Integer type, Long id, HttpServletResponse response,HttpServletRequest request){
        imageService.getImage(type,id,response,request);
    }

    @GetMapping("getSyscode")
    public void getSyscode(HttpServletRequest request,HttpServletResponse response){
        ImgUtil.ran(request, response);
    }
}
