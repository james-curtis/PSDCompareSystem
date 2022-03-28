package com.example.compare.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.compare.common.utils.QRCodeUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.CompareLog;
import com.example.compare.mapper.CompareLogMapper;
import com.example.compare.service.CompareLogService;
import com.example.compare.service.impl.CompareLogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 对比记录表 前端控制器
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Api(tags = "历史记录的各种操作")
@RestController
@RequestMapping("/compare-log")
public class CompareLogController {

    @Autowired
    CompareLogServiceImpl compareLogService;

    /**
     * 对比记录分页查询操作
     *
     * @param current 当前页码
     * @param size    一页最大显示条数
     * @return {@link Result}
     * @author zuojun666
     * @since 2022-03-27
     */
    @ApiOperation(value = "左呈祥===>对比记录分页查询操作   current:当前页码  size:一页最大显示条数")
    @GetMapping("/{current}/{size}")
    public Result page(@PathVariable("current") Long current, @PathVariable("size") Long size) {
        try {
            IPage<CompareLog> page = new Page<>(current, size);
            page = compareLogService.page(page);
            return Result.success(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "服务器繁忙，请稍后再试", "");
        }
    }

    @ApiOperation(value = "郑前====》显示所有数据信息")
    @PostMapping("/compareLogInformation")
    public Result compareLogAccount(){
        return Result.success(compareLogService.selectList());
    }

    @PostMapping("/search")
    @ApiOperation(value = "郑前====》历史记录分页查询,keywords代表流水号,maxPage代表每页显示最大数量，" +
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
        List<CompareLog> search = compareLogService.search(keywords, startTime, endTime, ((startPage-1) * maxPage), maxPage);
        return Result.success(search);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "郑前====》根据id删除相关的历史记录")
    public Result delete(@RequestParam("id") int id){
        Integer orderId = compareLogService.select(id).getOrderid();
        compareLogService.allDelete(orderId);

        return Result.success("成功");
    }

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
        String outTradeId = compareLogService.getOutTradeId(id);
        String url = "http://localhost:8081/"+"index?outTradeId="+outTradeId;
        BufferedImage qr = QRCodeUtil.getBufferedImage(url, size);
        ImageIO.write(qr,"jpg",response.getOutputStream());
//        return Result.success()
    }
}
