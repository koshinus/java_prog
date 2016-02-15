package symbols_statistic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class symbols_statistic 
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
	public static int check(char arg)
	{
		switch(arg)
		{
			case 'у': return 0;
			case 'е': return 1;
			case 'ы': return 2;
			case 'а': return 3;
			case 'о': return 4;
			case 'э': return 5;
			case 'я': return 6;
			case 'и': return 7;
			case 'ю': return 8;
		}
		return 9;
	}
	  public static void main(String [] args)
	  {
	    System.out.println("Введите строку на русском:");
	    String str = readLine();
	    int [] ar = {0,0,0,0,0,0,0,0,0};
	    for(int i = 0; i < str.length(); i++) 
	    	{
	    		if(check(str.charAt(i)) == 9) continue;
	    			else 
	    			{
	    				ar[check(str.charAt(i))]++;
	    			}
	    	}
	    for(int i = 0; i < 9; i++)
	    {
	    	System.out.print(i+1);
	    	System.out.print("-ая гласная (если смотреть по русской раскладке сверху-вниз, слева-направо) встречается ");
	    	System.out.print(ar[i]);
	    	System.out.print(" раз.\n");
	    }
	  }
}
