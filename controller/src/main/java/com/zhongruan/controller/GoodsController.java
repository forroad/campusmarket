package com.zhongruan.controller;

import com.zhongruan.bean.Goods;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {
    private GoodsService goodsService;
    private HttpSession session;
    private GoodsTypeDao goodsTypeDao;
    private ImageService imageService;
    private HttpServletRequest request;

    @Autowired
    public GoodsController(GoodsService goodsService, HttpSession session, GoodsTypeDao goodsTypeDao, ImageService imageService, HttpServletRequest request) {
        this.goodsService = goodsService;
        this.session = session;
        this.goodsTypeDao = goodsTypeDao;
        this.imageService = imageService;
        this.request = request;
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

    @RequestMapping("subGoods")
    public String subGoods(Long goodsId,Model model){
        Result result = goodsService.subGoods(goodsId);
        if(result.getMessage().equals("下架成功")){
            Result result1 = goodsService.findByNotBuyAndAdd(Long.valueOf(request.getSession().getAttribute("userId").toString()));
            model.addAttribute("goodsList",result1.getData());
            return "myshopping";
        }
        model.addAttribute("result","下架失败");
        Result result2 = goodsService.findByNotBuyAndAdd(Long.valueOf(request.getSession().getAttribute("userId").toString()));
        model.addAttribute("goodsList",result2.getData());
        return "myshopping";
    }

    @RequestMapping("buyGoods")
    public String buyGoods(Long goodsId,Model model){
        Result result1 = goodsService.buyGoods(Long.valueOf(request.getSession().getAttribute("userId").toString()),goodsId);
        Result result = goodsService.findByIsBuyAndUserId(Long.valueOf(request.getSession().getAttribute("userId").toString()));
        if(!result1.getMessage().equals("购买成功")){
            model.addAttribute("result",result1.getMessage());
            model.addAttribute("goodsList",result.getData());
            return "mycart";
        }
        model.addAttribute("goodsList",result.getData());
        return "myorder";
    }

    @RequestMapping("findGoodsByType")
    public String findGoodsByType(String typeName,Model model){
        Result findResult = goodsService.findGoodsByType(typeName);
        if(findResult.getMessage().equals("查询成功")){
            return goodsService.returnPageList((List<Goods>) findResult.getData(),1,20,true,model);
        }
        model.addAttribute("result",findResult.getMessage());
        return goodsService.returnPageList((List<Goods>) goodsService.findGoodsExc().getData(),1,20,true,model);
    }

    @RequestMapping("findByGoodsPopularityDesc")
    public String findByGoodsPopularityDesc(Model model){
        Result findResult = goodsService.findByGoodsPopularityDesc();
        return goodsService.returnPageList((List<Goods>) findResult.getData(),1,20,true,model);
    }

    @RequestMapping("findByGoodsPriceDesc")
    public String findByGoodsPriceDesc(Model model){
        Result findResult = goodsService.findByGoodsPriceDesc();
        return goodsService.returnPageList((List<Goods>) findResult.getData(),1,20,true,model);
    }

    @RequestMapping("findByGoodsPriceAsc")
    public String findByGoodsPriceAsc(Model model){
        Result findResult = goodsService.findByGoodsPriceAsc();
        return goodsService.returnPageList((List<Goods>) findResult.getData(),1,20,true,model);
    }

    @RequestMapping("page")
    public String page(Integer pageNum,Model model){
        return goodsService.returnPageList(null,pageNum,20,false,model);
    }

}
