package reverse_polish_notation;

import java.util.Scanner;
import java.util.Stack;

public class RPN {
	
	int priorety(Character c)
	{
		switch(c)
		{
			case '(' : return 0;
			case ')' : return 0;
			case '+' : return 1;
			case '-' : return 1;
			case '*' : return 2;
			case '/' : return 2;
			case '^' : return 3;
			default  : return 0;
		}
	}

	String toReversePolishNotation()
	{
		String res = "";
		Stack <Character> operators_stack = new Stack <Character>();
		System.out.println("Enter string, which you want to transform: ");
		Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.replace(" ", "");
		for(int i = 0; i < str.length(); i++)
		{
			switch(priorety(str.charAt(i)))
			{
				case 0:
					switch(str.charAt(i))
					{
						case '(': 
							operators_stack.push(str.charAt(i));
							break;
						case ')': 
							while(operators_stack.peek() != '(')
								{
									res += operators_stack.peek();
									operators_stack.pop();
								}
								operators_stack.pop();
							break;
						default  : res += str.charAt(i);
						break;
					}
					break;
				default:
					while( !operators_stack.empty() && 
							(priorety(str.charAt(i)) <= priorety(operators_stack.peek())) )
					{
						res += operators_stack.peek();
						operators_stack.pop();
					}
					operators_stack.push(str.charAt(i));
					break;
			}
		}
		while( !operators_stack.empty() ) 
		{
			res += operators_stack.peek();
			operators_stack.pop();
		}
	return res;
	}
	
	Double calculateInPolishNotation(String input)
	{
		Double res = 0.0;
		Double operand1, operand2;
		Stack <Character> number_stack = new Stack <Character>();
		for(int i = 0; i < input.length(); i++)
		{
			if(Character.isDigit(input.charAt(i))) number_stack.push(input.charAt(i));
			else switch(input.charAt(i))
			{
				case '+': 
				{
					if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
					else 
					{
						operand1 = Double.parseDouble(""+number_stack.peek());
						number_stack.pop();
						if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
						else
						{
							operand2 = Double.parseDouble(""+number_stack.peek());
							number_stack.pop();
							res += operand1 + operand2;
							break;
						}
					}
				}
				case '-': 
				{
					if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
					else 
					{
						operand1 = Double.parseDouble(""+number_stack.peek());
						number_stack.pop();
						if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
						else
						{
							operand2 = Double.parseDouble(""+number_stack.peek());
							number_stack.pop();
							res += operand1 + operand2;
							break;
						}
					}
				}
				case '/': 
				{
					if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
					else 
					{
						operand1 = Double.parseDouble(""+number_stack.peek());
						number_stack.pop();
						if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
						else
						{
							operand2 = Double.parseDouble(""+number_stack.peek());
							number_stack.pop();
							res += operand1 + operand2;
							break;
						}
					}
				}
				case '*': 
				{
					if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
					else 
					{
						operand1 = Double.parseDouble(""+number_stack.peek());
						number_stack.pop();
						if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
						else
						{
							operand2 = Double.parseDouble(""+number_stack.peek());
							number_stack.pop();
							res += operand1 + operand2;
							break;
						}
					}
				}
				case '^': 
				{
					if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
					else 
					{
						operand1 = Double.parseDouble(""+number_stack.peek());
						number_stack.pop();
						if(number_stack.isEmpty()) return Double.POSITIVE_INFINITY;
						else
						{
							operand2 = Double.parseDouble(""+number_stack.peek());
							number_stack.pop();
							res += operand1 + operand2;
							break;
						}
					}
				}
			}
		}
		return res;
	}

}
