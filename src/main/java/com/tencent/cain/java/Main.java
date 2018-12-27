package com.tencent.cain.java;

import com.tencent.cain.ArgsUtil;
import com.tencent.cain.Rectangle;
import com.tencent.cain.person.Employeer;
import com.tencent.cain.person.Person;
import com.tencent.cain.user.IJsonFactory;
import com.tencent.cain.user.ObjectPerson;
import com.tencent.cain.user.ObjectUser;
import com.tencent.cain.util.Payroll;
import com.tencent.cain.util.Utils;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.tencent.cain.main.MainEntranceKt.processTheAnswer;

public class Main {
    private static  AtomicInteger mMaxQueueSize;
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("姜瑜");
        person.setAge(28);
        System.out.println("person name:" + person.getName() + " age:" + person.getAge());
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArgsUtil argsUtil = new ArgsUtil();
        System.out.println("输出结果：" + argsUtil.joinToString(list, "#"));
        System.out.println("输出结果：" + Utils.joinToString(list));
        // 使用Kotlin定义的扩展函数
        System.out.println("Kotlin 的最后一个字符: " + Utils.lastChar("Kotlin", "Kotlin".length()));
        System.out.println("扩展方法：" + Utils.join2Str(list, ";", "[", "]"));
        // 扩展属性
        StringBuilder sb = new StringBuilder("Kotlin");
        System.out.println("扩展属性，" + Utils.getLastChar(sb));
        Utils.setLastChar(sb, '?');
        System.out.println("扩展属性，" + Utils.getLastChar(sb));

        System.out.println();
        Employeer wife = new Employeer("Wife", 7800);
        Employeer son = new Employeer("Son", 100);
        Employeer husband = new Employeer("Husband", 13000);
        Payroll.INSTANCE.getAllEmployees().add(wife);
        Payroll.INSTANCE.getAllEmployees().add(husband);
        Payroll.INSTANCE.calculateSalary();
        System.out.println("family income will be: " + Payroll.INSTANCE.getAllSalaries());

        System.out.println();
        List<Employeer> employeers = new ArrayList<>();
        employeers.add(husband);
        employeers.add(son);
        employeers.add(wife);
        employeers.sort(Employeer.EmployeerComparator.INSTANCE);
        System.out.println("the sequence: " + employeers);

        System.out.println();
        ObjectUser user1 = ObjectUser.Companion.newSubscribingUser("2645774548@qq.com");
        System.out.println("user nickname: " + user1.getNickName());

        System.out.println();
        ObjectPerson objectPerson = loadFromJson(ObjectPerson::new);
        System.out.println("objectPerson: " + objectPerson.getName());

        System.out.println();
        System.out.println("伴生对象扩展测试，名字：" + Utils.transformJson(ObjectPerson.Companion, "姜维").getName());

        Class3 class3 = new Class3();
        System.out.println("获取到父类的属性值：" + class3.getAge());

        System.out.println();
        processTheAnswer(number -> number + 1);
        processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {
                System.out.println("输入： " + integer);
                return integer + 1;
            }
        });

        System.out.println();
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        CollectionsKt.forEach(strings, str -> {
            System.out.println(str);
            return Unit.INSTANCE;
        });
        mMaxQueueSize = new AtomicInteger(0);
        int previous = mMaxQueueSize.get();
        System.out.println("当前的值：" + previous);
        if (mMaxQueueSize.compareAndSet(previous,previous)){
            System.out.println("设置成功,当前的值：" + mMaxQueueSize.get());
        }


    }

    private static <T> T loadFromJson(IJsonFactory<T> factory) {
        return factory.fromJson("CainJiang");
    }

}
