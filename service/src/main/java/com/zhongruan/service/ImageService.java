package com.zhongruan.service;

import com.zhongruan.bean.response.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ImageService {
    /**
     * 上传图片
     * @param type 图片类型0-用户头像，1-商品图片
     * @param id 用户id
     * @param image 上传的图片
     * @return 上传的结果
     */
    Result uploadImage(int type,long id, MultipartFile image);

    /**
     *  获取图片
     * @param type 图片类型0-用户头像，1-商品图片
     * @param id type-0:用户id,type-1:商品Id
     * @return result.message:获取信息，result.data:BufferedImage图片流
     */
    Result getImage(int type, long id, HttpServletResponse response, HttpServletRequest request);
}
