package cglib.proxy;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import net.sf.cglib.beans.BeanGenerator;

public class BeanGeneratorIntegrationTest {
	@Test
    public void givenBeanCreator_whenAddProperty_thenClassShouldHaveFieldValue() throws Exception {
        // given
        BeanGenerator beanGenerator = new BeanGenerator();

        // when
        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        // then
        Method getter = myBean.getClass().getMethod("getName");
        assertThat("some string value set by a cglib").isEqualTo(getter.invoke(myBean));
    }
}
