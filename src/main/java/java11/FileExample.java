package java11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) {
        try {
            Path path = Paths.get("example.txt");

            // Write content to the file
            Files.writeString(path, "Hello, Java 11!");

            // Read content from the file
            String content = Files.readString(path);
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();  // Handle exception for file I/O
        }
	}
}

/*
	It is common to store application configurations, JSON, XML, or properties files as text. Using Files.readString(), 
	you can easily load these configurations into memory and parse them as needed.
*/