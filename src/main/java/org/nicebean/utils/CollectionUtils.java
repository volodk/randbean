package org.nicebean.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public class CollectionUtils {

	public static <T> List<T> concreteList(){
		return new ArrayList<T>();
	}
	
	public static <T> Queue<T> concreteQueue(){
		return new LinkedList<T>();
	}
	
	public static <T> Deque<T> concreteDeque(){
		return new LinkedList<T>();
	}
	
	public static <T> Set<T> concreteSet(){
		return new HashSet<T>();
	}
	
	public static <K,V> Map<K,V> concreteMap(){
		return new HashMap<K,V>();
	}
}
