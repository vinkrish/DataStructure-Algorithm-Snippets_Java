package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * The intent of Java when releasing Optional was to use it as a return type
 */
public class OptionalTest {

	public static void main(String[] args) {
		// Creating Optional Objects
		
		Optional<String> opt = Optional.empty();
		boolean bool = opt.isPresent();
		System.out.println(bool);
		
		String name = "vinkrish";
	    opt = Optional.of(name);
	    bool = opt.isPresent();
		System.out.println(bool);
		
		name = null;
		try {
			opt = Optional.of(name);
		} catch(NullPointerException e) {
			System.out.println("Value passed to Optional.of() can't be null");
		}
		
		opt = Optional.ofNullable(name); // if null values needed to be accepted
		bool = opt.isPresent();
		System.out.println(bool);
		
		// Checking Value Presence in Java 11: isEmpty()
		name = "Angel";
		opt = Optional.ofNullable(name);
		bool = opt.isEmpty();
		System.out.println(bool);
		
		// Conditional Action
		opt.ifPresent(optValue -> System.out.println(optValue.length()));
		
		// Default Value With orElse()
		name = null;
		name = Optional.ofNullable(name).orElse("Vinay");
		System.out.println(name);
		
		// Default Value With orElseGet(), it takes a supplier functional interface, which is invoked and returns the value of the invocation
		name = null;
		name = Optional.ofNullable(name).orElseGet(() -> "Krishna");
		System.out.println(name);
		
		String text = null;
		String defaultText = Optional.ofNullable(text).orElseGet(OptionalTest::getMyDefault);
		System.out.println(defaultText);
		
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println(defaultText);
		
		OptionalTest ot = new OptionalTest();
		ot.testMethod();
		
		text = "Text present";
		
		defaultText = Optional.ofNullable(text).orElseGet(OptionalTest::getMyDefault);
		System.out.println(defaultText);
		
		// whether the wrapped value is present or not, the default object is created - one redundant object that is never used.
		defaultText = Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println(defaultText);
		
		// Exceptions With orElseThrow()
		try {
			name = null;
			name = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Optional.ofNullable(name).orElseThrow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Returning Value With get()
		System.out.println(opt.get());
		
		
		opt = Optional.ofNullable(null);
		try {
			opt.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Conditional Return With filter()
		Person person = new Person("Vinay", null);
		System.out.println(person.priceIsInRange1(person));
		person = new Person("Krishna", 13.0);
		System.out.println(person.priceIsInRange2(person));
		
		/*
		 * Transforming Value With map()
		 * filter method simply performs a check on the value and 
		 * returns an Optional describing this value only if it matches the given predicate, otherwise returns an empty Optional. 
		 * 
		 * The map method however takes the existing value, performs a computation using this value, and 
		 * returns the result of the computation wrapped in an Optional object:
		 */
		
		List<String> companyNames = Arrays.asList("amazon", "", "microsoft", "", "google");
	    Optional<List<String>> listOptional = Optional.of(companyNames);

	    int size = listOptional
	      .map(List::size)
	      .orElse(0);
	    
	    System.out.println(size);
	    
	    // chaining map and filter
	    String password = " password ";
	    Optional<String> passOpt = Optional.of(password);
	    
	    boolean correctPassword = passOpt
	    		.filter(pass -> pass.equals("password"))
	    		.isPresent();
	    System.out.println(correctPassword);

	    correctPassword = passOpt
	      .map(String::trim)
	      .filter(pass -> pass.equals("password"))
	      .isPresent();
	    System.out.println(correctPassword);
	    
	    // flatMap()
	    InnerPerson innerPerson = ot.new InnerPerson("Dupee", 24);
	    Optional<InnerPerson> personOptional = Optional.of(innerPerson);
	    name = personOptional
	    		.flatMap(InnerPerson::getName)
	    		.orElse("");
	    System.out.println(name);
	}
	
	public void testMethod() {
		String text = null;
		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefaultNonStatic);
		System.out.println(defaultText);
	}
	
	public String getMyDefaultNonStatic() {
	    return "Value from Default Method execution";
	}
	
	public static String getMyDefault() {
		System.out.println("Getting Default Value");
	    return "Default Value";
	}
	
	public class InnerPerson {
	    private String name;
	    private int age;

	    public InnerPerson(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public Optional<String> getName() {
	        return Optional.ofNullable(name);
	    }

	    public Optional<Integer> getAge() {
	        return Optional.ofNullable(age);
	    }
	    
	}

}
