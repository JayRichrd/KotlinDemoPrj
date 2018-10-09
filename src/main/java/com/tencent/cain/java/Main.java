package com.tencent.cain.java;

import com.tencent.cain.person.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("姜瑜");
        person.setAge(28);
        System.out.println("person name:" + person.getName() + " age:" + person.getAge());
    }
}
