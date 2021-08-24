package abstraction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InterfaceDefaultTest {
	
	@Test
	public void testInstanceOf() {
		
		DrawableDefault obj = new InterfaceDefault();
		obj.draw();
		obj.msg();
		
		assertThat(obj).isInstanceOf(DrawableDefault.class);
	}

}
