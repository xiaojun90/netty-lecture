package com.joyxj.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: xiaojun
 * @version: 2018/11/30
 */
public class DataInfoTest {

    public static void main(String[] args) throws IOException {

        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(25).setEmail("xxxx@126.com").build();
        //序列化
        byte[] bytes = student.toByteArray();
        System.out.println(bytes.length);
        //反序列化
        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getEmail());


        Student student2 = new Student();
        student2.setName("张三");
        student2.setAge(25);
        student2.setEmail("xxxx@126.com");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(os);
        out.writeObject(student2);
        byte[] stu2Bytes = os.toByteArray();
        System.out.println(stu2Bytes.length);
    }
}
