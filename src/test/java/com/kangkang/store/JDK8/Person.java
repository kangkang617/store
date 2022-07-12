package com.kangkang.store.JDK8;

/**
 * ClassName:Person
 * Package:com.kangkang.store.JDK8
 * Description:
 *
 * @date:2022/5/20 14:53
 * @author:kangkang
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
