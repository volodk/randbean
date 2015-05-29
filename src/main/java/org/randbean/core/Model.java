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
public class Model {

    private boolean leaf;
    private Field f;
    private Class<?> clazz;
    private List<Model> elements = new LinkedList<>();

    private Model(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
    }
    
    public Model declaredAt(Field field){
    	this.f = field;
    	return this;
    }

    public List<Model> getElements() {
        return elements;
    }

    public Field getDeclatedAt() {
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

    public void addElement(Model subElement) {
        elements.add(subElement);
    }

    @Override
    public String toString() {
        return "For class : " + clazz.getSimpleName();
    }

    public static Model of(Class<?> klass) {
        return new Model(klass);
    }

}