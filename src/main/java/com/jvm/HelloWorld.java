package com.jvm;

/**
 * @author kexinhan
 * @date 2022/3/21 16:44
 */
public class HelloWorld {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s1 + s2 == s3);
        System.out.println((s1 + s2).equals(s3));
    }
}
