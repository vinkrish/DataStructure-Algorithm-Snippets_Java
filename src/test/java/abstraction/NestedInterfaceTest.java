package abstraction;

import org.junit.jupiter.api.Test;

public class NestedInterfaceTest {
	
	@Test
	public void testMethod() {
		ShowableNI.Message message = new NestedInterface(); // upcasting here
//		message.show();
		message.msg();
	}

}
