package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.DivisionByZeroException;
import calculator.ParseValueException;

public class RationalValueParser implements AbstractValueParser {
	public AbstractValue parse(String value) throws ParseValueException {
		try {
			return new RationalValue(Long.parseLong(value.split("%")[0]),
									Long.parseLong(value.split("%")[1]));
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
		catch (DivisionByZeroException exception) {
			throw new ParseValueException("Знаменатель должен быть строго положительным!");
		}
	}
	
	public String getDatatypeName() {
		return "рациональные числа";
	}
}
