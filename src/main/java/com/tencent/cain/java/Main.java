package com.tencent.cain.java;

import com.tencent.cain.ArgsUtil;
import com.tencent.cain.Rectangle;
import com.tencent.cain.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("姜瑜");
        person.setAge(28);
        System.out.println("person name:" + person.getName() + " age:" + person.getAge());
        Rectangle rectangle = new Rectangle(23,23);
        System.out.println("is square: " + rectangle.isSquare());
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArgsUtil argsUtil = new ArgsUtil();
        System.out.println("输出结果：" + argsUtil.joinToString(list,"#"));
    }
}
