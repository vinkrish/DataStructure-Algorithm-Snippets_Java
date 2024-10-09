package commontests;

public class MathTest {

	public static void main(String[] args) {
		// Basic Arithmetic Operations
		int a = -10;
		int b = 20;

		int absoluteValue = Math.abs(a);  // 10
		int maxValue = Math.max(a, b);    // 20
		int minValue = Math.min(a, b);    // -10

		System.out.println("Absolute value: " + absoluteValue);
		System.out.println("Max value: " + maxValue);
		System.out.println("Min value: " + minValue);
		
		// Power and Square Root
		
		double base = 3.0;
		double exponent = 2.0;

		double powerResult = Math.pow(base, exponent);   // 9.0
		double sqrtResult = Math.sqrt(powerResult);      // 3.0

		System.out.println("Power: " + powerResult);
		System.out.println("Square Root: " + sqrtResult);
		
		// Trigonometric Functions

		double angleInRadians = Math.toRadians(45);

		double sinValue = Math.sin(angleInRadians);   // 0.7071
		double cosValue = Math.cos(angleInRadians);   // 0.7071
		double tanValue = Math.tan(angleInRadians);   // 1.0

		System.out.println("Sine: " + sinValue);
		System.out.println("Cosine: " + cosValue);
		System.out.println("Tangent: " + tanValue);

		// Rounding Numbers
		double num = 5.67;

		long roundedValue = Math.round(num);   // 6
		double floorValue = Math.floor(num);   // 5.0
		double ceilValue = Math.ceil(num);     // 6.0

		System.out.println("Rounded: " + roundedValue);
		System.out.println("Floor: " + floorValue);
		System.out.println("Ceiling: " + ceilValue);

		// Generating Random Numbers
		double randomValue = Math.random();   // A random value between 0.0 and 1.0
		int randomInt = (int)(Math.random() * 100);  // A random integer between 0 and 99

		System.out.println("Random value: " + randomValue);
		System.out.println("Random integer (0-99): " + randomInt);

		// Exponential and Logarithmic Functions
		double x = 2.0;

		double expValue = Math.exp(x);     // e^2 = 7.389
		double logValue = Math.log(expValue);  // ln(7.389) = 2.0
		double log10Value = Math.log10(100);   // log10(100) = 2.0

		System.out.println("Exponential: " + expValue);
		System.out.println("Natural Logarithm: " + logValue);
		System.out.println("Logarithm base 10: " + log10Value);

		// Angle Conversion
		double degrees = 90.0;
		double radians = Math.toRadians(degrees);   // 1.5708 radians
		double backToDegrees = Math.toDegrees(radians);  // 90.0 degrees

		System.out.println("Degrees to Radians: " + radians);
		System.out.println("Radians to Degrees: " + backToDegrees);

		// Hyperbolic Functions
		double value = 1.0;

		double sinhValue = Math.sinh(value);  // 1.175
		double coshValue = Math.cosh(value);  // 1.543
		double tanhValue = Math.tanh(value);  // 0.761

		System.out.println("Sinh: " + sinhValue);
		System.out.println("Cosh: " + coshValue);
		System.out.println("Tanh: " + tanhValue);

		// Logarithmic Exponential Operations
		double base2 = 2.0;
		double result = Math.pow(base2, 3);    // 8.0
		double logResult = Math.log(result);  // log(8) = 2.079

		System.out.println("Exponentiation: " + result);
		System.out.println("Logarithm: " + logResult);

		// Constants
		double circumference = 2 * Math.PI * 5;  // Circumference of a circle with radius 5
		double exponential = Math.exp(1);        // e^1

		System.out.println("Circumference: " + circumference);
		System.out.println("Exponential (e): " + exponential);

	}

}
