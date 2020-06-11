package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengwei
 * @date 2020/5/13
 */
public class HashMapTest {

    void  add(){
        System.out.println(111);
    }


    public static void main(String[] args) {
        // 获取当前系统编码
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));


        HashMapTest hashMapTest = new HashMapTest() {

        };

        new HashMapTest();
        try {
            Class<?> aClass = Class.forName("test.HashMapTest");
            HashMapTest o = (HashMapTest) aClass.newInstance();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<Integer,String> hashMap = new HashMap();
        hashMap.put(1,"hello");
        hashMap.put(2,"world");

    }
}
