package recursion;

import java.util.ArrayList; 

public class RecursiveProcessingII_Text { 
	
   public static String reverse(String a){
      if (a.length()==1) return a; 
      return a.charAt(a.length()-1)+reverse(a.substring(0, a.length()-1)); 
    }
    
   public static void permute(String a, ArrayList<String> alist){
       permute(a, "", alist); 
    }
   
   public static String cut(String a, int i){
       return a.substring(0, i)+a.substring(i+1); 
    }
    
   public static void permute(String a, String result, ArrayList<String> alist){
         if (a.length() == 1) { alist.add(a.charAt(0)+ result); return; }
         for (int i=0; i<a.length(); i++) permute(cut(a, i), a.charAt(i)+result, alist);      
    }
    
   public static void main(String[] args){
      System.out.println("Reverse of Computer is "+reverse("Computer"));
      ArrayList<String> alist = new ArrayList<String>();
      System.out.println("String: "+"ABC");
      permute("ABC", alist); 
      System.out.println("Permutation"+alist);
    }
}
