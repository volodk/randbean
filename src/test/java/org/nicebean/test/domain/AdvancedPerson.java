package org.nicebean.test.domain;

import java.util.Arrays;
import java.util.Set;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:20:34 PM 

public class AdvancedPerson {
    
    private String name;
    private int age;
    private byte[] privateArray;
    private AdvancedPerson bestFriend;
    private AdvancedPerson[] neighbors;
    private Set<AdvancedPerson> children;
    
    public AdvancedPerson() {
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

    public AdvancedPerson getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(AdvancedPerson bestFriend) {
        this.bestFriend = bestFriend;
    }
    
    public AdvancedPerson[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(AdvancedPerson[] neighbors) {
        this.neighbors = neighbors;
    }

    public Set<AdvancedPerson> getChildren() {
        return children;
    }

    public void setChildren(Set<AdvancedPerson> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "AdvancedPerson [name=" + name + ", age=" + age + ", privateArray=" + Arrays.toString(privateArray)
                + ", bestFriend=" + bestFriend + ", neighbors=" + Arrays.toString(neighbors) + ", children=" + children
                + "]";
    }
    
}