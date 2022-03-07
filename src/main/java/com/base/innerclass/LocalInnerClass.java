package com.base.innerclass;

/** 局部内部类
 * @author kexinhan
 * @date 2022/3/7 14:40
 */
public class LocalInnerClass {

    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        // com.base.innerclass.Outer02@1b6d3586，与局部内部类中的输出一致
        System.out.println(outer02);
    }
}

class Outer02 { // 外部类
    private int n = 1;

    private void m2() {
        System.out.println("m2");
    }

    public void m1() {
        /**
         * 1.不能添加访问修饰符，例如public
         * 2.可以使用final修饰，使用后不能被继承
         * 3.作用域仅仅在定义它的方法或者代码块内
         */
        class Inner02 { // 局部内部类，可以写在方法中，也可以写在代码块中
            // 重名变量，就近原则
            private int n = 2;
            public void f1() {
                // 直接访问外部类的所有成员，包括私有的
                System.out.println("n=" + n); // 输出n=2
                m2();
                // 访问外部成员, Outer02.this是外部类对象，指向调用m1()的对象
                System.out.println("n=" + Outer02.this.n); // 输出n=1
                // com.base.innerclass.Outer02@1b6d3586，与main中输出一致
                System.out.println(Outer02.this);
            }
        }
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}
