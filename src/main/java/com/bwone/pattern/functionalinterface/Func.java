package com.bwone.pattern.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface MyFunc{
    String getValue(String t);
}


public class Func {
    public static void main(String[] args) {
        Func func = new Func();
        func.test();
        func.test1();
        func.test3();
        func.test4();
        String trim = custom("你是大傻逼       ", s -> s.trim());
        System.out.println(trim);
    }

    public void test(){
        consumer(100, m -> System.out.println("消费了：" + m + "块钱"));
    }
    public void consumer(double money, Consumer<Double> con){
        con.accept(money);
    }


    public void test1(){
        List<Integer> num = supplier(5, () -> (int)(Math.random()*100));
        System.out.println(num);
    }
    public List<Integer> supplier(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < num;i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }


    public void test3(){
        String trimStr = function("  去首尾空格  ", str -> str.trim());
        System.out.println(trimStr);
    }
    public String function(String str, Function<String,String> fun){
        return fun.apply(str);
    }


    public void test4(){
        Boolean conStr = predicate("程序员", p -> p.contains("程序员"), p -> p.length() < 1);
        System.out.println(conStr);
    }
    public Boolean predicate(String str, Predicate<String> pre1, Predicate<String> pre2){
        return pre1.and(pre2).test(str);
    }

    public static String custom(String str, MyFunc func){
        return func.getValue(str);
    }

}
