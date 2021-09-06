package commontests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) {
	    readFile();
	    readUsingScanner();
	}
	
	public static void readFile() {
		File file = new File("C:\\Users\\vinay\\Desktop\\temp.txt"); 
	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st; 
		    while ((st = br.readLine()) != null) 
		    	System.out.println(st); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readUsingScanner() {
		File file = new File("C:\\Users\\vinay\\Desktop\\temp.txt"); 
	    Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine()); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
