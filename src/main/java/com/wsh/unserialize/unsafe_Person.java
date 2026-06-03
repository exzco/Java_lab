package com.wsh.unserialize;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class unsafe_Person implements Serializable,Comparable {
    public String name;
    private int age;
    private String address;

    public unsafe_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int hashCode() {
//        try {
//            Runtime.getRuntime().exec("open -a Calculator");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return Objects.hash(this.name, this.age);
//    }

//    @Override
//    public String toString() {
//        try {
//            Runtime.getRuntime().exec("open -a Calculator");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "aaa";
//    }
//    public String getAddress() {
//        return address;
//    }

    @Override
    public int compareTo(Object o) {
        try {
            Runtime.getRuntime().exec("open -a Calculator");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
