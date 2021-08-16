package lombokk;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Constructors<T> {
	private int x, y;
	@NonNull
	private T description;

	@NoArgsConstructor
	public static class NoArgsExample {
		@NonNull
		private String field;
	}
}