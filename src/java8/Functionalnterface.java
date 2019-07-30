package java8;

public class Functionalnterface {

	public static void main(String[] args) {
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);
		
		// static method referencing
		
		Converter<String, Integer> converterStatic = Integer::valueOf;
		Integer convertedStatic = converterStatic.convert("123");
		System.out.println(convertedStatic);
		
	}
	
	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}

}
