package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WildCard {

	public static void main(String[] args) {
		
		/*
         interface Collection<E> {
         	...
			public boolean addAll(Collection<? extends E> c);
			...
		 }
         */
        
        List<Number> nums = new ArrayList<Number>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        
        /*
         * The first call is permitted because nums has type List<Number>, which is a subtype of Collection<Number>
         * ints has type List<Integer>, which is a subtype of Collection<? extends Number>
         */
        nums.addAll(ints);
        nums.addAll(dbls);
        
        System.out.println(nums);
        
//        List<Integer> ints = nums; List<Number> is not a subtype of List<Integer>
        
        List<? extends Number> wildNums = ints; //List<Integer> is a subtype of List<? extends Number>
        System.out.println(wildNums);
        
        /*
        wildNums.add(1);
        wildNums.add(1.1);
        
        Above calls fails as it might be a list of some other subtype of number
        */

        List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
        Collections.copy(objs, ints);
        System.out.println(objs);
        
        /* Above call is possible because dst list may have elements of any type that is a supertype of T
         * 
         public static <T> void copy(List<? super T> dst, List<? extends T> src) {
			for (int i = 0; i < src.size(); i++) {
				dst.set(i, src.get(i));
			}
		 }
		 *
		 Collections.<Object>copy(objs, ints);
		 Collections.<Number>copy(objs, ints);
		 Collections.<Integer>copy(objs, ints);
         */
        
        System.out.println(sum(ints));
        System.out.println(sum(dbls));
        System.out.println(sum(nums));
        
//        ints = Arrays.asList(1, 2); fails when passed to addCount, don't know why
        ints = new ArrayList<Integer>();
        ints.add(0);
        addCount(ints, 3);
        System.out.println(ints);
        
        nums = new ArrayList<Number>();
        addCount(nums, 3); 
        nums.add(4.0);
        System.out.println(nums);
        
        objs = new ArrayList<Object>();
        addCount(objs, 2); 
        objs.add("three");
        System.out.println(objs);
        
        dbls = new ArrayList<Double>();
//        addCount(dbls, 2); fails as Double is not a super type of Integer
        
        nums = new ArrayList<Number>();
        double sum = sumCount(nums,5);
        System.out.println(sum);
	}
	
	/*
	 * The Get and Put Principle: 
	 * use an extends wildcard when you only get values out of a structure, 
	 * use a super wildcard when you only put values into a structure, 
	 * and don’t use a wildcard when you both get and put.
	 */
	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number num : nums) s += num.doubleValue();
		return s;
	}
	
	public static void addCount(Collection<? super Integer> ints, int n) {
		for (int i = 1; i <= n; i++) ints.add(i);
	}
	
	public static double sumCount(Collection<Number> nums, int n) {
		addCount(nums, n);
		return sum(nums);
	}

}
