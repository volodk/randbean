package org.nicebean.explorer;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class Node {

	private boolean leaf;
	private Field field;
	private Class<?> clazz;
	private List<Node> elements = new LinkedList<>();
	
	public Node(Field field){
		this.field = field;
		clazz = field.getType();
	}
	
	public List<Node> getElements() {
		return elements;
	}
	
	public Field getField() {
		return field;
	}
	
	public Class<?> getClassType() {
		return clazz;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
	public void markAsLeaf(){
		leaf = true;
	}
	
	public void addElement(Node subElement){
		elements.add(subElement);
	}

}