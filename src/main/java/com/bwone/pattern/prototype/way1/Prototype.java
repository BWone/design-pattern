package com.bwone.pattern.prototype.way1;

import lombok.Data;

import java.io.*;
import java.util.Objects;

@Data
public class Prototype implements Cloneable, Serializable {

    private Deep deep;

    @Override
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(prototype).setDeep((Deep) deep.clone());
        return prototype;
    }

}
