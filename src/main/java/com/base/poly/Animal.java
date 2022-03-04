package com.base.poly;

/**
 * @author kexinhan
 * @date 2022/3/3 18:33
 */
public class Animal {
    int age = 10;
    static int num = 20;

    public void eat() {
        System.out.println("animal eat");
    }

    public static void run() {
        System.out.println("animal run");
    }
}

class Cat extends Animal {
    int age = 80;
    static int num = 90;

    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    public static void run() {
        System.out.println("cat run");
    }

    public void sleep() {
        System.out.println("cat sleep");
    }

    public static void main(String[] args) {
        // 编译类型Animal 运行类型Cat
        Animal cat = new Cat();
        cat.eat(); // cat eat
        cat.run(); // animal run
        // cat.sleep(); 无法调用
        System.out.println(cat.age); // 10
        System.out.println(cat.num); // 20
    }
}

