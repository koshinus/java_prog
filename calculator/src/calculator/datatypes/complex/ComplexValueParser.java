package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {
	public AbstractValue parse(String value) throws ParseValueException {
		try {
			return new ComplexValue(Double.parseDouble(value.split("\\+")[0]),
									Double.parseDouble(value.split("\\+")[1].replace("i", ""))
									);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "комплексные числа";
	}
}
