package recursion;

public class TowersOfHanoi
{

  public static void main(String[] args)
  {
    // Read number of disks, n
    System.out.println("Enter number of disks");
    int n = MyInput.readInt();

    // Find the solution recursively
    System.out.println("The moves are:");
    moveDisks(n, 'A', 'B', 'C');
  }

  // The method for finding the solution to move n disks
  // from fromTower to toTower with auxTower
  public static void moveDisks(int n, char fromTower,
    char toTower, char auxTower)
  {
    if (n==1) // Stopping condition
      System.out.println("Move disk " + n + " from " +
        fromTower+" to " + toTower);
    else
    {
      moveDisks(n-1, fromTower, auxTower, toTower);
      System.out.println("Move disk " + n + " from " +
        fromTower + " to " + toTower);
      moveDisks(n-1, auxTower, toTower, fromTower);
    }
  }
}


// a class for reading various types from the keyboard (System.in) 
class MyInput
{
    public static String readString()
    {
        String string = "";
        java.io.BufferedReader bufferedReader = 
           new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        try
        {
            string = bufferedReader.readLine();
        }
        catch (java.io.IOException ex)
        {
            throw new RuntimeException(ex);
        }
        return string;
    }

    public static int readInt()
    {
        return Integer.parseInt(readString());
    }

    public static double readDouble()
    {
        return Double.parseDouble(readString());
    }

    // test all the methods of this class
    public static void main(String[] args)
    {
        System.out.println("Testing 'readString()'");
        System.out.print("Input your string : ");
        System.out.println("Your string was '" + readString() + "'");
        System.out.println("\nTesting 'readInt()'");
        System.out.print("Input your int : ");
        System.out.println("Your int was '" + readInt() + "'");
        System.out.println("\nTesting 'readDouble()'");
        System.out.print("Input your double : ");
        System.out.println("Your double was '" + readDouble() + "'");
    }
}
