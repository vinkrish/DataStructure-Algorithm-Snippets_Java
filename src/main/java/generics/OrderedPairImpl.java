package generics;

public class OrderedPairImpl {

	public static void main(String[] args) {
		OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
		OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
		
		boolean isSame = OrderedPairImpl.isSame(p1, p2);
		System.out.println(isSame);
		
		boolean same = OrderedPairImpl.<Integer, String>isSame(p1, p2);
		System.out.println(same);
		
		OrderedPair<Double, String> p3 = new OrderedPair<>(1.1, "pear");
		OrderedPair<Double, String> p4 = new OrderedPair<>(1.1, "pear");
		
		boolean sameMore = OrderedPairImpl.compare(p3, p4);
		System.out.println(sameMore);
		
		/*
		 * method type will stop passing different type other than it expects
		 */
		OrderedPair<String, String> p5 = new OrderedPair<>("1", "pear");
		OrderedPair<String, String> p6 = new OrderedPair<>("1", "pear");
		boolean isSameS = OrderedPairImpl.isSame(p5, p6);
		System.out.println(isSameS);
//		boolean canMore = OrderedPairImpl.compare(p5, p6);
		
		
	}
	
	public static <K, V> boolean isSame(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
	
	public static <K extends Number, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) &&
	               p1.getValue().equals(p2.getValue());
	}

}
