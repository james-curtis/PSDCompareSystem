package com.example.compare.controller;


import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.OrderLog;
import com.example.compare.service.OrderLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
}
