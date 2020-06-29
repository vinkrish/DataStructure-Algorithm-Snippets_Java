package recursion;

import java.util.Arrays; 

public class RecursiveProcessingI_Stats
{
    static int[] a1 = {5, 3, 6, 7, 9, 24, 27, 1, 0 , 16}; 
    
    public static void traverse(int[] a){
         traverse(a, 0);     
    }
    
    public static void traverse(int[] a, int current){
         if (current == a.length) { System.out.println(); return;  }
         System.out.print("("+a[current]+") ");
         traverse(a, current+1); 
    }    
    
    public static int max(int[] a){
        return max(a, 0, Integer.MIN_VALUE);     
    }
    
    public static int max(int[] a, int current, int result){
         if (current == a.length) return result; 
         if (a[current] > result) result = a[current]; 
         return max(a, current+1, result);     
    }
    
    public static int min(int[] a){
        return min(a, 0, Integer.MAX_VALUE);     
    }
    
    public static int min(int[] a, int current, int result){
         if (current == a.length) return result; 
         if (a[current] < result) result = a[current]; 
         return min(a, current+1, result);     
    }    
    
    public static int sum(int[] a){
       return sum(a, 0, 0); 
    }
    
    public static int sum(int[] a, int current, int result){
         if (current == a.length) return result; 
         result += a[current];
         return sum(a, current+1, result);     
    }
    
    public static double avg(int[] a){
        return (double) sum(a1)/a1.length;
    }
    
    public static void main(String[] args){
        // Print out data in a1 using a2 array
        Integer[] a2 = new Integer[a1.length];
        for (int i=0; i<a1.length; i++) a2[i] = new Integer(a1[i]); 
        System.out.println("Data: "+ Arrays.asList(a2).toString()); 
        System.out.print("Traverse: "); traverse(a1); 
        System.out.println("Max: "+max(a1)); 
        System.out.println("Min: "+min(a1)); 
        System.out.println("Sum: "+sum(a1)); 
        System.out.println("Avg: "+avg(a1)); 
    }
}
