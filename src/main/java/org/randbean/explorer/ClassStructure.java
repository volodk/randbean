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
	private Class<?> clazz;
	private List<ClassStructure> elements = new LinkedList<>();
	
	public ClassStructure(Class<?> clazz, Field field){
		this.field = field;
		this.clazz = clazz;
	}
	
	public ClassStructure(Class<?> clazz){
		this(clazz, null);
	}
	
	public List<ClassStructure> getElements() {
		return elements;
	}
	
	public Field getField() {
		return field;
	}
	
	public Class<?> getClassType() {
		return clazz;
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

}