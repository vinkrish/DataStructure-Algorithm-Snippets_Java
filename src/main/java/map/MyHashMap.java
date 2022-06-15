package map;

import java.util.*;

public class MyHashMap<K, V> {

	public static void main(String[] args) {
		MyHashMap<String, String> obj = new MyHashMap<>();
		
		obj.put("1", "One"); 
		String value = obj.get("1");
		System.out.println(value);
		
		boolean isExist = obj.containsKey("1");
		 System.out.println(isExist);
		
		obj.remove("1");
		
		isExist = obj.containsKey("1");
		System.out.println(isExist);

	}

	private int key_space;
	private List<Bucket<K, V>> hash_table;

	/** Initialize your data structure here. */
	public MyHashMap() {
		this.key_space = 2069;
		this.hash_table = new ArrayList<Bucket<K, V>>();
		for (int i = 0; i < this.key_space; ++i) {
			this.hash_table.add(new Bucket<K, V>());
		}
	}

	/** value will always be non-negative. */
	public void put(K key, V value) {
		int hash_key = getIndex(key) % this.key_space;
		this.hash_table.get(hash_key).update(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
	 * for the key
	 */
	public V get(K key) {
		int hash_key = getIndex(key) % this.key_space;
		return this.hash_table.get(hash_key).get(key);
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(K key) {
		int hash_key = getIndex(key) % this.key_space;
		this.hash_table.get(hash_key).remove(key);
	}
	
	public int getIndex(K key) {
		return key.hashCode();
	}
	
	public boolean containsKey(K key) {
		if(key == null) return false;
		
		int hash_key = getIndex(key) % this.key_space;
		if(this.hash_table.get(hash_key) == null) {
			return false;
		}
		
		return this.hash_table.get(hash_key).checkKey(key);
	}

}

class MyEntry<K, V> {
	public K key;
	public V value;

	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
}


class Bucket<K, V> {
	private List<MyEntry<K, V>> bucket;

	public Bucket() {
		this.bucket = new LinkedList<MyEntry<K, V>>();
	}

	public V get(K key) {
		for (MyEntry<K, V> pair : this.bucket) {
			if (pair.key.equals(key))
				return pair.value;
		}
		return null;
	}

	public void update(K key, V value) {
		boolean found = false;
		for (MyEntry<K, V> pair : this.bucket) {
			if (pair.key.equals(key)) {
				pair.value = value;
				found = true;
			}
		}
		if (!found)
			this.bucket.add(new MyEntry<K, V>(key, value));
	}

	public void remove(K key) {
		for (MyEntry<K, V> pair : this.bucket) {
			if (pair.key.equals(key)) {
				this.bucket.remove(pair);
				break;
			}
		}
	}
	
	public boolean checkKey(K key) {
		for (MyEntry<K, V> pair : this.bucket) {
			if (pair.key.equals(key)) {
				return true;
			}
		}
		return false;
	}
}

