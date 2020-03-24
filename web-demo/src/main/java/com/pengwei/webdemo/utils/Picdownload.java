package com.pengwei.webdemo.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author: pengwei
 * @date: 2020/1/8
 */
public class Picdownload {
    /**
     * @Title: downloadPicture
     * @Description: 下载图片
     * @param   picurls 多个图片地址     path 图片下载存放目录  fileNames 多个文件名称 数量与图片地址数量保持一致
     * @return void
     * @throws
     */
    public static void downloadPicture(String[] picurls,String path,String[] fileNames) throws IOException {
        try {
            //多个图片下载地址
            for(int i=0;i<picurls.length;i++) {
                //根据图片地址构建URL
                URL url= new URL(picurls[i]);
                URLConnection conn = url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(10000);
                conn.connect();
                DataInputStream dataInputStream = new DataInputStream(conn.getInputStream());
                //创建目录和图片
                File pathFile=new File(path);
                File file=new File(path+File.separator+fileNames[i]);
                if(!pathFile.exists()) {
                    pathFile.mkdirs();
                    file.createNewFile();
                }
                if(!file.exists()) {
                    file.createNewFile();
                }
                //通过流复制图片
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dataInputStream.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                fileOutputStream.write(output.toByteArray());
                dataInputStream.close();
                fileOutputStream.close();
        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}