package calculator.datatypes.polinomial;

import java.util.ArrayList;

import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;

public class PolinomialTest {
	
	public String [] doubleToSingle(String [][] ar) {
		int size = 0;
		for(String [] st : ar) size+=st.length;
		String [] res = new String[size];
		int iter = 0;
		for(int i = 0; i < ar.length; i++)
			for(int j = 0; j < ar[i].length; j++) {
				res[iter] = ar[i][j];
				iter++;
		}
		return res;
	}

	public static void main(String[] args) throws ParseValueException, OperationNotSupportedException {
		String str = "-1.7x^5+3.9x^3+-7.7x^1+-1.0x^0";
		/*String[] parts = str.split("\\+");
		String [][] res1 = new String [parts.length] [2];
		for(int i = 0; i < parts.length; i++) { 
				String [] temp = parts[i].split("x\\^"); 
				res1[i][0] = temp[0];
				res1[i][1] = temp[1]; 
		}
		PolinomialTest pars = new PolinomialTest();
		String [] res2 = (String[])pars.doubleToSingle(res1);
		for(String st: res2) System.out.print(st);*/
		ArrayList <PolinomialElement> poli = new ArrayList <PolinomialElement> ();
		try {
			poli.add(new PolinomialElement(3.9, 3));
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
		try {
			poli.add(new PolinomialElement(0.0, 2));
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
		try {
			poli.add(new PolinomialElement(1.0, 0));
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
		PolinomialValueParser pars = new PolinomialValueParser();
		
		PolinomialValue val1 = (PolinomialValue)pars.parse(str);

		PolinomialValue val2 = new PolinomialValue (5, poli);
		
		String str1 = "-1.7x^5+-0.0x^4+3.9x^3+0.0x^2+-7.7x^1+-1.0x^0+1.7x^5+-0.0x^4+7.9x^3+0.0x^2+-4.7x^1+1.0x^0";

		PolinomialValue val7 = (PolinomialValue)pars.parse(str1);
		
		try {
			PolinomialValue val8 = (PolinomialValue)val7.castToNormal();
			System.out.println(val8.toString());
			} catch (OperationNotSupportedException e) {
				e.printStackTrace();
			}
		try {
		PolinomialValue val3 = (PolinomialValue)val1.add(val2);
		System.out.println(val3.toString());
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
			
		try {
		PolinomialValue val4 = (PolinomialValue)val1.sub(val2);
		System.out.println(val4.toString());
		} catch (OperationNotSupportedException e1) {
			e1.printStackTrace();
		}

		try {
		PolinomialValue val5 = (PolinomialValue)val1.mul(val2);
		System.out.println(val5.toString());
		} catch (OperationNotSupportedException e2) {
			e2.printStackTrace();
		}
		
		try {
			PolinomialValue val6 = (PolinomialValue)val1.div(val2);
			System.out.println(val6.toString());
			} catch (OperationNotSupportedException e3) {
				e3.printStackTrace();
			}
			catch (DivisionByZeroException e4) {
				e4.printStackTrace();
			}
				/*//String str1 = ""; 
		//for(int i = 0; i < str.length(); i++) 
			//if( (str.charAt(i)!='[') && (str.charAt(i)!=']') ) str1+=str.charAt(i);
		//System.out.println(str1);
		//String [] ar = str1.split(", ");
		//for(String st: ar) System.out.print(st);
		System.out.println(vec1.toString());
		//PolinomialValue vec2 = new PolinomialValue(new double [] {1.2, 2.4, 2.8});
		//System.out.println(vec1.add(vec2).toString());*/
	}

}
