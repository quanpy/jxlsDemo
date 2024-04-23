package org.example.jxlstest;

/**
 * @author Ocean
 * @date 2024/4/23 10:42
 * @description Student
 */

import java.util.Date;

/**
 * @author: wuhao
 * @since: 2021/5/20 15:34
 */
public class Student {

    private String name;
    private String password;
    private String sex;
    private int age;
    private Date birthday;

    public Student() {

    }
    public Student(String name, String password, String sex, int age, Date birthday) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}