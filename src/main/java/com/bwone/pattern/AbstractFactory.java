package com.bwone.pattern;

public class AbstractFactory {

    public interface Product {
        void show();
    }

    static class ProductA implements Product {
        @Override
        public void show() {
            System.out.println("创建产品A");
        }
    }

    static class ProductB implements Product {
        @Override
        public void show() {
            System.out.println("创建产品B");
        }
    }

    public interface Factory {
        ProductA createProductA();
        ProductB createProductB();
    }

    static class ProductFactory implements Factory {
        @Override
        public ProductA createProductA() {
            return new ProductA();
        }

        @Override
        public ProductB createProductB() {
            return new ProductB();
        }
    }
}
