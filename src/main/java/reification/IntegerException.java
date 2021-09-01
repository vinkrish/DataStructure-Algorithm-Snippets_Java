package reification;

public class IntegerException extends Exception{
	private static final long serialVersionUID = 4882765205306912497L;
	private final int value;
	public IntegerException(int value) { this.value = value; }
	public int getValue() { return value; }
}
