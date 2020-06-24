package com.pengwei.demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: pengwei
 * @date: 2020/2/12
 */
public class getFileTxt {
    public static void main(String[] args) {
        getFileContext();
//        getBattery();
    }


    private static void getBattery() {
        String result = "1064778083628=94, 1064778050018=93, 1064787929505=92, 1064778050086=89, 1064778050596=99, 1064778050058=97, 1064792877298=96, 1064778050087=90, 1064792877027=93, 1064778050033=90, 1064778083147=98, 1064868965107=98, 1064778083574=89, 1064792877829=91, 1064888061131=97, 102985939=0";
        String[] deviceData = result.split(",");
        for (int i = 0, size = deviceData.length; i < size; i++) {
            String str = deviceData[i];
            //截取=之后字符串
            String str1 = str.substring(0, str.indexOf("="));
            String str2 = str.substring(str1.length() + 1, str.length());
            System.out.println(str2);
        }


    }

    private static void getFileContext() {
        File file = new File("C:\\Users\\peng\\Desktop\\deviceNum.txt");
        BufferedReader reader = null;
        String temp = null;
        int line = 1;
        List<String> deviceList = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                if (line <= 1000) {
                    deviceList.add(temp);
                } else {
                    break;
                }
                line++;
            }

            System.out.println(StringUtil.joinString(deviceList, ","));
            System.out.println("数量：" + deviceList.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

