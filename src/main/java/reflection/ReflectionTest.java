package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
 * generics for reflection => some of the types used for reflection are now generic types.
 * reflection for generics => reflection now returns information about generic types.
 * 
 * Class represents information about the type of an object at run time.
 * The method getClass() is defined on every object 
 * and returns a class token that represents the reified type information carried by that object at run-time.
 * 
 * class always represents a reifiable type, 
 * there is no point in parameterizing the class Class with a type that is not reifiable. 
 * Hence, the two main methods for producing a class with a type parameter, 
 * namely the getClass method and class literals, are both designed to yield a reifiable type for the type parameter in all cases.
 * 
 * 
  class ClassLiteral {
	public Class<?> k = List<Integer>.class; // syntax error
  }
 * This syntax problem leads to an irregularity. Everywhere else that a reifiable type is required.
 * You may supply either a raw type (such as List) or a parameterized type with unbounded wildcards (such as List<?>). 
 * However, for class tokens, you must supply a raw type; not even unbounded wildcards may appear.
 * 
 * The only time I need to explicitly work with int.class and Integer.class is to build a generics api 
 * <T> T getValue(String name, Class<T> type); where I need to differentiate if the api is allowed to return null:
 * int value = getValue("key", Integer.class); // will potentially throw NPE
 * int value = getValue("key", int.class); // will never throw NPE
 */
public class ReflectionTest {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflection.ReflectClass");
		System.out.println("class name: " + c.getName());
		System.out.println("class name without package name: " + c.getSimpleName());
		
		Package pkg = c.getPackage();
		System.out.println("\npackage name:" + pkg.getName());
		
		Class superclass = c.getSuperclass();
		System.out.println("\nsuper class: " + superclass.getName());
		
		System.out.println();
		Class[] interfaces = c.getInterfaces();
		for(Class interfac: interfaces) {
			System.out.println("interface: " + interfac.getName());
		}
		
		int modifiers = c.getModifiers();
		System.out.println("\nis class Private:" + Modifier.isPrivate(modifiers));
		System.out.println("is class Public:" + Modifier.isPublic(modifiers));
		
		// --------------------------------Constructors------------------------------------
		// Returns an array containing Constructor objects reflecting all the public constructors of the class represented by this Class object
		
		System.out.println();
		Constructor[] constructors = c.getConstructors();
		for(Constructor con: constructors) {
			System.out.println("constructor: " + con.getParameterCount());
		}
		
		// Constructor constructor = c.getConstructor(new Class[]{String.class});
		Constructor constructor = c.getConstructor(String.class);
		System.out.println("\nconstructor that accepts String: " + constructor.getParameterCount());
		
		System.out.println();
		Class[] parameterTypes = constructor.getParameterTypes();
		for(Class parameterType: parameterTypes) {
			System.out.println("parameterType: " + parameterType.getName());
		}
		
		// Instantiating Objects using Constructor Object
		ReflectClass p = (ReflectClass)constructor.newInstance("constructor-arg1");
		
		Class clas = boolean.class;
		System.out.println("\nclass name: " + clas.getName());
		
		// --------------------------------Fields------------------------------------
		System.out.println();
		Field[] fields = c.getFields();
		for(Field f: fields) {
			System.out.println(f.getName());
		}
		
		Field field = c.getField("publicMsg");
		String fieldName = field.getName();
		System.out.println("\nfieldName: " + fieldName);
		
		Object fieldType = field.getType();
		System.out.println("\nfieldType: " + fieldType.toString());
		
		field.set(p, "Hello Reflection!");
		System.out.println(p.getPublicMsg());
		
		// --------------------------------Methods------------------------------------
		System.out.println();
		Method[] methods = c.getMethods();
		for(Method m: methods) {
			System.out.println(m.getName());
		}
		
		System.out.println();
		// public method which takes String as parameter
		Method method = c.getMethod("setPublicMsg", new Class[]{String.class});
		// Method method = c.getMethod("getPublicMsg", String.class); 
		System.out.println(method.getName());
		
		// method that takes no argument
		Method noArgumentMethod = c.getMethod("printPrivateMsg", null);
		
		System.out.println();
		Class[] pTypes = method.getParameterTypes();
		for(Class parameterType: pTypes) {
			System.out.println("parameterType: " + parameterType.getName());
		}
		
		Class returnType = method.getReturnType();
		
		Object returnValue = method.invoke(p, "parameter-value 1");
		System.out.println(p.getPublicMsg());
		
		System.out.println();
		for(Method m : methods){
		    if(isGetter(m)) System.out.println("getter: " + m);
		    if(isSetter(m)) System.out.println("setter: " + m);
		 }
		
		// --------------------------Private Fields and Methods--------------------------------
		System.out.println();
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
