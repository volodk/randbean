package org.randbean.core;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 * 
 */
public class ClassNode {

    private boolean leaf;
    private Field f;
    private Class<?> clazz;
    private List<ClassNode> elements = new LinkedList<>();

    public ClassNode(Class<?> clazz, Field field) {
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
        this.f = field;
    }

    public List<ClassNode> getElements() {
        return elements;
    }

    public Field getField() {
        return f;
    }

    public Class<?> getClassType() {
        return clazz;
    }

    public Type getGenericType() {
        return f != null ? f.getGenericType() : null;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void markAsLeaf() {
        leaf = true;
    }

    public void addElement(ClassNode subElement) {
        elements.add(subElement);
    }

    @Override
    public String toString() {
        return "For class : " + clazz.getSimpleName();
    }

    public static ClassNode from(Class<?> klass, Field field) {
        return new ClassNode(klass, field);
    }

}