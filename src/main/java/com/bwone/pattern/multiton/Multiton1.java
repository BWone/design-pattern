package com.bwone.pattern.multiton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Multiton1 {

    private static final int MAX_COUNT = 2;
    private static final Multiton1 MULTITON_1 = new Multiton1();
    private static final Multiton1 MULTITON_2 = new Multiton1();
    private static List<Multiton1> list = new ArrayList<>();

    static {
        list.add(MULTITON_1);
        list.add(MULTITON_2);
    }

    private Multiton1() {
    }

    /**
     * 随机获取实例
     */
    public static Multiton1 getInstance() {
        Random random = new Random();
        int current = random.nextInt(MAX_COUNT);
        return list.get(current);
    }

    /**
     * 工厂方式获取实例
     */
    public static Multiton1 getInstance2(int num) {
        switch (num) {
            case 1:
                return MULTITON_1;
            case 2:
                return MULTITON_2;
            default:
                return null;
        }
    }

    /**
     * 指定索引获取实例
     */
    public static Multiton1 getInstance3(int index) {
        return list.get(index);
    }

}
