package incubator;

import org.nicebean.explorer.Explorer;
import org.nicebean.explorer.Instance;
import org.nicebean.explorer.Node;

public class Main {

	public static void main(String[] args) {
		
		MyBean bean = newObject(MyBean.class);
		
		System.out.println(bean);
		
	}

	static MyBean newObject(Class<MyBean> clazz) {
		
		int max_depth = 3;
		
		Node root = Explorer.buildReferenceGraph(clazz, max_depth);
		
		Object reference = Instance.newObject(root);
		
		return clazz.cast(reference);
	}
	

}
