package com.base.extend;

/**
 * @author kexinhan
 * @date 2022/3/3 15:21
 */
public class Graduate {

    public String name;
    public Integer age;
    private Double score;

    public Graduate(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("大学生：" + name + "正在考试");
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
