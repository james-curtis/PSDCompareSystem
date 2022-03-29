package com.example.compare.controller;

import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.service.CompareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CompareController {
    @Autowired
    CompareService service;

    @Autowired
    StringRedisTemplate redisTemplate;
    /**
     * 获取跳转支付界面的二维码
     * @param id 对比记录id
     * @param size 二维码大小
     * @param response
     * @throws IOException
     */
    @ApiOperation("刘锦堂===>获取跳转支付界面的二维码，id： 对比记录id，size： 二维码大小，默认值250")
    @GetMapping("/getQRCode")
    public void getQRCode(Integer id, Integer size, HttpServletResponse response) throws IOException {
        String outTradeId = service.getOrderIdById(id);
        String url = "http://localhost:8081/"+"index?outTradeId="+outTradeId;
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr,"jpg",response.getOutputStream());
//        return Result.success()
    }

    /**
     * 轮训交易状态接口
     * @param id compare记录id
     * @return
     */
    @GetMapping("/getStatus")
    @ApiOperation("刘锦堂===>轮训支付状态，id：compare记录表id")
    public Result getStatus(Integer id){
        String status =redisTemplate.opsForValue().get(id);
        return Result.success(status);
    }
}
