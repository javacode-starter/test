package com.shujiu.test.dto;

/**
 * 定义一个类 Person 代表 人
 * <p>
 * 人有2个属性，分别是 name姓名 、age年龄
 * <p>
 * getXX setXX 方法是 Java 的标准，所有属性应该有 get/set 方法
 *
 * @author 交藤
 * @since 2021/10/19
 */
public class Person {

    private String name;
    private int age;

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
}
