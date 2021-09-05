package reflection;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;

/*
 * The reflection library provides a Type interface to describe a generic type:
 * https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html
 * 
 * There is one class that implements this interface and four other interfaces that extend it:
 * 1. The class Class, representing a primitive type or raw type.
 * 2. The interface ParameterizedType, representing an application of a generic class or interface to parameter types, 
 * from which you can extract an array of the parameter types.
 * 3. The interface TypeVariable, representing a type variable, from which you can extract the bounds on the type variable.
 * 4. The interface GenericArrayType, representing an array, from which you can extract the array component type.
 * 5. The interface WildcardType, representing a wildcard, from which you can extract a lower or upper bound on the wildcard.
 * 
 * By performing a series of instance tests on each of these interfaces, 
 * you may determine which kind of type you have, and print or process the type.
 * 
 * Methods are available to return the superclass and superinterfaces of a class as types, 
 * and to access the generic type of a field, 
 * the argument types of a constructor, 
 * and the argument and result types of a method.
 */
class ReflectionDemo {
    private final static PrintStream out = System.out;
    
    public static void printSuperclass (Type sup) {
		if (sup != null && !sup.equals(Object.class)) {
		    out.print("extends ");
		    printType(sup);
		}
    }
    
    public static void printInterfaces (Type[] impls) {
		if (impls != null && impls.length > 0) {
		    out.print("implements ");
		    int i = 0;
		    for (Type impl : impls) {
				if (i++ > 0) out.print(",");
				printType(impl);
		    }
		    out.println();
		}
    }
    
    public static void printTypeParameters (TypeVariable<?>[] vars) {
		if (vars != null && vars.length > 0) {
		    out.print("<");
		    int i = 0;
		    for (TypeVariable<?> var : vars) {
				if (i++ > 0) out.print(",");
				out.print(var.getName());
				printBounds(var.getBounds());
		    }
		    out.print(">");
		}
    }
    
    public static void printBounds (Type[] bounds) {
		if (bounds != null && bounds.length > 0
		    && !(bounds.length==1 && bounds[0]==Object.class)) {
		    out.print(" extends ");
		    int i = 0;
		    for (Type bound : bounds) {
				if (i++ > 0) out.print("&");
				printType(bound);
		    }
		}
    }
    
    public static void printParams (Type[] types) {
		if (types != null && types.length > 0) {
		    out.print("<");
		    int i = 0;
		    for (Type type : types) {
				if (i++ > 0) out.print(",");
				printType(type);
		    }
		    out.print(">");
		}
    }
    
    public static void printType (Type type) {
		if (type instanceof Class) {
		    Class<?> c = (Class)type;
		    out.print(c.getName());
		} else if (type instanceof ParameterizedType) {
		    ParameterizedType p = (ParameterizedType)type;
		    Class c = (Class)p.getRawType();
		    Type o = p.getOwnerType();
		    if (o != null) { printType(o); out.print("."); }
		    out.print(c.getName());
		    printParams(p.getActualTypeArguments());
		} else if (type instanceof TypeVariable<?>) {
		    TypeVariable<?> v = (TypeVariable<?>)type;
		    out.print(v.getName());
		} else if (type instanceof GenericArrayType) {
		    GenericArrayType a = (GenericArrayType)type;
		    printType(a.getGenericComponentType());
		    out.print("[]");
		} else if (type instanceof WildcardType) {
		    WildcardType w = (WildcardType)type;
		    Type[] upper = w.getUpperBounds();
		    Type[] lower = w.getLowerBounds();
		    if (upper.length==1 && lower.length==0) {
				out.print("? extends ");
				printType(upper[0]);
		    } else if (upper.length==0 && lower.length==1) {
				out.print("? super ");
				printType(lower[0]);
		    } else assert false;
		}
    }
    public static void printClass (Class c) {
		out.print("class:");
		out.print(c.getName());
		printTypeParameters(c.getTypeParameters());
		out.println();
		out.print("Superclass:");
		printSuperclass(c.getGenericSuperclass());
		out.println();
		out.print("Interfaces:");
		printInterfaces(c.getGenericInterfaces());
		out.println();
		/*
		out.println("{");
		for (Field f : c.getFields()) {
		    out.println("  "+f.toGenericString()+";");
		}
		for (Constructor k : c.getConstructors()) {
		    out.println("  "+k.toGenericString()+";");
		}
		for (Method m : c.getMethods()) {
		    out.println("  "+m.toGenericString()+";");
		}
		out.println("}");
	*/
    }
    public static void main (String[] args) throws ClassNotFoundException {
    	
		for (String name : args) {
		    Class<?> c = Class.forName(name);
		    printClass(c);
		} 
		// java ReflectionDemo java.util.AbstractList
		
		Class<?> clas = java.util.AbstractList.class;
		printClass(clas);
		
		Class<?> enumClass = java.lang.Enum.class;
		printClass(enumClass);
    }
}

