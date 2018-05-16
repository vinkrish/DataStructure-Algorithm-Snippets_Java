package challange;

public class ReverseInt {

	public static void main(String[] args) {
		System.out.println(getReverseInt(154354378));
	}
	
	public static int getReverseInt(int value) {
	    int resultNumber = 0;
	    for (int i = value; i !=0; i /= 10) {
	        resultNumber = resultNumber * 10 + i % 10;
	    }
	    return resultNumber;        
	}

}
