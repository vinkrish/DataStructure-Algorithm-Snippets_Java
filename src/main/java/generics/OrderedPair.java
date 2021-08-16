package generics;

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}

/**
 * The following statements create two instantiations of the OrderedPair class:
 */

// Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
// Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");

// OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
// OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");

/**
 * You can also substitute a type parameter (i.e., K or V) with a parameterized type (i.e., List<String>). 
 * For example, using the OrderedPair<K, V> example:
 * 
 * OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
 */