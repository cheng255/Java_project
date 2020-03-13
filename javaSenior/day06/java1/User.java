package com.atguigu.java1;

import java.util.Objects;

/**
 * @author nuonuo
 * @create 2020-03-13 14:25
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            if (this.getAge() > user.getAge()) {
                return 1;
            } else if (this.getAge() < user.getAge()) {
                return -1;
            } else {
                return this.getName().compareTo(((User) o).getName());
            }
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
