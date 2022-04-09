package java8;

import java.time.chrono.IsoChronology;

public class HigherOrderFunction {

	public static void main(String[] args) {
		
		PersonL personL = createFactory(() -> new PersonL( "Vinay", IsoChronology.INSTANCE.date(1989, 8, 10), PersonL.Sex.MALE, "vinaykrishna@example.com"), 
				(person) -> person.name = "Krishna" ).create();
		
		personL.printPerson();
		
		IFactory<PersonL> personHOF = createFactory(() -> new PersonL( "Angel", IsoChronology.INSTANCE.date(1998, 3, 5), PersonL.Sex.FEMALE, "angeldupee@example.com"), 
				(person) -> person.name = "Dupee" );
		
		personHOF.create().printPerson();
		
	}
	
	public static <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
        return () -> {
           T instance = producer.produce();
           configurator.configure(instance);
           return instance;
        };
    }
	
	public interface IFactory<T> {
		T create();
	}
	public interface IProducer<T> {
	   T produce();
	}
	public interface IConfigurator<T> {
	   void configure(T t);
	}

}
