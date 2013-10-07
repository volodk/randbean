package incubator;

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
		
	
		Test t = (Test) Test.class.newInstance();
		
		
//		Field f = Test.class.getDeclaredField("myset");
//		System.out.println(f.getType());
//		Type type = f.getGenericType();
//		System.out.println(type);
//		if(type instanceof ParameterizedType){
//			ParameterizedType pType = (ParameterizedType)type;
//			
//			for(Type t : pType.getActualTypeArguments()){
//				System.out.println(t);
//			}
//		}
		
		
		
	}

}
