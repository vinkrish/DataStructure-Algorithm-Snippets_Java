package cglib.mixin;

import org.junit.jupiter.api.Test;

import net.sf.cglib.proxy.Mixin;

import static org.assertj.core.api.Assertions.assertThat;

public class MixinUnitTest {
	@Test
    public void givenTwoClasses_whenMixedIntoOne_thenMixinShouldHaveMethodsFromBothClasses() throws Exception {
        // when
        Mixin mixin = Mixin.create(new Class[] { Interface1.class, Interface2.class, MixinInterface.class }, new Object[] { new Class1(), new Class2() });
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        // then
        assertThat("first behaviour").isEqualTo(mixinDelegate.first());
        assertThat("second behaviour").isEqualTo(mixinDelegate.second());
    }
}
