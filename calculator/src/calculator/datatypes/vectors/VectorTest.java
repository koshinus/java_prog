package calculator.datatypes.vectors;

import calculator.ParseValueException;

public class VectorTest {

	public static void main(String[] args) 
			throws ParseValueException {
		int j = 5;
		j = ++j + ++j;
		System.out.println(j);
		String str = "[1,[ 2, 3, 4]";
		String str1 = ""; 
		for(int i = 0; i < str.length(); i++) 
			if( (str.charAt(i)!='[') && (str.charAt(i)!=']') ) str1+=str.charAt(i);
		System.out.println(str1);
		//String [] ar = str1.split(", ");
		//for(String st: ar) System.out.print(st);
		VectorValueParser pars = new VectorValueParser();
		VectorValue vec1 = (VectorValue)pars.parse(str);
		VectorValue vec2 = new VectorValue(new double [] {1.2, 2.4, 2.8});
		System.out.println(vec1.add(vec2).toString());
	}

}
