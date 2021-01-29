package com.bwone.pattern.proxy;

class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("访问真实主题方法");
    }
}

public class Proxy implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        beforeRequest();
        realSubject.request();
        afterRequest();
    }

    public void beforeRequest(){
        System.out.println("访问真实主题预处理");
    }

    public void afterRequest(){
        System.out.println("访问真实主题之后的后续处理");
    }
}