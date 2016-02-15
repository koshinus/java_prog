package calculator.datatypes.polinomial;
import calculator.OperationNotSupportedException;

public class PolinomialElement {
	
	private Integer power;
	private Double factor;
	
	/*PolinomialElement(double fac, int pow) 
		throws OperationNotSupportedException {
			if(pow < 0) throw new OperationNotSupportedException("^(-n)");
				else {
					factor = fac;
					power = pow;
				}
	}*/
	
	PolinomialElement(Double fac, Integer pow) 
			throws OperationNotSupportedException {
				if(pow < 0) throw new OperationNotSupportedException("^(-n)");
					else {
						factor = fac;
						power = pow;
					}
		}
	
	Double getFactor() {
		return factor;
	}
	
	Integer getPower() {
		return power;
	}
	
}
