package com.bwone.pattern.composite;

import java.util.ArrayList;
import java.util.List;

class CompositeTest {
    public static void main(String[] args) {
        Component composite1 = new Composite();
        Component composite2 = new Composite();
        Leaf leaf1 = new Leaf("1");
        Leaf leaf2 = new Leaf("2");
        Leaf leaf3 = new Leaf("3");
        composite1.add(leaf1);
        composite1.add(composite2);
        composite2.add(leaf2);
        composite2.add(leaf3);
        composite1.operation();
    }
}

/**
 * 抽象构件
 */
interface Component {
    void add(Component c);
    void remove(Component c);
    void operation();
    Component getChild(int i);
}

/**
 * 树叶构件
 */
class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + "：被访问");
    }

    @Override
    public Component getChild(int i) {
        return null;
    }
}

/**
 * 树枝构件:树枝上可以继续有树枝或树叶,可以用集合保存起来
 */
public class Composite implements Component {

    private List<Component> children = new ArrayList<>();

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void operation() {
        for (Object obj:children){
            ((Component) obj).operation();
        }
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
}
