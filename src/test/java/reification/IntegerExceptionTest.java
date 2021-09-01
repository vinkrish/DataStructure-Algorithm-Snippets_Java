package reification;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/*
 * In a try statement, each catch clause checks whether the thrown exception matches a given type. 
 * This is the same as the check performed by an instance test, so the same restriction applies: the type must be reifiable.
 */
public class IntegerExceptionTest {
	
	@Test
	public void test_exception() {
		try {
			throw new IntegerException(42);
		} catch (IntegerException e) {
			assertThat(e.getValue()).isEqualTo(42);
		}
	}

}
