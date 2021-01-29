package com.bwone.pattern.prototype.way1;

import lombok.Data;

@Data
public class Deep implements Cloneable {

    @Override
    public Object clone() {
        Deep deep = null;
        try {
            deep = (Deep) super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return deep;
    }

}
