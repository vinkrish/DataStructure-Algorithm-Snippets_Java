package abstraction;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InterfaceStaticTest {
	
	@Test
	public void checkResponseOfStaticMethodInterface() {
		DrawableStatic d = new InterfaceStatic();
		d.draw();  
		
		assertThat(DrawableStatic.cube(3)).isEqualTo(27);
	}

}
