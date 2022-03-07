package com.base.innerclass;

/**
 * @author kexinhan
 * @date 2022/3/7 14:35
 */
public class InnerClass01 {

}

class Outer {
    private int n = 10;

    public Outer(int n) {
        this.n = n;
    }

    public void f() {
        System.out.println("Outer:" + n);
    }
}
