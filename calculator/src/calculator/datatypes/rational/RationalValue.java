package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class RationalValue extends AbstractValue
{
	private final long numerator;
	private final long denominator;
	
	public RationalValue(long num, long den)
			throws DivisionByZeroException {
		if (den == 0)
			throw new DivisionByZeroException();
		else if(den < 0)
			{
			numerator = -num;
			denominator = -den;
			}
				else 
				{
					numerator = num;
					denominator = den;
				}
	}
	
	private RationalValue castToTheCorrect()
			throws DivisionByZeroException {
		long a = numerator;
		long b = denominator;
		long GCD;
		while(b!=0 && a!=0)
		{
			if(a>b) a%=b;
			else b%=a; 
		}
		GCD = a+b;
		return new RationalValue(numerator/GCD, denominator/GCD);
	}
	
	public AbstractValue add(AbstractValue operand) 
			throws DivisionByZeroException {
		RationalValue rat = (RationalValue)operand;
		return new
			RationalValue
			(
			numerator*rat.denominator+rat.numerator*denominator,
			rat.denominator*denominator
			).castToTheCorrect();
	}
	
	public AbstractValue sub(AbstractValue operand)
			throws DivisionByZeroException {
		RationalValue rat = (RationalValue)operand;
		return new
			RationalValue
			(
			numerator*rat.denominator-rat.numerator*denominator,
			rat.denominator*denominator
			).castToTheCorrect();
	}
	
	public AbstractValue mul(AbstractValue operand) 
			throws DivisionByZeroException {
		RationalValue rat = (RationalValue)operand;
		return new
			RationalValue
			(
			numerator*rat.numerator,
			rat.denominator*denominator
			).castToTheCorrect();
	}
	
	public AbstractValue div(AbstractValue operand) 
			throws DivisionByZeroException {
		RationalValue rat = (RationalValue)operand;
		return new
			RationalValue
			(
			numerator*rat.denominator,
			rat.numerator*denominator
			).castToTheCorrect();
	}
	
	public String toString() {
		return Long.toString(numerator)+"%"+Long.toString(denominator);
	}
}
