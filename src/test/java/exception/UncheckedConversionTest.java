package exception;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UncheckedConversionTest {
	
	@Test
    public void givenRawList_whenAssignToTypedList_shouldHaveCompilerWarning() {
        List<String> fromRawList = UncheckedConversion.getRawList();
        assertThat(fromRawList.size()).isEqualTo(3);
        Assertions.assertEquals(fromRawList.get(0), "I am the 1st String.");
    }

    @Test()
    public void givenRawList_whenListHasMixedType_shouldThrowClassCastException() {
        Assertions.assertThrows(ClassCastException.class, ()-> {
        	List<String> fromRawList = UncheckedConversion.getRawListWithMixedTypes();
        	assertThat(fromRawList.size()).isEqualTo(4);
            Assertions.assertFalse(fromRawList.get(3).endsWith("String."));
        });
    }
    
	@Test
	public void givenRawList_whenAssignToTypedListAfterCallingCastList_shouldOnlyHaveElementsWithExpectedType() {
	    List rawList = UncheckedConversion.getRawListWithMixedTypes();
	    List<String> strList = UncheckedConversion.castList(String.class, rawList);
	    assertThat(rawList.size()).isEqualTo(4);
	    assertThat(strList.size()).isEqualTo(3);
	    
	    Assertions.assertTrue(strList.stream().allMatch(el -> el.endsWith("String.")));
	}
	
	@Test()
    public void givenRawListWithWrongType_whenAssignToTypedListAfterCallingCastList2_shouldThrowException() {
        List rawList = UncheckedConversion.getRawListWithMixedTypes();
        Assertions.assertThrows(ClassCastException.class, () -> UncheckedConversion.castList2(String.class, rawList));
    }
}
