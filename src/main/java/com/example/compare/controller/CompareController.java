package com.example.compare.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.service.CompareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/compare")
public class CompareController {
    @Resource
    private CompareService service;

    /**
     * 获取跳转支付界面的二维码
     *
     * @param id       对比记录id
     * @param size     二维码大小
     * @param response
     * @throws IOException
     */
    @ApiOperation("刘锦堂===>获取跳转支付界面的二维码，id： 对比记录id，size： 二维码大小，默认值250")
    @GetMapping("/getQRCode")
    public void getQRCode(Integer id, Integer size, HttpServletResponse response) throws IOException {
        String outTradeId = service.getOrderIdById(id);
        String url = "http://localhost:8081/" + "index?outTradeId=" + outTradeId;
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr, "jpg", response.getOutputStream());
//        return Result.success()
    }

    /**
     * 获取对比记录分页数据
     *
     * @param current 当前页码
     * @param size    一页最大显示条数
     * @return {@link Result}
     */
    @ApiOperation("左呈祥===>获取对比记录分页数据，current：当前页码，size，一页最大显示条数")
    @GetMapping("/{current}/{size}")
    public Result getPage(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        try {
            return Result.success(service.page(new Page<>(current, size)));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "服务器繁忙，请稍后再试", "");
        }
    }
}
