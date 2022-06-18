package java13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.FileSystem;
import java.util.Collections;
import java.util.Map;

public class FileSystemExample {
    public static void main(String[] args) {
        // Path to the ZIP file
        Path zipFilePath = Paths.get("src/main/resources/archive.zip");
        
        // Create a map to configure the file system (we're working with a ZIP file)
        Map<String, String> env = Collections.singletonMap("create", "true");
        
        // Use FileSystems.newFileSystem() to open the ZIP file as a file system
        try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipFilePath, env)) {
        	// Walk through all the files in the ZIP archive
            Files.walk(zipFileSystem.getPath("/"))
                .filter(Files::isRegularFile)  // Filter only regular files (skip directories)
                .forEach(fileInZip -> {
                    // Print the file name
                    System.out.println("Reading file: " + fileInZip.getFileName());

                    // Use BufferedReader to read the content of each file
                    try (BufferedReader reader = Files.newBufferedReader(fileInZip)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);  // Print each line from the file
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
