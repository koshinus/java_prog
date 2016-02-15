package string_work;

import java.io.*;
public class string_work 
{
	  public static String readLine() 
	  {
	    try 
	    {
	      return new BufferedReader(
	        new InputStreamReader(System.in)).readLine();
	    } 
	    catch (IOException e) 
	    {
	      return new String();
	    }
	   }

	  public static void main(String [] args)
	  {
	    System.out.println("Enter any text:");
	    String str = readLine();
	    for(int i = str.length()-1; i > -1; i--) System.out.print(str.charAt(i));
	  }
}
