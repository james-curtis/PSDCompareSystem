package com.example.compare.controller;


import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
public class OrderLogController {
    @GetMapping("/getQRCode")
    public void getQRCode(String url, Integer size, HttpServletResponse response) throws IOException {
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr,"jpg",response.getOutputStream());
//        return Result.success()
    }
}
