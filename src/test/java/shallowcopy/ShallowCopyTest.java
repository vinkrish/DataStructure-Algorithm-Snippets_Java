package shallowcopy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class ShallowCopyTest {
	@Test
    public void whenShallowCopying_objectsShouldNotBeSame() {

        Address address = new Address("3077 State Route 11", "Mooers Forks", "USA");
        User pm = new User("Vinay", "Krishna", address);

        User shallowCopy = new User(pm.getFirstName(), pm.getLastName(), pm.getAddress());

        assertThat(shallowCopy).isNotSameAs(pm);

    }

    @Test
    public void whenModifyingOriginalObject_copyShouldChange() {

        Address address = new Address("3077 State Route 11", "Mooers Forks", "USA");
        User pm = new User("Vinay", "Krishna", address);

        User shallowCopy = new User(pm.getFirstName(), pm.getLastName(), pm.getAddress());

        address.setCountry("United States");
        
        assertThat(shallowCopy.getAddress().getCountry()).isEqualTo(pm.getAddress().getCountry());

    }

}
