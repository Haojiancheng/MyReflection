package com.taigu.my;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class ReflictionCat {
    String name;
    int age;

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

    @Override
    public String toString() {
        return "ReflictionCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ReflictionCat() {
        super();
    }

}
