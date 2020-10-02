package lombokk;

import lombok.Builder;

@Builder
public class Builders {
  @Builder.Default private long created = System.currentTimeMillis();
  private String name;
  private int age;
}
