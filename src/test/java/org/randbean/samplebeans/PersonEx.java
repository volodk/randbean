package org.randbean.samplebeans;

import java.util.Arrays;
import java.util.Set;


// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 1:20:34 PM 

public class PersonEx {
    
    enum Sex {
        MALE, FEMALE
    }
    
    private String name;
    private int age;
    private Sex sex;
    private PersonEx bestFriend;
    private PersonEx[] neighbors;
    private Set<PersonEx> children;
    
    public PersonEx() {
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

    public Sex getSex() {
        return sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public PersonEx getBestFriend() {
        return bestFriend;
    }

    public void setBestFriend(PersonEx bestFriend) {
        this.bestFriend = bestFriend;
    }
    
    public PersonEx[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(PersonEx[] neighbors) {
        this.neighbors = neighbors;
    }

    public Set<PersonEx> getChildren() {
        return children;
    }

    public void setChildren(Set<PersonEx> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "AdvancedPerson [name=" + name + ", age=" + age + ", sex=" + sex
                + ", bestFriend=" + bestFriend + ", neighbors=" + Arrays.toString(neighbors) + ", children=" + children
                + "]";
    }
    
}