package commontests;

public class StringTest {

	public static void main(String[] args) {
		
		String s = "Hello World!";
		
		String str = new String("Hello Java!");
		
		System.out.println(s.length());
		
		System.out.println(s.concat(" - ").concat(str));
		
		System.out.println(s + " - " + str);
		
		System.out.println(s.charAt(0));
		
		System.out.println(s.substring(6));
		
		System.out.println(s.substring(0, 5));
		
		System.out.println(s.equals(str));
		
		System.out.println(s.equalsIgnoreCase(str));
		
		System.out.println(s.compareTo(str)); // Compares two strings lexicographically
		
		System.out.println(s.indexOf("!"));
		
		System.out.println(s.indexOf("Worl"));
		
		System.out.println(s.lastIndexOf("l"));
		
		System.out.println(s.replace("!", "*"));
		
		System.out.println(s.toLowerCase());
		
		System.out.println(s.toUpperCase());
		
		System.out.println(s.trim());
		System.out.println(s.strip());
		System.out.println(s.stripLeading());
		System.out.println(s.stripTrailing());
		
		System.out.println(s.startsWith("Hell"));
		
		System.out.println(s.endsWith("!"));
		
		System.out.println(s.contains("lo"));
		
		System.out.println(String.join(", ", new String[] { "once", "upon", "a", "time" } ));
		
		System.out.println(s.isEmpty());
		
		System.out.println(String.valueOf(9));
		
		System.out.println(s.repeat(3));
		
		String name = "Vinay";
        int age = 30;
        double salary = 175000.00;
        String formattedString = String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary);
		System.out.println(formattedString);
		
		for (char c : s.toCharArray()) {
			System.out.println(c);
		}
		
		String charString = "Hello World!";
        for (int i = 0; i < charString.length(); i++) {
            char c = charString.charAt(i);
            
            if (Character.isLowerCase(c)) {
                System.out.println(c + " is a lowercase letter.");
            } else if (Character.isUpperCase(c)) {
                System.out.println(c + " is an uppercase letter.");
            } else {
                System.out.println(c + " is not a letter.");
            }
        }
	}

}
