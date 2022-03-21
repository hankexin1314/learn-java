package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kexinhan
 * @date 2022/3/17 18:21
 */
public class Demo1_13 {

    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
//            Student student = new Student();
        }
        Thread.sleep(1000000000L);
    }
}

class Student {
    private byte[] big = new byte[1024 * 1024];
}
