package incubator;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class Test {
	
	Map<String, Test> mymap;
	
	Set<Integer> myset;
	
	Map<?,?> mymap2;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		
	
		Collection<?>[][][][][][][][] a = {};
		
		System.out.println(a instanceof Object[] );
		
		
		Field f = Test.class.getDeclaredField("myset");
		System.out.println(f.getType());
		Type type = f.getGenericType();
		System.out.println(type);
		if(type instanceof ParameterizedType){
			ParameterizedType pType = (ParameterizedType)type;
			
			for( Type t : pType.getActualTypeArguments() ){
				System.out.println(t);
			}
		}
		
		
		
	}

}
