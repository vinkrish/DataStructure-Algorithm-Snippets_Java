package cglib.proxy;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

public class ProxyIntegrationTest {
	@Test
    public void givenPersonService_whenSayHello_thenReturnResult() {
        // given
        PersonService personService = new PersonService();

        // when
        String res = personService.sayHello("Tom");

        // then
        assertThat(res).isEqualTo("Hello Tom");
    }

    @Test
    public void givenEnhancerProxy_whenExtendPersonService_thenInterceptMethod() throws Exception {
        // given
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();

        // when
        String res = proxy.sayHello(null);

        // then
        assertThat("Hello Tom!").isEqualTo(res);
    }

    @Test
    public void givenEnhancer_whenExecuteMethodOnProxy_thenInterceptOnlyStringReturnTypeMethod() throws Exception {
        // given
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        // when
        PersonService proxy = (PersonService) enhancer.create();

        // then
        assertThat("Hello Tom!").isEqualTo(proxy.sayHello(null));
        int lengthOfName = proxy.lengthOfName("Mary");
        assertThat(4).isEqualTo(lengthOfName);
    }

}
