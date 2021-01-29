package com.bwone.pattern.builder;

import lombok.Data;

@Data
class Product {
    private String partA;
    private String partB;
    private String partC;

    void show(){

    }
}

abstract class AbstractBuilder {
    Product product = new Product();

    abstract void buildPartA();
    abstract void buildPartB();
    abstract void buildPartC();

    Product getProduct(){
        return product;
    }
}

public class Builder extends AbstractBuilder {

    @Override
    void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    void buildPartB() {
        product.setPartB("建造 PartB");
    }

    @Override
    void buildPartC() {
        product.setPartC("建造 PartC");
    }
}

class Director {
    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}