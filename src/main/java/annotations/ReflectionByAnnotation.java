package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionByAnnotation {

	public static void main(String[] args) throws Exception {
		
		System.out.println("-------------------Class Annotations-------------------");
		Class aClass = MyClass.class;
		Annotation[] annotations = aClass.getAnnotations();
		// Annotation annotation = aClass.getAnnotation(MyAnnotation.class);

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
		
		System.out.println("-------------------Method Annotations------------------");
		Method method = aClass.getMethod("doSomething", null);
		Annotation[] methodAnnotations = method.getDeclaredAnnotations();
		// Annotation methodAnnotation = method.getAnnotation(MyAnnotation.class);

		for(Annotation annotation : methodAnnotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
		
		System.out.println("-----------------Parameter Annotations-----------------");
		Method methodElse = aClass.getMethod("doSomethingElse", String.class);
		Annotation[][] parameterAnnotations = methodElse.getParameterAnnotations();
		Class[] parameterTypes = methodElse.getParameterTypes();

		int i=0;
		for(Annotation[] annotationsParameters : parameterAnnotations){
		  Class parameterType = parameterTypes[i++];

		  for(Annotation annotation : annotationsParameters){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("param: " + parameterType.getName());
		        System.out.println("name : " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		  }
		}
		
		System.out.println("-------------------Field Annotations-------------------");
		Field field = aClass.getField("myField");
		Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
		// Annotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);

		for(Annotation annotation : fieldAnnotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}

	}

}
