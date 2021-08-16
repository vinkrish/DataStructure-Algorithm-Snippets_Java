package exception;

public class TryMultiple {
	int count = 0;
	 
    void A() throws Exception {
        try {
            count++;             
            try {
                count++;
                try {
                    count++;
                    throw new Exception();
                } catch(Exception ex) {
                    count++;
                    throw new Exception();
                }
            } catch(Exception ex) {
            	System.out.println("This does get print first!");
                count++;
            }
            System.out.println("This does get print!");
        } catch(Exception ex) {
        	System.out.println("This does not print!");
            count++;
        }
    }
 
    void display() {
        System.out.println(count);
    }
 
    public static void main(String[] args) throws Exception {
    	TryMultiple obj = new TryMultiple();
        obj.A();
        obj.display();
    }
}
