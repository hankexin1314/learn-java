package com.base.extend.improve;

/**
 * @author kexinhan
 * @date 2022/3/3 15:21
 */
public class Graduate extends Student{

    public Graduate(String name, Integer age) {
        super(name, age);
    }

    public void testing() {
        System.out.println("大学生：" + super.name + "正在考试");
    }

}
