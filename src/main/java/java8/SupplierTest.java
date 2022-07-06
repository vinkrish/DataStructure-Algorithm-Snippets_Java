package java8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

/*
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
 */
public class SupplierTest<T> {
    
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
        
        // ---------------------------------------------------------- //

        SupplierTest<String> obj = new SupplierTest<>();
        List<String> list = obj.supplier().get();

        // ---------------------------------------------------------- //

        Developer dev = factory(Developer::new);
        System.out.println(dev);

        Developer dev2 = factory(() -> new Developer("vinkrish"));
        System.out.println(dev2);

        // ---------------------------------------------------------- //

        System.out.println(new Developer().callRandomString.get());

    }

    public Supplier<List<T>> supplier() {

        // lambda
        // return () -> new ArrayList<>();

        // constructor reference
        return ArrayList::new;

    }

    public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));

        return developer;

    }
}

class DeveloperParent {

    /*
        return Config instead of String, 
        let calling child read config values (Typesafe Config).getString("some.field")
    */
    public static String getRandomString() {
        return "Hello From Supplier!";
    }

}

class Developer extends DeveloperParent{

    String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new);
    public Developer() {
    }

    // for factory(() -> new Developer("vinkrish"));
    public Developer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " - " + this.salary + " - " + this.start;
    }

    public Supplier<String> callRandomString = () -> getRandomString();

}
