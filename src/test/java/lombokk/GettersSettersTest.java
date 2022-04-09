package lombokk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GettersSettersTest {
	
	@Test
    public void givenObjectHasGettersAndSetters() {
		GettersSetters gettersSetters = new GettersSetters();
		gettersSetters.setAge(21);
        assertEquals(gettersSetters.getAge(), 21);
    }

}
