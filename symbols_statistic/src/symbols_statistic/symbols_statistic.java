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
			case '�': return 0;
			case '�': return 1;
			case '�': return 2;
			case '�': return 3;
			case '�': return 4;
			case '�': return 5;
			case '�': return 6;
			case '�': return 7;
			case '�': return 8;
		}
		return 9;
	}
	  public static void main(String [] args)
	  {
	    System.out.println("������� ������ �� �������:");
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
	    	System.out.print("-�� ������� (���� �������� �� ������� ��������� ������-����, �����-�������) ����������� ");
	    	System.out.print(ar[i]);
	    	System.out.print(" ���.\n");
	    }
	  }
}
