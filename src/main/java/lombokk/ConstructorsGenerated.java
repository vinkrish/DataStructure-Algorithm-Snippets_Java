package lombokk;

import lombok.NonNull;

public class ConstructorsGenerated<T> {
  private int x;
  
  private int y;
  
  @NonNull
  private T description;
  
  private ConstructorsGenerated(@NonNull T paramT) {
    if (paramT == null)
      throw new NullPointerException("description is marked non-null but is null"); 
    this.description = paramT;
  }
  
  public static <T> ConstructorsGenerated<T> of(@NonNull T paramT) {
    return new ConstructorsGenerated<>(paramT);
  }
  
  protected ConstructorsGenerated(int paramInt1, int paramInt2, @NonNull T paramT) {
    if (paramT == null)
      throw new NullPointerException("description is marked non-null but is null"); 
    this.x = paramInt1;
    this.y = paramInt2;
    this.description = paramT;
  }
  
  public static class NoArgsExample {
    @NonNull
    private String field;
  }
}
