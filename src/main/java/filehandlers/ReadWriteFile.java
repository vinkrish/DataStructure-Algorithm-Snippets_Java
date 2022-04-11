package filehandlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ReadWriteFile {

	public static void main(String[] args) throws IOException {
		
		readWrite();
		
		readWriteBeforeJava8();
		
		readWriteJava8();
		
		readWriteUsingCommonsIO();

	}
	
	/*
	 * If memory allows, simply read it and write it in one go.
	 */
	public static void readWrite() throws IOException{
		Path path = Paths.get("src/main/resources/hamlet.txt");
	    byte[] buffer = Files.readAllBytes(path);

	    File targetFile = new File("src/main/resources/hamlet_copy.txt");
	    OutputStream outStream = new FileOutputStream(targetFile);;
	    outStream.write(buffer);
		IOUtils.closeQuietly(outStream);
	}
	
	/*
	 * keep reading until we reach the end of the stream
	 */
	public static void readWriteBeforeJava8() throws IOException {
		InputStream initialStream = new FileInputStream(new File("src/main/resources/hamlet.txt"));
	    File targetFile = new File("src/main/resources/hamlet_copy.txt");
	    OutputStream outStream = new FileOutputStream(targetFile);

	    byte[] buffer = new byte[8 * 1024];
	    int bytesRead;
	    while ((bytesRead = initialStream.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	    }
	    IOUtils.closeQuietly(initialStream);
	    IOUtils.closeQuietly(outStream);
	}
	
	public static void readWriteJava8() throws IOException {
		InputStream initialStream = new FileInputStream(new File("src/main/resources/hamlet.txt"));
	    File targetFile = new File("src/main/resources/hamlet_copy.txt");

	    java.nio.file.Files.copy(
	      initialStream, 
	      targetFile.toPath(), 
	      StandardCopyOption.REPLACE_EXISTING);

	    IOUtils.closeQuietly(initialStream);
	}
	
	public static void readWriteUsingCommonsIO() throws IOException {
		InputStream initialStream = FileUtils.openInputStream(new File("src/main/resources/hamlet.txt"));
	    File targetFile = new File("src/main/resources/hamlet_copy.txt");
	    
	    FileUtils.copyInputStreamToFile(initialStream, targetFile);
	}

}
