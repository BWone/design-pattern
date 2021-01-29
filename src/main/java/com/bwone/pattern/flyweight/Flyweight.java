package com.bwone.pattern.flyweight;

import java.util.HashMap;

class FlyweightTest {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        AbstractFlyweight a1 = factory.getFlyweight("a");
        AbstractFlyweight a2 = factory.getFlyweight("a");
        AbstractFlyweight a3 = factory.getFlyweight("a");
        AbstractFlyweight b1 = factory.getFlyweight("b");
        AbstractFlyweight b2 = factory.getFlyweight("b");
        a1.operation(new UnFlyweight("第1次调用a"));
        a2.operation(new UnFlyweight("第2次调用a"));
        a3.operation(new UnFlyweight("第3次调用a"));
        b1.operation(new UnFlyweight("第1次调用b"));
        b2.operation(new UnFlyweight("第2次调用b"));
    }
}

/**
 * 非享元角色:不可以共享的外部状态,以参数形式注入相关方法
 */
class UnFlyweight {
    private String info;

    public UnFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

/**
 * 抽象享元角色
 */
interface AbstractFlyweight {
    void operation(UnFlyweight state);
}

/**
 * 具体享元角色
 */
public class Flyweight implements AbstractFlyweight {
    private String key;

    public Flyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建");
    }

    @Override
    public void operation(UnFlyweight outState){
        System.out.print("具体享元" + key + "被调用");
        System.out.println("非享元信息是：" + outState.getInfo());
    }
}

/**
 * 享元工厂角色
 */
class FlyweightFactory {
    private HashMap<String, AbstractFlyweight> flyweights = new HashMap<>();

    public AbstractFlyweight getFlyweight(String key){
        AbstractFlyweight flyweight = flyweights.get(key);
        if (flyweight != null){
            System.out.println("具体享元" + key + "已经存在，被成功获取");
        } else {
            flyweight = new Flyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}