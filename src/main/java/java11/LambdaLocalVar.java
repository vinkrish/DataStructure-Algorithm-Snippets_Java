package java11;

import java.util.function.BiFunction;

public class LambdaLocalVar {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (var x, var y) -> x + y;
        System.out.println(add.apply(2, 3)); // Output: 5
    }
}

/*
Local-Variable Syntax for Lambda Parameters:
	This feature allows the use of var in lambda parameters, making the syntax more consistent with local variable declarations.
	This is particularly useful when annotating parameters in a lambda expression.
 
Use Function when your transformation or computation requires only one input.
Use BiFunction when your transformation or computation requires two inputs.
*/