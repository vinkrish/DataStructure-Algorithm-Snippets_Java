package reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GenericReflectionTest {
	
	/**
	 * Class tokens and the getClass method are treated specially by the compiler. 
	 * In general, if T is a type without type parameters, then T.class has type Class<T>, 
	 * and if e is an expression of type T then e.getClass() has type Class<? extends T>. 
	 * 
	 * The wildcard is needed because the type of the object referred to by the variable may be a subtype of the type of the variable, 
	 * as in this case, where a variable of type Number contains an object of type Integer.
	 */
	
	@Test
	public void classWithAndWithoutTypeParameter() {
		Class ki = Integer.class;
		Number n = Integer.valueOf(9);
		Class kn = n.getClass();
		assertThat(ki).isEqualTo(kn);
		
		Class<Integer> kig = Integer.class;
		Number ng = Integer.valueOf(9);
		Class<? extends Number> kng = ng.getClass();
		assertThat(kig).isEqualTo(kng);
		
	}
	
	@Test
	public void reflectedTypesAreReifiableTypes() {
		List<Integer> ints = new ArrayList<Integer>();
		List<String> strs = new ArrayList<String>();
		assertThat(ints.getClass()).isEqualTo(strs.getClass());
		assertThat(ints.getClass()).isEqualTo(ArrayList.class);
	}
	
	/*
	 * In general, if expression e has type T, then the expression e.getClass() has type Class<? extends |T|>, 
	 * where |T| is the erasure of the type T.
	 * 
	 * Here the expression ints has type List<Integer>, 
	 * so the expression ints.getClass() has type Class<? extends List>; 
	 * this is the case because erasing List<Integer> yields the raw type List. 
	 * The actual value of k is ArrayList.class, which has type Class<ArrayList>,
	 * which is indeed a subtype of Class<? extends List>.
	 */
	@Test
	public void getClassIsSpecial() {
		List<Integer> ints = new ArrayList<Integer>();
		Class<? extends List> k = ints.getClass();
		assertThat(k).isEqualTo(ArrayList.class);
	}
	
	/*
	 * Every type in Java, including primitive types and array types, has a class literal and a corresponding class token.
	 */
	@Test
	public void reflectionOnPrimitives() {
		int i = 0;
		Class c = ((Object)i).getClass(); // you are actually creating a new Integer instance with the same value.
		System.out.println(c);
		assertThat(int.class).isEqualTo(Integer.TYPE); // since int is not a reference type, so it is taken to be Class<Integer>.
	}
	
	/*
	 * you might expect the call java.lang.reflect.Array.newInstance(int.class,size) to return a value of type Integer[], 
	 * but in fact the call returns a value of type int[]. 
	 * These examples suggest that it might have made more sense to give the class token int.class the type Class<?>.
	 */
	
	@Test
	public void reflectionOnArray() {
		Class<int[]> intsClass = int[].class; // permitted since int[] is a reference type.
		int[] ints = {1,2,3};
 		assertThat(intsClass).isEqualTo(ints.getClass());
	}

}
