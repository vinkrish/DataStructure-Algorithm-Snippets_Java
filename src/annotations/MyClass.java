package annotations;

@MyAnnotation(
    name="Vinkrish",
    age=31,
    newNames={"Vinay", "Krishna"}
)
public class MyClass {
	
	@MyAnnotation(value = "Hello Field", name="someName", age = 0, newNames = { "" })
	public String myField = null;
	
	@MyAnnotation(value = "Hello World!", name="Ango", age = 22, newNames = { "Angel", "Dupee" })
	public void doSomething(){}
	
	public static void doSomethingElse(
        @MyAnnotation(value="aValue", name="aName", age = 0, newNames = { "" }) String parameter){
	}

}
