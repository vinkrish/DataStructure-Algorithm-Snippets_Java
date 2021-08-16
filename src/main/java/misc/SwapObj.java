package misc;

public class SwapObj {
	public static void main(String[] args) {
       intWrap i = new intWrap();
       i.x = 10;
       intWrap j = new intWrap();
       j.x = 20;
       swap(i, j);
       System.out.println("i.x = " + i.x + ", j.x = " + j.x);
       objSwap(i,j);
       System.out.println("i.x = " + i.x + ", j.x = " + j.x);
    } 
    public static void swap(intWrap i, intWrap j) {
       int temp = i.x;
       i.x = j.x;
       j.x = temp;
    }
    public static void objSwap(intWrap i, intWrap j) {
    	System.out.println("Before :" + i.x + " - " + j.x);
    	intWrap temp = new intWrap();
    	temp = i;
    	i = j;
    	j = temp;
    	System.out.println("After :" + i.x + " - " + j.x);
    }
}

class intWrap {
   int x;
   intWrap(){}
   intWrap(int i) { x = i; }
} 
