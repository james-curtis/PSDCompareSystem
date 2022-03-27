package com.example.compare.controller;



import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.OrderLog;
import com.example.compare.service.OrderLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;


/**
 * <p>
 * 支付订单表 前端控制器
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Controller
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
    @ApiOperation("刘锦堂===>获取跳转支付界面的二维码，url： 跳转的url，size： 二维码大小，默认值250")
    @GetMapping("/getQRCode")
    public void getQRCode(String url, Integer size, HttpServletResponse response) throws IOException {
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr,"jpg",response.getOutputStream());
//        return Result.success()
    }

    @GetMapping("/getOrderId")
    @ApiOperation("/获取订单编号")
    public Result getOrderId(){
        OrderLog orderLog = service.insertOrderLog();
        return Result.success(orderLog.getOutTradeId());
    }


    @ApiOperation("朱涵===>发起请求支付")
    @GetMapping("/topay/{id}")
    public String topay(@PathVariable String id, Model model) {
        OrderLog orderLog = service.getOrderLog(id);
        String form = service.AlipayUtils(orderLog);
        model.addAttribute("form",form);
        return "pay";
    }





}
