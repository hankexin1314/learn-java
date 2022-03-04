package com.base.extend.improve;

/**
 * @author kexinhan
 * @date 2022/3/3 15:17
 */
public class Pupil extends Student {


    public Pupil(String name, Integer age) {
        super(name, age);
    }

    public void testing() {
        System.out.println("小学生：" + super.name + "正在考试");
    }
}
