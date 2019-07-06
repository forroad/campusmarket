package com.zhongruan.service.impl;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.GoodsDao;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class ImageServieImpl implements ImageService {
    @Autowired
    UserDao userDao;
    @Autowired
    GoodsDao goodsDao;


    @Override
    public Result uploadImage(int type, long id, MultipartFile image) {
        if (image == null||image.isEmpty()) {
            //文件为空
            return new Result("文件为空",null);
        }
        String fileAllName = image.getOriginalFilename();
        int index = fileAllName.indexOf(".");
        String imgtype = fileAllName.substring(index,fileAllName.length());
        String path;
        if(type == 0){
            path = "F:\\shixi\\campusmarket\\service\\src\\main\\java\\com\\zhongruan\\service\\img\\user\\";//文件存的路径
        }else {
            path = "F:\\shixi\\campusmarket\\service\\src\\main\\java\\com\\zhongruan\\service\\img\\goods\\";
        }

        File fileImage = new File(path);
        if (!fileImage.getParentFile().exists()) {
            fileImage.getParentFile().mkdirs();
        }
        try {
            String endPath = System.currentTimeMillis() +id + imgtype;
            uploadFile(image.getBytes(), path, endPath);
            return new Result("上传成功",path + endPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //其他错误
        return new Result("上传失败",null);
    }

    @Override
    public Result getImage(int type, long id, HttpServletResponse response, HttpServletRequest request) {
        String fileUrl;
        if(type == 0){
            User user = userDao.findByUserId(id);
            if(user == null){
                return new Result("用户不存在",null);
            }
            fileUrl = user.getUserImage();
        }else {
            Goods goods = goodsDao.findByGoodsId(id);
            if(goods == null){
                return new Result("商品为空",null);
            }
            fileUrl = goods.getGoodsImage();
        }
        if(fileUrl == null || fileUrl.equals("") || fileUrl.length() <= 0){
            return new Result("图片资源不存在",null);
        }
        try {
            File file = new File(fileUrl);

            //判断文件是否存在如果不存在就返回默认图标
            if(!(file.exists() && file.canRead())) {
                return new Result("图片资源不存在",null);
            }

            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[(int)file.length()];
            int length = inputStream.read(data);
            inputStream.close();

            response.setContentType("image/png");

            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
            return new Result("获取成功",fileUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result("获取失败",null);
    }

    private  void uploadFile(byte[] file, String filePath, String fileName)throws Exception{
        File targetFile=new File(filePath);
        if(targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out =new FileOutputStream(filePath+fileName);
        System.out.println(filePath+fileName);
        System.out.println(targetFile.getAbsolutePath());
        out.write(file);
        out.flush();
        out.close();
    }
}
