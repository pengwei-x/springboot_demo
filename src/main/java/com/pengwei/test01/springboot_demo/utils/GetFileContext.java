package com.pengwei.test01.springboot_demo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: pengwei
 * @date: 2020/2/12
 */
public class GetFileContext {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\peng\\Desktop\\deviceNum.txt");
        BufferedReader reader = null;
        String temp = null;
        int line = 1;
        List<String> deviceList = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                if (line < 20) {
                    System.out.println("第" + line + "行:" + temp);
                    deviceList.add(temp);

                } else {
                    break;
                }
                line++;
            }
            System.out.println(StringUtil.joinString(deviceList, ","));
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
