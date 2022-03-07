package com.base.innerclass;

/** 匿名内部类
 * @author kexinhan
 * @date 2022/3/7 15:02
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.m1();
    }
}

class Outer04 {
    private int n1 = 10;
    public void m1() {
        // 1.基于接口的匿名内部类
        // 1.1 lambda函数
        A a1 = () -> {
            System.out.println(n1);
            // class com.base.innerclass.Outer04
            System.out.println(this.getClass());
        };
        // 1.2 不使用lambda
        // a2的编译类型: A, a2的运行类型: 匿名内部类
        // 匿名内部类使用一次后就不可以再使用了
        A a2 = new A() {
            @Override
            public void cry() {
                // 直接访问外部类私有属性
                System.out.println(n1);
                // class com.base.innerclass.Outer04$1
                System.out.println(this.getClass());
            }
        };
        // class com.base.innerclass.Outer04$$Lambda$1/990368553
        System.out.println(a1.getClass());
        // class com.base.innerclass.Outer04$1
        System.out.println(a2.getClass());
        a1.cry();
        a2.cry();

        // 2. 基于类的匿名内部类
        // father的的编译类型: Father, 运行类型: 匿名内部类
        Father father = new Father("hkx") {
            @Override
            public void f1() {
                // 如果不将name定义为public，无法访问
                System.out.println("new " + name);
            }
        };
        // class com.base.innerclass.Outer04$2
        System.out.println(father.getClass());
        // new hkx
        father.f1();
        Father father1 = new Father("wasd");
        // class com.base.innerclass.Father
        System.out.println(father1.getClass());
        father1.f1();
    }
}
interface A {
    public void cry();
}
class Father {
    public String name;
    public Father(String name) {
        this.name = name;
    }
    public void f1() {
        System.out.println(name);
    }
}
