package incubator;

import java.util.Arrays;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;


public class Main {
	
	public static class MyBean {

//		Set<Integer> intSet;
	//	
//		Map<Object, MyBean> map;
	//	
//		byte byteValue;
//		int intValue;
//		float floatValue;
//		
//		private MyBean refBean;
//		private String str;
		
		private int[][] array;

		@Override
		public String toString() {
			return "MyBean [array=" + Arrays.toString(array) + "]";
		}

//		@Override
//		public String toString() {
//			return "MyBean [byteValue=" + byteValue + ", intValue=" + intValue
//					+ ", floatValue=" + floatValue + ", refBean=" + refBean
//					+ ", str=" + str + ", array=" + Arrays.toString(array)
//					+ "]";
//		}
		
		
		
	}

	public static void main(String[] args) {
		
		MyBean bean = newObject(MyBean.class);
		
		System.out.println(bean);
		
	}

	static MyBean newObject(Class<MyBean> clazz) {
		
		int max_depth = 1;
		
		Node root = Explorer.buildReferenceGraph(clazz, max_depth);
		
		Object reference = Instance.newObject(root);
		
		return clazz.cast(reference);
	}
	

}
