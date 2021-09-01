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
	 * (We’ll see what happens when T does have type parameters in the next section.) 
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
	}
	
	/*
	 * In general, if expression e has type T, then the expression e.getClass() has type Class<? extends |T|>, 
	 * where |T| is the erasure of the type T.
	 */
	@Test
	public void getClassIsSpecial() {
		List<Integer> ints = new ArrayList<Integer>();
		Class<? extends List> k = ints.getClass();
		assertThat(k).isEqualTo(ArrayList.class);
	}

}
