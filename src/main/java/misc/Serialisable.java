package misc;

/*
 * https://www.baeldung.com/java-serialization
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Serialisable
{

	public static void main(String[] args)
	{
		Person person = new Person();
	    person.setAge(20);
	    person.setName("Joe");
	    
		try
		{
			String filePath = "yourfile.txt";
			
			File yourFile = new File(filePath);
			if (!yourFile.exists()) {
				yourFile.createNewFile();
	        }
			
//			Path path = Paths.get(filePath);
//			Files.createFile(path);
			
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(filePath);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(person);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		    
		    FileInputStream fileInputStream = new FileInputStream(filePath);
		    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    
		    Person p2 = (Person) objectInputStream.readObject();
		    objectInputStream.close(); 
		    
		    System.out.println(p2.getAge());
		    System.out.println(p2.getName());
		    
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}


}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "India";
    private int age;
    private String name;
    transient int height;
    
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}

}
