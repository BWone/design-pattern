package com.bwone.pattern.simpleFactory;

public class SimpleFactory {

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

    /**
     * 代表哪种产品的常量类
     */
    static final class ProductConst {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
    }

    static class Factory {
        public static Product makeProduct(int kind){
            switch (kind){
                case ProductConst.PRODUCT_A:
                    return new ProductA();
                case ProductConst.PRODUCT_B:
                    return new ProductB();
                default:
                    break;
            }
            return null;
        }
    }

}
