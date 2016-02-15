package calculator.datatypes.polinomial;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.polinomial.PolinomialElement;

import java.util.ArrayList;

public class PolinomialValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String[] parts = value.split("\\+");
			String [][] res = new String [parts.length] [2];
			for(int i = 0; i < parts.length; i++) { 
					String [] temp = parts[i].split("x\\^"); 
					res[i][0] = temp[0];
					res[i][1] = temp[1]; 
			}
			//PolinomialValueParser pars = new PolinomialValueParser();
			//String [] res2 = (String[])pars.doubleToSingle(res1);
			ArrayList <PolinomialElement> pol = 
					new ArrayList <PolinomialElement>(res.length);
			for(int i = 0; i < res.length; i++) 
				pol.add(new PolinomialElement(
						Double.parseDouble(res[i][0]), 
						Integer.parseInt(res[i][1])));
			return new PolinomialValue(pol.get(0).getPower(),pol);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
		catch (OperationNotSupportedException exception) {
			throw new ParseValueException("У многочлена не может быть отрицательных степеней!");
		}
	}
	
	public String [] doubleToSingle(String [][] ar) {
		int size = 0;
		for(String [] st : ar) size+=st.length;
		String [] res = new String[size];
		int iter = 0;
		for(int i = 0; i < ar.length; i++) {
			for(int j = 0; j < ar[i].length; j++) 
				res[iter] = ar[i][j];
				iter++;
		}
		return res;
	}

	public String getDatatypeName() {
		return "многочлены";
	}
	
}