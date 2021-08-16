package classes;

public class Clonable implements Cloneable
{
	
	int age;  
	String name; 
	String girlfriend;
	  
	Clonable(int age, String name, String gf) {  
		this.age=age;  
		this.name=name;  
		this.girlfriend = gf;
	}  
	  
//	public Object clone() throws CloneNotSupportedException {  
//		return super.clone();  
//	} 
	
	/**
	 * Restricting certain fields of cloned object to remain same as original object (cloning object)
	 */
	@Override
    protected Object clone() throws CloneNotSupportedException {
		Clonable clonable = null;
        try {
        	clonable = (Clonable) super.clone();
        	clonable.girlfriend = this.girlfriend;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonable;
    }

	public static void main(String[] args)
	{
		try {
			Clonable s1=new Clonable(31, "Vinay", "Angel");  
			  
			Clonable s2=(Clonable)s1.clone();  
			  
			System.out.println(s1.age+" "+s1.name+", girlfriend:"+s1.girlfriend);  
			System.out.println(s2.age+" "+s2.name+", girlfriend:"+s1.girlfriend);  
			
			s1.age = 32;
			s1.girlfriend = "Angel Dupee";
			
			System.out.println(s1.age+" "+s1.name+", girlfriend:"+s1.girlfriend);  
			System.out.println(s2.age+" "+s2.name+", girlfriend:"+s1.girlfriend);
			  
		}
		catch(CloneNotSupportedException c){
			c.printStackTrace();
		}

	}

}
