package reflection;

import java.lang.reflect.Method;

public class ReflectClassTest {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflection.PrivateMethod");  
	    Object o = c.newInstance();
	    Method m = c.getDeclaredMethod("message", null);  
	    m.setAccessible(true);  
	    m.invoke(o, null);  
	}

}
