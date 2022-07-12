package com.kangkang.store.JDK8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName:Lambda02
 * Package:com.kangkang.store.JDK8
 * Description:
 *
 * @date:2022/5/20 14:53
 * @author:kangkang
 */
public class Lambda02 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(15,"lisi"));
        list.add(new Person(19,"lisi"));
        list.add(new Person(17,"lisi"));
        list.add(new Person(22,"lisi"));

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Person person: list) {
            System.out.println(person);
        }

        Collections.sort(list,(Person o1,Person o2) -> {
            return o1.getAge() - o2.getAge();
        });





        list.forEach(System.out::println);
    }




}
