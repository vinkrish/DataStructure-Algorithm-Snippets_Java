package set;

import java.util.*;

public class MyHashSet<T> {

	public static void main(String[] args) {
		 MyHashSet<Integer> obj = new MyHashSet<>();
		 obj.add(1);
		 
		 boolean isExist = obj.contains(1);
		 System.out.println(isExist);
		 
		 obj.remove(1);
		 
		 isExist = obj.contains(1);
		 System.out.println(isExist);

	}
	private Bucket<T>[] bucketArray;
	private int keyRange;

	/** Initialize your data structure here. */
	public MyHashSet() {
		this.keyRange = 769;
		this.bucketArray = new Bucket[this.keyRange];
		for (int i = 0; i < this.keyRange; ++i)
			this.bucketArray[i] = new Bucket<>();
	}

	protected int _hash(T key) {
		return (getIndex(key) % this.keyRange);
	}
	
	protected int getIndex(T key) {
		return key.hashCode();
	}

	public void add(T key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].insert(key);
	}

	public void remove(T key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].delete(key);
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(T key) {
		int bucketIndex = this._hash(key);
		return this.bucketArray[bucketIndex].exists(key);
	}
}


class Bucket<T> {
	private LinkedList<T> container;

	public Bucket() {
		container = new LinkedList<T>();
	}

	public void insert(T key) {
		int index = this.container.indexOf(key);
		if (index == -1) {
			this.container.addFirst(key);
		}
	}

	public void delete(T key) {
		this.container.remove(key);
	}

	public boolean exists(T key) {
		int index = this.container.indexOf(key);
		return (index != -1);
	}
}
