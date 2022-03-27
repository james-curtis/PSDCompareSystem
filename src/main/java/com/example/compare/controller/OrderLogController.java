package com.example.compare.controller;


import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.OrderLog;
import com.example.compare.service.OrderLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 支付订单表 前端控制器
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/order-log")
@Api(value = "OrderLogController")
public class OrderLogController {
    @Autowired
    OrderLogService service;
    /**
     * 获取跳转支付界面的二维码
     * @param url 跳转的url
     * @param size 二维码大小
     * @param response
     * @throws IOException
     */
    @ApiOperation("刘锦堂===>获取跳转支付界面的二维码，url： 跳转的url，size： 二维码大小，")
    @GetMapping("/getQRCode")
    public void getQRCode(String url, Integer size, HttpServletResponse response) throws IOException {
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr,"jpg",response.getOutputStream());
//        return Result.success()
    }

    @GetMapping("/getOrderId")
    public Result getOrderId(){
        OrderLog orderLog = service.insertOrderLog();
        return Result.success(orderLog.getOutTradeId());
    }

    @ApiOperation(value = "郑前====》显示所有数据信息")
    @PostMapping("/OrderLogInformation")
    public Result orderLogAccount(){
        return Result.success(service.select());
    }

    @PostMapping("/search")
    @ApiOperation(value = "郑前====》分页查询,keywords代表流水号或者支付状态,maxPage代表每页显示最大数量，" +
            "startPage代表开始页码,startTime和endTime代表要查询的时间段")
    public Result search(@RequestBody Map<String,String> map){
        //最大显示数量默认为10
        int maxPage=10;
        //起始页码默认为1
        int startPage=1;
        String mPage = map.get("maxPage");
        String sPage =map.get("startPage");
        String keywords=map.get("keyWords");
        String startTime=map.get("startTime");
        String endTime=map.get("endTime");
        if(sPage!=null){
            startPage=Integer.parseInt(sPage);
        }
        if (mPage!=null){
            maxPage=Integer.parseInt(mPage);
        }
        List<OrderLog> search = service.Search(keywords, startTime, endTime, ((startPage-1) * maxPage), maxPage);
        return Result.success(search);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "郑前====》根据id删除历史记录")
    public Result delete(@RequestParam("id") int id){
        service.deleteById(id);
        return Result.success("成功");
    }
}
