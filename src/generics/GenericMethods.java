package generics;

public class GenericMethods {

	public static void main(String[] args) {
		OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
		OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
		
		boolean same = GenericMethods.<Integer, String>compare(p1, p2);
		System.out.println(same);
	}
	
	public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }

}
