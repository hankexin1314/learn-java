package com.base.extend;

/**
 * @author kexinhan
 * @date 2022/3/3 15:17
 */
public class Pupil {

    public String name;
    public Integer age;
    private Double score;

    public Pupil(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void testing() {
        System.out.println("小学生：" + name + "正在考试");
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
