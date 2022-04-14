package com.example.newcompare.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.newcompare.common.utils.FileDownloadUtil;
import com.example.newcompare.common.utils.Result;
import com.example.newcompare.common.utils.ZipUntils;
import com.example.newcompare.entity.File;
import com.example.newcompare.entity.OrderLog;
import com.example.newcompare.mapper.FileMapper;
import com.example.newcompare.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.newcompare.service.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nosgua
 * @since 2022-04-10
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {


    @Autowired
    private OrderLogService orderLogService;
    /**
     *
     * @return   订单表的集合
     */
    @Override
    public List<OrderLog> getAllSendId( Integer[] id) {
        QueryWrapper<OrderLog> q1=new QueryWrapper<>();
       q1.in("id",id);
        return orderLogService.list(q1);
    }


    /**
     *
     * @param list 订单表集合
     * @return 数据结果
     */
    @Override
    public boolean backZip(List<OrderLog> list) throws Exception {


        java.io.File file=new java.io.File("src/main/resources/img");//?
        file.mkdirs();

        for(OrderLog orderLog:list){
            if("finish".equals(orderLog.getStatus())){
                String url = orderLog.getUrl();
                if(url!=null && !"".equals(url)){
                    HttpURLConnection conn = null;
                    InputStream inputStream = null;
                    FileOutputStream e1=null;
                    try{
                        URL url1 = new URL(url);
                          conn = (HttpURLConnection)url1.openConnection();
                           conn.connect();
                        //得到输入流
                         inputStream = conn.getInputStream();

                        e1=new FileOutputStream("src/main/resources/img/"+orderLog.getId()+".png");

                         byte[] bys=new byte[1024];
                         int len;
                         while((len=inputStream.read(bys))!=-1){
                              e1.write(bys,0,len);
                         }
                    }catch (Exception o){
                        o.printStackTrace();
                    }finally{
                        inputStream.close();
                        e1.close();
                        conn.disconnect();
                    }

                }else{
                    return false;
                }

            }
        }

        ZipUntils.getZip("src/main/resources/img");

        return true;

    }
}
