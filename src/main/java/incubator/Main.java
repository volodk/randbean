package incubator;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {
		
		Class<?> clazz = MyBean.class;
		
		printInfo(clazz);

	}

	private static void printInfo(Class<?> clazz) {
		
		for( Field f : clazz.getDeclaredFields() ){
//			System.out.println(f);
			System.out.println(f.toGenericString());
			System.out.println(f.getGenericType());
			System.out.println(f.getType());
			
			System.out.println();
			
		}
		
		
	}

}
