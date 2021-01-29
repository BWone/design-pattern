package com.bwone.pattern.multiton;

import java.util.HashMap;
import java.util.Map;

public class Multiton {

    private static Map<Integer, Multiton> map = new HashMap<>();
    private static final int COUNT = 2;
    private static int num = 1;

    private Multiton() {
    }

    public static Multiton getInstance(){
        Multiton stu = map.get(num);
        if (stu == null){
            stu = new Multiton();
            map.put(num, stu);
        }
        num ++;
        if (num > COUNT){
            num = 1;
        }
        return stu;
    }

    public static void main(String[] args) {
        Multiton instance1 = Multiton.getInstance();
        Multiton instance2 = Multiton.getInstance();
        Multiton instance3 = Multiton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
    }
}


