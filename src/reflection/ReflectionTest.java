package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflection.ReflectClass");
		System.out.println("class name: " + c.getName());
		System.out.println("class name without package name: " + c.getSimpleName());
		
		Package pkg = c.getPackage();
		System.out.println("package name:" + pkg.getName());
		
		Class superclass = c.getSuperclass();
		System.out.println("super class: " + superclass.getName());
		
		Class[] interfaces = c.getInterfaces();
		for(Class interfac: interfaces) {
			System.out.println("interface: " + interfac.getName());
		}
		
		int modifiers = c.getModifiers();
		System.out.println("is class Private:" + Modifier.isPrivate(modifiers));
		System.out.println("is class Public:" + Modifier.isPublic(modifiers));
		
		// --------------------------------Constructors------------------------------------
		
		Constructor[] constructors = c.getConstructors();
		for(Constructor con: constructors) {
			System.out.println("constructor: " + con.getParameterCount());
		}
		
		// Constructor constructor = c.getConstructor(new Class[]{String.class});
		Constructor constructor = c.getConstructor(String.class);
		System.out.println("constructor that accepts String: " + constructor.getParameterCount());
		
		Class[] parameterTypes = constructor.getParameterTypes();
		for(Class parameterType: parameterTypes) {
			System.out.println("parameterType: " + parameterType.getName());
		}
		
		// Instantiating Objects using Constructor Object
		ReflectClass p = (ReflectClass)constructor.newInstance("constructor-arg1");

		ReflectionTest i = new ReflectionTest();
		i.printName(p);
		
		Class clas = boolean.class;
		System.out.println("class name: " + clas.getName());

		Class classs = ReflectionTest.class;
		System.out.println("class name: " + classs.getName());
		
		// --------------------------------Fields------------------------------------
		Field[] fields = c.getFields();
		for(Field f: fields) {
			System.out.println(f.getName());
		}
		
		Field field = c.getField("publicMsg");
		String fieldName = field.getName();
		System.out.println("fieldName: " + fieldName);
		
		Object fieldType = field.getType();
		System.out.println("fieldType: " + fieldType.toString());
		
		field.set(p, "Hello Reflection!");
		System.out.println(p.getPublicMsg());
		
		// --------------------------------Methods------------------------------------
		Method[] methods = c.getMethods();
		for(Method m: methods) {
			System.out.println(m.getName());
		}
		
		// public method which takes String as parameter
		Method method = c.getMethod("setPublicMsg", new Class[]{String.class});
		// Method method = c.getMethod("getPublicMsg", String.class); 
		System.out.println(method.getName());
		
		// method that takes no argument
		Method noArgumentMethod = c.getMethod("printPrivateMsg", null);
		
		Class[] pTypes = method.getParameterTypes();
		for(Class parameterType: pTypes) {
			System.out.println("parameterType: " + parameterType.getName());
		}
		
		Class returnType = method.getReturnType();
		
		Object returnValue = method.invoke(p, "parameter-value 1");
		System.out.println(p.getPublicMsg());
		
		for(Method m : methods){
		    if(isGetter(m)) System.out.println("getter: " + m);
		    if(isSetter(m)) System.out.println("setter: " + m);
		 }
		
		// --------------------------Private Fields and Methods--------------------------------
		Field privateField = c.getDeclaredField("msg");
		
		// turn off the access checks for this particular Field instance, for reflection only
		privateField.setAccessible(true);
		
		String fieldValue = (String) privateField.get(p);
		System.out.println("fieldValue = " + fieldValue);
		
		Method privateStringMethod = ReflectClass.class.getDeclaredMethod("getPrivateMethodValue", null);
		privateStringMethod.setAccessible(true);
		
		String value = (String)privateStringMethod.invoke(p, null);

		System.out.println("returnValue = " + value);
	}

	void printName(Object obj) {
		Class c = obj.getClass();
		System.out.println(c.getName());
	}
	
	public static boolean isGetter(Method method){
	  if(!method.getName().startsWith("get"))      return false;
	  if(method.getParameterTypes().length != 0)   return false;  
	  return true;
	}

	public static boolean isSetter(Method method){
	  if(!method.getName().startsWith("set")) return false;
	  if(method.getParameterTypes().length != 1) return false;
	  return true;
	}

}
