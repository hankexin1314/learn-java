package com.base.extend.improve;

/**
 * @author kexinhan
 * @date 2022/3/3 15:29
 */
public class Student {
    public String name;
    public Integer age;
    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
