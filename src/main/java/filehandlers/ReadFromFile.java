package filehandlers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ReadFromFile {

	public static void main(String[] args) {
		
		readASmallFile();
		readLargeFile();
		readLargeFileWithFileChannel();
		readLineATimeFromFile();
		readWithDataInputStream();
	    readUsingScanner();
	    readUTFencodedFile();
	    readCharATimeFromFile();
	    readURLStream();
		
		new ReadFromFile().readFromClasspath();
		new ReadFromFile().readFromClasspathUsingClassLoader();
		new ReadFromFile().readUsingCommonsIO();
		new ReadFromFile().readUsingIOUtils();
	}
	
	private static String readFromInputStream(InputStream inputStream) throws IOException {
	    StringBuilder resultStringBuilder = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            resultStringBuilder.append(line).append("\n");
	        }
	    }
	  return resultStringBuilder.toString();
	}
	
	public static void readASmallFile() {
		Path path = Paths.get("src/main/resources/fileTest.txt");
		try {
			List<String> lines = Files.readAllLines(path);
			lines.forEach((line)->System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readLargeFile() {
//		Path path = Paths.get("src/main/resources/hamlet.txt");
		Path path = FileSystems.getDefault().getPath("src/main/resources", "hamlet.txt");
		try (BufferedReader reader = Files.newBufferedReader(path)){
		    String line;
		    while ((line = reader.readLine()) != null) 
		    	System.out.println(line); 
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readLargeFileWithFileChannel() {
		String file = "src/main/resources/hamlet.txt";
		try {
			RandomAccessFile reader = new RandomAccessFile(file, "r");
		    FileChannel channel = reader.getChannel();

		    int bufferSize = 1024 * 175;
		    if (bufferSize > channel.size()) {
		        bufferSize = (int) channel.size();
		    }
		    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
		    channel.read(buff);
		    buff.flip();
		    System.out.println(new String(buff.array()));
		    channel.close();
		    reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readLineATimeFromFile() {
		File file = new File("src/main/resources/hamlet.txt");
//		String file = "src/main/resources/hamlet.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
		    while ((line = br.readLine()) != null) 
		    	System.out.println(line); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readCharATimeFromFile() {
		File file = new File("src/main/resources/hamlet.txt"); 
		try(FileReader fileReader = new FileReader(file)) {
			int i;    
			while((i = fileReader.read()) != -1) {
				System.out.print((char)i);    
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readWithDataInputStream() {
		String file ="src/main/resources/fileTest.txt";
		String result = null;
		try(DataInputStream reader = new DataInputStream(new FileInputStream(file))) {
			int nBytesToRead = reader.available();
		    if(nBytesToRead > 0) {
		        byte[] bytes = new byte[nBytesToRead];
		        reader.read(bytes);
		        result = new String(bytes);
		    }
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
	
	public static void readUTFencodedFile() {
		String file = "src/main/resources/kannada.txt";
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));) {
			String currentLine = reader.readLine();
			System.out.println(currentLine);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 	sc.useDelimiter(" ");
		sc.hasNext();
		sc.next();
	 */
	public static void readUsingScanner() {
		File file = new File("src/main/resources/hamlet.txt"); 
	    Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) 
			      System.out.println(sc.nextLine()); 
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromClasspath() {
		Class<ReadFromFile> clazz = ReadFromFile.class;
	    try (InputStream inputStream = clazz.getResourceAsStream("/fileTest.txt")) {
			String data = readFromInputStream(inputStream);
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFromClasspathUsingClassLoader() {
		ClassLoader classLoader = getClass().getClassLoader();
	    try (InputStream inputStream = classLoader.getResourceAsStream("fileTest.txt")) {
			String data = readFromInputStream(inputStream);
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readUsingCommonsIO() {
		ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource("fileTest.txt").getFile());
	    String data = null;
		try {
			data = FileUtils.readFileToString(file, "UTF-8");
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readUsingIOUtils() {
	    try (FileInputStream fis = new FileInputStream("src/main/resources/kannada.txt")) {
			String data = IOUtils.toString(fis, "UTF-8");
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readURLStream() {
		URL urlObject;
		try {
			urlObject = new URL("https://www.google.com/");
			URLConnection urlConnection = urlObject.openConnection();
		    InputStream inputStream = urlConnection.getInputStream();
		    String data = readFromInputStream(inputStream);
		    System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
