package org.randbean.explorer;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class ClassNode {

	private boolean leaf;
	private Field field;
	private Class<?> klass;
	private List<ClassNode> elements = new LinkedList<>();
	
	public ClassNode(Class<?> klass, Field field){
		this.field = field;
		this.klass = klass;
	}
	
	public ClassNode(Class<?> klass){
		this(klass, null);
	}
	
	public List<ClassNode> getElements() {
		return elements;
	}
	
	public Field getField() {
		return field;
	}
	
	public Class<?> getClassType() {
		return klass;
	}
	
	public Type getGenericType(){
		if( field != null )
			return field.getGenericType();
		else
			return null;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
	public void markAsLeaf(){
		leaf = true;
	}
	
	public void addElement(ClassNode subElement){
		elements.add(subElement);
	}
	
	public static ClassNode from(Class<?> klass, Field field){
	    return new ClassNode(klass, field);
	}
	
	public static ClassNode from(Field field){
        return new ClassNode(field.getType(), field);
    }

}