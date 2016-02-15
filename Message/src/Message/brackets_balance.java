package Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class brackets_balance 
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
	
	public static Character brackets(Character bracket)
	{
		switch(bracket)
		{
			case '(' : return ')';
			case '[' : return ']';
			case '{' : return '}';
			case '<' : return '>';
		}
		return 'a';
	}
	
	public static int correctBrackets(String str)
	{	
		Stack <Character> brackets = new Stack();
		Stack <Integer> positions = new Stack();
		int i=0;
		
		while(i<str.length())
		{
		char symbol = str.charAt(i);
		i++;
		if( symbol=='(' || symbol=='[' || symbol=='{' || symbol=='<' )
		{
			brackets.push( brackets(symbol) ); //Случай когда мы встречаем открывающую скобку
			positions.push(i);
			continue;
		}
			else if(symbol==')' || symbol==']' || symbol=='}' || symbol=='>') //Случай когда встречаем закрывающую скобку
			{
				if(brackets.empty()) return i; //Случай когда мы встретили закрывающуюся скобку а открывающихся не было
					else if( symbol==brackets.peek() ) 
					{
						brackets.pop();
						positions.pop();
						continue;
					}
						else 
						{
							return positions.peek();
						}
				}
		}
		if(positions.empty()) return i+1; //Случай, когда не все скобки закрыты
			else return positions.peek();
	}
	
	public static void main(String [] args)
	  {
	    System.out.println("Введите строку:");
	    String str = readLine();
	    if(correctBrackets(str) == str.length()+1) System.out.println("Все скобки расставлены верно.");
	    	else 
	    	{
	    		System.out.print("Ошибка на ");
	    		System.out.print(correctBrackets(str)+1);
	    		System.out.print(" месте.");
	    	}
	  }
}
