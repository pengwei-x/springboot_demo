package com.peng.spring.entiy;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author pengwei
 * @date 2020/6/11
 */
/*@Component*/
public class Person implements Serializable {
    private static final long serialVersionUID = -4850170693260859666L;

    private long id;
    private String name;
    private int age;
    private int sex;
    private String address;

    public Person(){
        System.out.println("无参构造");
    }

    public Person(long id, String name, int age, int sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        System.out.println("有参构造");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
