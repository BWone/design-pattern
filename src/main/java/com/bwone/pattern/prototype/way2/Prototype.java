package com.bwone.pattern.prototype.way2;

import java.io.*;

public class Prototype implements Serializable {

    private static final long serialVersionUID = 369285298572941L;
    private Deep deep;

    public Deep serialClone() {
        Deep deep1 = null;
        try {
            //字节数组输出流在内存中创建一个字节数组缓冲区，所有发送到输出流的数据保存在该字节数组缓冲区中。创建字节数组缓冲区  无参数传入时为32字节
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //创建对象输出流
            ObjectOutputStream oo = new ObjectOutputStream(baos);
            //将对象写入内存
            oo.writeObject(this);
            //字节数组输入流在内存中创建一个字节数组缓冲区，所有发送到输入流中的数据保存在该字节数组缓冲区
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            //创建对象输入流
            ObjectInputStream oi = new ObjectInputStream(bais);
            //将对象从内存的输出流中读回对象，完成深克隆 反序列化
            deep1 = (Deep) oi.readObject();
            oi.close();
            oo.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deep1;
    }
}
