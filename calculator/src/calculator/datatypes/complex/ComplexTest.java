package calculator.datatypes.complex;

import calculator.ParseValueException;
//import calculator.datatypes.rational.RationalValueParser;

public class ComplexTest {

	public static void main(String[] args) 
		throws ParseValueException {
			String str = "6.0+-6.8i";
			System.out.println(Double.parseDouble(str.split("\\+")[1].replace("i", "")));
			//RationalValueParser pars = new RationalValueParser();
			
	}

}
