package com.zhongruan.controller;

import com.zhongruan.bean.GoodsType;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.GoodsTypeDao;
import com.zhongruan.service.GoodsService;
import com.zhongruan.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("goods")
public class GoodsController {
    private GoodsService goodsService;
    private HttpSession session;
    private GoodsTypeDao goodsTypeDao;
    private ImageService imageService;

    @Autowired
    public GoodsController(GoodsService goodsService, HttpSession session, GoodsTypeDao goodsTypeDao, ImageService imageService) {
        this.goodsService = goodsService;
        this.session = session;
        this.goodsTypeDao = goodsTypeDao;
        this.imageService = imageService;
    }

    @RequestMapping(value = "addGoods",method = RequestMethod.POST)
    public String addGoods(@RequestParam MultipartFile file,
                           String typeName, String goodsName, String goodsContent,
                           Integer goodsNumber, Double goodsNowPrice,
                           Model model){
        String userId = session.getAttribute("userId").toString();
        //System.out.println(file.isEmpty());
        if(userId == null ||userId.isEmpty()){
            model.addAttribute("result","用户未登录");
            return "index";
        }
        long id = Long.valueOf(userId);
        GoodsType type = goodsTypeDao.findByGoodsTypeName(typeName);
        if(type == null){
            System.out.println("typeName:" + typeName);
            System.out.println("goodsName:" + goodsName);
            System.out.println("goodsContent:" + goodsContent);
            System.out.println("goodsNumber:" + goodsNumber);
            System.out.println("goodsNowPrice:" + goodsNowPrice);
            model.addAttribute("result","服务器出错，请重新登录");
            return "login";
        }
        Result imgResult = imageService.uploadImage(1,id,file);
        if(!imgResult.getMessage().equals("上传成功")){
            System.out.println(imgResult.getMessage());
            model.addAttribute("result","上传图片失败，请稍后重试！");
            return "addshopping";
        }
        Result result = goodsService.addGoods(id,type.getTypeId(),goodsName,goodsContent,
                goodsNumber,0,goodsNowPrice,(int)(Math.random()*100),10,(String)imgResult.getData());

        if(result.getMessage().equals("增加成功")){
            model.addAttribute("result","发布成功");
            return "index";
        }
        System.out.println("上传图片失败，请稍后重试！ + 1");
        model.addAttribute("result","发布失败");
        return "addshopping";
    }
}
