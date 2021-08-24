package abstraction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AbstractImplTest {
	
	@Test
	public void testInstanceOf() {
		Bike obj = new AbstractImpl();
		obj.run();
		obj.changeGear();
		
		assertThat(obj).isInstanceOf(Bike.class);
	}
	

}
