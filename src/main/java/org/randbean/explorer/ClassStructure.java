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
public class ClassStructure {

	private boolean leaf;
	private Field field;
	private Class<?> klass;
	private List<ClassStructure> elements = new LinkedList<>();
	
	public ClassStructure(Class<?> klass, Field field){
		this.field = field;
		this.klass = klass;
	}
	
	public ClassStructure(Class<?> klass){
		this(klass, null);
	}
	
	public List<ClassStructure> getElements() {
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
	
	public boolean markAsLeaf(){
		return leaf = true;
	}
	
	public void addElement(ClassStructure subElement){
		elements.add(subElement);
	}
	
	public static ClassStructure from(Class<?> klass, Field field){
	    return new ClassStructure(klass, field);
	}

}