package com.example.demo.pojo.DO;

import com.opencsv.bean.CsvBindByName;

/**
 * 测试cvs的类
 */
public class Person {

    @CsvBindByName(column = "名字", required = true)
    private String name;

    @CsvBindByName(column = "年龄", required = true)
    private Integer age;

    @CsvBindByName(column = "性别", required = true)
    private Integer sex;

    public Person() {

    }

    public Person(String name, Integer age, Integer sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
