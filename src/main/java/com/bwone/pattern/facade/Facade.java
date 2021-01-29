package com.bwone.pattern.facade;

public class Facade {

    private SubSystem1 sub1 = new SubSystem1();
    private SubSystem2 sub2 = new SubSystem2();
    private SubSystem3 sub3 = new SubSystem3();

    public void method() {
        sub1.method1();
        sub2.method2();
        sub3.method3();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("子系统1的method1被调用");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("子系统2的method2被调用");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("子系统3的method3被调用");
    }
}