package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String   value() default "Hello Annotation!";

    String   name();
    int      age();
    String[] newNames();
}
