package com.example.compare.common.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class FileDownloadUtil {
    private static String path = "http://139.9.203.100:9721/cadpare/download?workcode=";
    private static String dir = "D:\\save\\";

    public static String getZip(String workcode) throws IOException {

        URL url = new URL(path+workcode);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        final UUID uuid = UUID.randomUUID();

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        byte[] b= readInputStream(inputStream);
        String savePath = dir+uuid+".zip";
        File save = new File(savePath);
        FileOutputStream outputStream = new FileOutputStream(save);
        outputStream.write(b);
        return savePath;
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

}
