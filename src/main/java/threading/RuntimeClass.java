package threading;

import java.io.IOException;

public class RuntimeClass {

	public static void main(String[] args) throws IOException {
		/*
		Runtime.getRuntime().exec("notepad");// will open a new notepad
		Runtime.getRuntime().exec("shutdown -s -t 0"); //shutdown
		Runtime.getRuntime().exec("c:\\Windows\\System32\\shutdown -s -t 0");
		Runtime.getRuntime().exec("shutdown -r -t 0");  //restart
		*/
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println("Total Memory: "+Runtime.getRuntime().totalMemory());  
	}

}
