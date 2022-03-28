package com.example.compare.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.compare.common.utils.QiniuCloudUtil;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.Attachment;
import com.example.compare.entity.CompareLog;
import com.example.compare.entity.OrderLog;
import com.example.compare.service.AttachmentService;
import com.example.compare.service.CompareLogService;
import com.example.compare.service.OrderLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController
{
    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private CompareLogService compareLogService;

    @Autowired
    private OrderLogService orderLogService;

    @ApiOperation("李超===>调用该接口获取上传图片所需的七牛云的上传凭证，不要忘记在访问该接口时需要同时将要上传图片的后缀名传过来 例如；.jpg")
    @GetMapping("/getToken")
    public Result getToken(String suffix)
    {
        try {
            //上传凭证
            JSONObject qiniuPolicy = attachmentService.getQiniuPolicy(suffix);

            Attachment attachment = new Attachment(null,null,null,qiniuPolicy.toString());
            Integer attachmentId = attachmentService.insertAttachment(attachment);
            return Result.success(200,"token返回成功",qiniuPolicy,attachmentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail(400,"token返回失败，请重新获取",null);
    }

    @ApiOperation("李超===>获取上传状态接口true:上传成功，false:上传失败，前端调用接口需要给到文件上传状态和调用获取token时返回的id")
    @GetMapping("/getUploadStatus")
    public Result getUploadStatus(Boolean uploadStatus,Integer attachmentId)
    {

           try {
               if(uploadStatus)
               {
                   BigDecimal b = new BigDecimal("100");

                   OrderLog orderLog = new OrderLog("unpaid",b,UUID.randomUUID().toString());
                   Integer orderId = orderLogService.saveOrderLog(orderLog);

                   //生成订单流水号
                   Date currentTime = new Date();
                   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                   String dateString = formatter.format(currentTime);

                   CompareLog compareLog = new CompareLog(dateString,b,orderId,attachmentId,null,LocalDateTime.now());
                   compareLogService.saveCompareLog(compareLog);

                   return Result.success(200,"状态获取成功",null);
               }
               else
               {
                   attachmentService.deleteAttachment(attachmentId);
                   return Result.fail(400,"状态上传失败，请重试！",null);
               }
           }catch (Exception e){
               e.printStackTrace();
               attachmentService.deleteAttachment(attachmentId);
               return Result.fail(400,"状态上传失败，请重试！",null);
           }


    }
}
