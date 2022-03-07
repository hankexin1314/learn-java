package com.base.innerclass;

/**
 * @author kexinhan
 * @date 2022/3/7 16:23
 */
public class MemberInnerClass {

    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        Outer06 outer06 = new Outer06();
        outer06.f1();
    }
}

class Outer05 {
    private int n = 1;
    class Inner05 {
        private int n = 2;
        public void say() {
            System.out.println(n); // 2
            System.out.println(Outer05.this.n); // 1
        }
    }
    public void f1() {
        Inner05 inner05 = new Inner05();
        inner05.say();
    }
}

class Outer06 {
    private static int n = 1;
    static class Inner06 {
        private static int n = 2;
        public static void say() {
            System.out.println(n); // 2
            System.out.println(Outer06.n); // 1
        }
    }
    public void f1() {
        Inner06.say();
    }
}
