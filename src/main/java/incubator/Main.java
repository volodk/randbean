package incubator;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

class Node{
	
	boolean leaf;
	
	String fieldName;
	Class<?> clazz;
	List<Node> elements = new LinkedList<>();
	
	Node(Class<?> clazz, String fieldName){
		this.fieldName = fieldName;
		this.clazz = clazz;
	}
	
	Node(Class<?> clazz){
		this(clazz, null);
	}
	
	public List<Node> getElements() {
		return elements;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		
		MyBean bean = newObject(MyBean.class);
		
		System.out.println(bean);
		
	}

	static MyBean newObject(Class<MyBean> clazz) {
		
		Node root = buildReferenceGraph(clazz);
		
		Object reference = createObject(root);
		
		return clazz.cast(reference);
	}

	static Node buildReferenceGraph(Class<?> rootClazz) {
		
		int max_depth = 3;
		
		return buildReferenceGraph(rootClazz, (String)null, 0, max_depth);
	}
	
	static Node buildReferenceGraph(Class<?> clazz, String fieldName, int depth, int max_depth) {
		if ( depth <= max_depth ) {
			Node node = new Node(clazz, fieldName);
			if( JdkClassRegistry.isJdkClass(clazz) ){
				node.leaf = true;
			} else{
				for (Field f : clazz.getDeclaredFields()) {	
					Node child = buildReferenceGraph(f.getType(), f.getName(), depth + 1, max_depth);
					if( child != null )
						node.elements.add(child);
					else {
						node.leaf = true;
						break;
					}
				}
			}
			return node;
		}
		return null;
	}

	static Object createObject(Node node) {
		if ( node != null ){
			if( node.isLeaf() ){
				RandomizedValue rv = RandomizedValueFactory.resolve(node.clazz);
				return rv.get();
			} else { 
				try{
					Object localRoot = node.clazz.newInstance();
					for( Node element : node.elements ){
					
						Object value = createObject(element);
						setValue(localRoot, node.clazz, element.fieldName, value);
					}
					return localRoot;
				} catch ( InstantiationException | IllegalAccessException e ){
					System.err.println("Cannot create object instance, reason : " + e.getMessage());
				}
			}
		}
		return null;
	}

	private static void setValue(Object rootObj, Class<?> clazz, String fieldName,
			Object obj) throws IllegalAccessException {
		try {
			Field f = clazz.getDeclaredField(fieldName);
			if( f.isAccessible() ){
				f.set(rootObj, obj);
			} else {
				f.setAccessible(true);
				f.set(rootObj, obj);
				f.setAccessible(false);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			System.err.println("Cannot set a value, more : " + e.getMessage() );
		}
	}

}
