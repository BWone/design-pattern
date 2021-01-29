package com.bwone.pattern.factorymethod;

public class FactoryMethod {

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
        Product createProduct();
    }

    static class ProductAFactory implements Factory {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    static class ProductBFactory implements Factory {
        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }
}
