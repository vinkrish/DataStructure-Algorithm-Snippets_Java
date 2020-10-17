package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericReflection {

	public static void main(String[] args) throws Exception {
		Class myClass = ReflectClass.class;
		
		//----------------Generic Method Return Types------------------
		Method method = myClass.getMethod("getStringList", null);

		Type returnType = method.getGenericReturnType();

		if(returnType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) returnType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		        Class typeArgClass = (Class) typeArgument;
		        System.out.println("typeArgClass = " + typeArgClass);
		    }
		}
		
		//------------------Generic Method Parameter Types-----------------
		method = myClass.getMethod("setStringList", List.class);

		Type[] genericParameterTypes = method.getGenericParameterTypes();

		for(Type genericParameterType : genericParameterTypes){
		    if(genericParameterType instanceof ParameterizedType){
		        ParameterizedType aType = (ParameterizedType) genericParameterType;
		        Type[] parameterArgTypes = aType.getActualTypeArguments();
		        for(Type parameterArgType : parameterArgTypes){
		            Class parameterArgClass = (Class) parameterArgType;
		            System.out.println("parameterArgClass = " + parameterArgClass);
		        }
		    }
		}
		
		//-----------------Generic Field Types-------------------
		Field field = myClass.getField("stringList");

		Type genericFieldType = field.getGenericType();

		if(genericFieldType instanceof ParameterizedType){
		    ParameterizedType aType = (ParameterizedType) genericFieldType;
		    Type[] fieldArgTypes = aType.getActualTypeArguments();
		    for(Type fieldArgType : fieldArgTypes){
		        Class fieldArgClass = (Class) fieldArgType;
		        System.out.println("fieldArgClass = " + fieldArgClass);
		    }
		}

	}

}
