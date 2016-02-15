package recoder;

import java.io.*;

public class file_recoder 
{
	
	public static void recode(String input, String output, String in_coding, String out_coding) 
			throws IOException
	{
		try
		{
	    	BufferedReader reader = 
	    			new BufferedReader(
	    					new InputStreamReader(
	    							new FileInputStream(input),in_coding));
	    	BufferedWriter writer = 
	    			new BufferedWriter(
	    					new OutputStreamWriter(
	    							new FileOutputStream(output),out_coding));
	    	try
	    	{
	    		int ch;
	    		while( (ch = reader.read()) >= 0) writer.write(ch);
	    	}
	    	finally 
	    	{
	    		reader.close();
	    		writer.close();
	    	}
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Файл не найден/не может быть использован "+e.getLocalizedMessage());
		}	
		catch(UnsupportedEncodingException e) 
		{
			System.out.println("Неподдерживаемая кодировка "+e.getLocalizedMessage());
		}	
		catch(IOException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		recode("input1.txt", "output1.txt", "UTF-8", "Unicode");
		recode("input2.txt", "output2.txt", "cp1251", "UTF-8");
	}

}
