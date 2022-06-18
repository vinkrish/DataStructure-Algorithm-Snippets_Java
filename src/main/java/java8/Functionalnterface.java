package java8;

import java.util.function.Function;

public class Functionalnterface {

	Function<String, Integer> fi;

	public static void main(String[] args) {
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		// static method referencing
		
		Converter<String, Integer> converterStatic = Integer::valueOf;
		Integer convertedStatic = converterStatic.convert("123");
		System.out.println(convertedStatic);
		
		// An instance of a functional interface using a lambda expression
		TestInterface tester = () -> System.out.println("Java SE 8 is working!");
		tester.test();
		
	}

	public void setFi(Function<String, Integer> fi){
		this.fi = fi;
	}

	public void checkFi(String str) {
		System.out.println(this.fi.apply(str));
	}
	
	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}
	
	@FunctionalInterface
	public interface TestInterface {
		public void test();
	}

}

/*
 * Function is a functional interface provided by the java.util.function package.

	@FunctionalInterface
	public interface Function<T, R> {
	    R apply(T t);
	}
	
	This interface has a single abstract method, apply(T t), which makes it a functional interface.
*/
