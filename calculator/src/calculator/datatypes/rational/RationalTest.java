package calculator.datatypes.rational;

import calculator.ParseValueException;

//import calculator.AbstractValue;
//import calculator.AbstractValueParser;
//import calculator.datatypes.rational.RationalValueParser;

public class RationalTest {

	public static void main(String[] args) 
		throws ParseValueException {
		String str = "6%0";
		System.out.println(str.split("%")[0]);
		System.out.println(Integer.parseInt(str.split("%")[0]));
		//RationalValueParser pars = new RationalValueParser();
		//RationalValue rat = (RationalValue)pars.parse(str);
		
	}

}
