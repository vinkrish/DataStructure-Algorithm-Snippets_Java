package lombokk;

public class BuildersGenerated {
  private long created;
  
  private String name;
  
  private int age;
  
  private static long $default$created() {
    return System.currentTimeMillis();
  }
  
  BuildersGenerated(long paramLong, String paramString, int paramInt) {
    this.created = paramLong;
    this.name = paramString;
    this.age = paramInt;
  }
  
  public static BuildersBuilder builder() {
    return new BuildersBuilder();
  }
  
  public static class BuildersBuilder {
    private boolean created$set;
    
    private long created$value;
    
    private String name;
    
    private int age;
    
    public BuildersBuilder created(long param1Long) {
      this.created$value = param1Long;
      this.created$set = true;
      return this;
    }
    
    public BuildersBuilder name(String param1String) {
      this.name = param1String;
      return this;
    }
    
    public BuildersBuilder age(int param1Int) {
      this.age = param1Int;
      return this;
    }
    
    public BuildersGenerated build() {
      long l = this.created$value;
      if (!this.created$set)
        l = BuildersGenerated.$default$created(); 
      return new BuildersGenerated(l, this.name, this.age);
    }
    
    public String toString() {
      return "Builders.BuildersBuilder(created$value=" + this.created$value + ", name=" + this.name + ", age=" + this.age + ")";
    }
  }
}
