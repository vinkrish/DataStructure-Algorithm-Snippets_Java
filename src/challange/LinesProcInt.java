package challange;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class LinesProcInt {
    public static int processData(ArrayList<String> array) {
    	
    	/*Integer a = null;
    	int b = a;
    	System.out.println(b);*/
    	
    	/*try {
    	    int c = 1/0;
    	} catch (Exception e) {
    	    System.out.println("E");
    	} finally {
    	    System.out.println("F");
    	}*/
    	
    	
    	
    	HashMap<String, String> softwareMap = new HashMap<>();
    	HashMap<String, Integer> softwareVersionCountMap = new HashMap<>();
    	
    	for(String s: array) {
    		String[] splitArray = s.split(",");
    		String softwareName = splitArray[2];
    		String softwareVersion = splitArray[3].trim();
    		
    		if(softwareMap.containsKey(softwareName)) {
    			
    			if(isV2Greater(softwareMap.get(softwareName), softwareVersion)) {
    				softwareMap.put(softwareName, softwareVersion);
        			softwareVersionCountMap.put(softwareVersion, 1);
    			} else {
        			if(softwareVersionCountMap.containsKey(softwareVersion)) {
        				int plusOneVersion = softwareVersionCountMap.get(softwareVersion) + 1;
            			softwareVersionCountMap.put(softwareVersion, plusOneVersion);
        			} else {
        				softwareVersionCountMap.put(softwareVersion, 1);
        			}
    			}
    		} else {
    			softwareMap.put(softwareName, softwareVersion);
    			softwareVersionCountMap.put(softwareVersion, 1);
    		}
    	
    	}
    	
    	int notHavingRecentVersionCount = 0;
    	for (Map.Entry<String, Integer> entry : softwareVersionCountMap.entrySet()) {
    		if(entry.getValue() >= 2) {
    			notHavingRecentVersionCount += 1;
    		}
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
    	
        return notHavingRecentVersionCount;
    }
    
    private static boolean isV2Greater(String V1, String V2) {
    	String[] v1 = V1.split("\\.");
    	String[] v2 = V2.split("\\.");

    	if (Arrays.equals(v1, v2))
    	    return false;
    	
    	boolean V2Greater = false;
    	for (int pos = 0; pos < v1.length; pos++) {
    	    if (Integer.parseInt(v1[pos]) < Integer.parseInt(v2[pos])) {
    	        V2Greater =  true;
    	    }
    	}
    	return V2Greater;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
        	File file = new File("input/input1.txt");
            Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            File outputFile = new File("input/output.txt");
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
    
    public class C {
	    public float m(float x, float y) throws IOException {
	        return 0;
	    }
	}

	public class D extends C {
	    @Override
	    //public float m(float x, float x) throws Exception {return 0;}
	    public float m(float x1, float x2) {return 0;}
	}
}
