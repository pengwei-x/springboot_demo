package com.pengwei.webdemo.utils;

/**
 * @author: pengwei
 * @date: 2020/1/8
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class PictureUtil {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        download("http://testfk3.chexiao.co/fileupload/2020-01-08/e4c5d12dfb214ab78160b306f5496684.jpg", "e4c5d12dfb214ab78160b306f5496684.jpg","d:\\image\\");
    }

    public static void download(String urlString, String filename,String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        // 获取图片的扩展名
        String extensionName = filename.substring(filename.lastIndexOf(".") +1);
        // 新的图片文件名 = 编号 +"."图片扩展名
        String newFileName = "111" +"." + extensionName;
//        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+newFileName);
        OutputStream os = new FileOutputStream(newFileName);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

}
