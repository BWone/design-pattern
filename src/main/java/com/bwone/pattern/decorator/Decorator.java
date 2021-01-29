package com.bwone.pattern.decorator;

/**
 * 抽象构件角色
 */
interface Component {
    void operation();
}

/**
 * 具体构件角色
 */
class ConcreteComponent implements Component {

    public ConcreteComponent(){
        System.out.println("创建具体构件角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构建角色的方法");
    }
}

/**
 * 抽象装饰角色:组装构件角色
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

/**
 * 具体装饰角色:装饰构件
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunction();
    }

    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能");
    }

}