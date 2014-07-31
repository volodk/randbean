package org.randbean.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class CollectionUtils {
	
	public static java.util.Collection<?> getConcreteCollectionByClass(Class<?> collectionClass){
		
		String str = collectionClass.getName();
		
		if(str.contains("Set"))
			return concreteSet();
		
		if(str.contains("List"))
			return concreteList();
		
		if(str.contains("Queue"))
			return concreteQueue();
		
		if(str.contains("Deque"))
			return concreteDeque();
		
		
		return null;
	}

	private static <T> List<T> concreteList(){
		return new ArrayList<T>();
	}
	
	private static <T> Queue<T> concreteQueue(){
		return new LinkedList<T>();
	}
	
	private static <T> Deque<T> concreteDeque(){
		return new LinkedList<T>();
	}
	
	private static <T> Set<T> concreteSet(){
		return new HashSet<T>();
	}

}
