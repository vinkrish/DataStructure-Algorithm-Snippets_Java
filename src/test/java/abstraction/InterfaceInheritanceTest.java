package abstraction;

import org.junit.jupiter.api.Test;

public class InterfaceInheritanceTest {
	
	@Test
	public void isInstanceOfTest() {
		Printable ancester = new InterfaceInheritance();
		ancester.print();
//		ancester.show();
		
		Showable parent = new InterfaceInheritance();
		parent.print();
		parent.show();
		
	}

}
