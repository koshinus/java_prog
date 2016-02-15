package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class ComplexValue extends AbstractValue
{
	private final double Re;
	private	final double Im;
	
	public ComplexValue(double x, double y) {
		super();
		Re=x;
		Im=y;
	}
	
	public ComplexValue(ComplexValue c) {
		
		super();
		Re=c.Re;
		Im=c.Im;
	}
	
	public AbstractValue add(AbstractValue operand) {
		
		return new ComplexValue(Re+((ComplexValue)operand).Re,
								Im+((ComplexValue)operand).Im);
	}
	
	public AbstractValue sub(AbstractValue operand) {
		
		return new ComplexValue(Re-((ComplexValue)operand).Re,
								Im-((ComplexValue)operand).Im);
	}
		
	public AbstractValue mul(AbstractValue operand) {
		
		return new ComplexValue(
				Re*((ComplexValue)operand).Re-Im*((ComplexValue)operand).Im,
				Re*((ComplexValue)operand).Im+Im*((ComplexValue)operand).Re);
	}
		
	public AbstractValue div(AbstractValue operand) 
		throws DivisionByZeroException {
			ComplexValue comp = (ComplexValue)operand;
			if( (comp.Re == 0.0) && (comp.Im == 0.0))
				throw new DivisionByZeroException();
			
			else return new ComplexValue(
				(Re*comp.Re+Im*comp.Im)/(comp.Re*comp.Re+comp.Im*comp.Im),
				(Re*comp.Im-Im*comp.Re)/(comp.Re*comp.Re+comp.Im*comp.Im));
			}
	
	public String toString() {
		return Double.toString(Re)+"+"+Double.toString(Im)+"i";
	}
}
/*
public ComplexValue add(double d)
{
	return new ComplexValue(Re+d,Im);
}

public ComplexValue mul(double d)
	{
		return new ComplexValue(Re*d,Im*d);
	}

public ComplexValue sub(double d)
{
	return new ComplexValue(Re-d,Im);
}

public ComplexValue div(double d)
{
	return new ComplexValue(Re/d,Im/d);
}

public AbstractValue conjugate()
	{
		return new ComplexValue ((ComplexValue)this).Re,-Im);
	}
*/