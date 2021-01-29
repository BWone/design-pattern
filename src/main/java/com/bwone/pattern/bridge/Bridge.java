package com.bwone.pattern.bridge;

public class Bridge {

    /**
     * 实现化角色
     */
    interface Implementor {
        void opterationImpl();
    }

    /**
     * 具体实现化角色
     */
    static class ConcreteImplementorA implements Implementor {

        @Override
        public void opterationImpl() {
            System.out.println("具体实现化A");
        }
    }

    /**
     * 抽象化角色
     */
    abstract static class Abstraction {
        protected Implementor implementor;

        protected Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void opteration();
    }

    /**
     * 扩展抽象化角色(该角色可以有多个,所以为了避免代码重复,会在抽象类中完成对实现化对象的引用)
     */
    static class RefinedAbstraction extends Abstraction {
        protected RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void opteration() {
            implementor.opterationImpl();
        }
    }
}
