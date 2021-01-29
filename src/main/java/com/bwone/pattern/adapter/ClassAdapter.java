package com.bwone.pattern.adapter;

/**
 * 目标接口
 */
interface Target {
    void request();
}

/**
 * 适配者接口
 */
class Adaptee {

    public void specificRequest(){
        System.out.println("适配者中的业务代码被调用");
    }
}

/**
 * 适配器:让客户按目标接口的格式访问适配者
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        specificRequest();
    }
}