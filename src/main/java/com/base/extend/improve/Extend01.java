package com.base.extend.improve;

/**
 * @author kexinhan
 * @date 2022/3/3 15:17
 */
public class Extend01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("小明", 12);
        Graduate graduate = new Graduate("大明", 22);
        pupil.testing();
        graduate.testing();
    }
}
