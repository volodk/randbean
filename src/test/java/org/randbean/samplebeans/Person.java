package org.randbean.samplebeans;

import java.util.Arrays;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:20:34 PM 

public class Person {
    
    private String name;
    private int age;
    private byte[] privateArray;
    private Person bestFriend;

    public Person() {
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

    public byte[] getPrivateArray() {
        return privateArray;
    }

    public void setPrivateArray(byte[] privateArray) {
        this.privateArray = privateArray;
    }

    public Person getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(Person bestFriend) {
        this.bestFriend = bestFriend;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", privateArray=" + Arrays.toString(privateArray)
                + ", bestFriend=" + bestFriend + "]";
    }
    
}