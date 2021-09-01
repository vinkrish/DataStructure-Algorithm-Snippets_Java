package exception;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UncheckedCastTest {

    @Test
    public void givenRawMap_whenCastToTypedMap_shouldHaveCompilerWarning() {
        Map<String, LocalDate> castFromRawMap = (Map<String, LocalDate>) UncheckedCast.getRawMap();
        assertThat(castFromRawMap.size()).isEqualTo(3);
        assertThat(castFromRawMap.get("date 2")).isEqualTo(LocalDate.of(1992, Month.AUGUST, 8));
    }

    @Test()
    public void givenMixTypedRawMap_whenCastToTypedMap_shouldThrowClassCastException() {
    	Assertions.assertThrows(ClassCastException.class, ()-> {
    		Map<String, LocalDate> castFromRawMap = (Map<String, LocalDate>) UncheckedCast.getRawMapWithMixedTypes();
        	assertThat(castFromRawMap.size()).isEqualTo(4);
            Assertions.assertTrue(castFromRawMap.get("date 4").isAfter(castFromRawMap.get("date 3")));
        });
    }
}