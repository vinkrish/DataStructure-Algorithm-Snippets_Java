package challange;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) throws Exception {
		
		/*
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(input.hasNextLine()) {
			sb.append(input.nextLine()).append("\n");
		}
		input.close();
		*/
		
		try {
			File file = new File("input/input.txt");
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler();
	         //InputSource is = new InputSource(sb.toString());
	         saxParser.parse(file, userhandler);
	         //saxParser.parse(getFileInCurrentPackage(), userhandler);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	}
	
	private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }
	
	static String getFileInCurrentPackage() throws IOException{
		
		InputStream fileIs = SAXParserDemo.class
				.getResourceAsStream("input.txt");
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fileIs))) {
			StringBuilder sb = new StringBuilder();
			String line;
		    while ((line = br.readLine()) != null) {
		    	sb.append(line).append("\n");
		    }
		    return sb.toString();
		}
	}
	
	static class UserHandler extends DefaultHandler {

		   boolean bFirstName = false;
		   boolean bLastName = false;
		   boolean bNickName = false;
		   boolean bMarks = false;

		   @Override
		   public void startElement(
		      String uri, String localName, String qName, Attributes attributes)
		      throws SAXException {
		      
		      if (qName.equalsIgnoreCase("student")) {
		         String rollNo = attributes.getValue("rollno");
		         System.out.println("Roll No : " + rollNo);
		      } else if (qName.equalsIgnoreCase("firstname")) {
		         bFirstName = true;
		      } else if (qName.equalsIgnoreCase("lastname")) {
		         bLastName = true;
		      } else if (qName.equalsIgnoreCase("nickname")) {
		         bNickName = true;
		      }
		      else if (qName.equalsIgnoreCase("marks")) {
		         bMarks = true;
		      }
		   }

		   @Override
		   public void endElement(String uri, 
		      String localName, String qName) throws SAXException {
		      
		      if (qName.equalsIgnoreCase("student")) {
		         System.out.println("");
		      }
		   }

		   @Override
		   public void characters(char ch[], int start, int length) throws SAXException {

		      if (bFirstName) {
		         System.out.println("First Name: " + new String(ch, start, length));
		         bFirstName = false;
		      } else if (bLastName) {
		         System.out.println("Last Name: " + new String(ch, start, length));
		         bLastName = false;
		      } else if (bNickName) {
		         System.out.println("Nick Name: " + new String(ch, start, length));
		         bNickName = false;
		      } else if (bMarks) {
		         System.out.println("Marks: " + new String(ch, start, length));
		         bMarks = false;
		      }
		   }
		}

}
