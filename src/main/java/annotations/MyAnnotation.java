package annotations;

/*
 * http://tutorials.jenkov.com/java/annotations.html
 * http://tutorials.jenkov.com/java-reflection/annotations.html
 */
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String   value() default "Hello Annotation!";

    String   name();
    int      age();
    String[] newNames();
}
