package calculator.datatypes.vectors;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class VectorValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		try {
			String str = value.substring(1, value.length()-1); 
			String[] parts = str.split(",");
			double[] vec = new double[parts.length];
			for(int n = 0; n < parts.length; n++) 
				vec[n] = Double.parseDouble(parts[n]);
			return new VectorValue(vec);
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "вектора";
	}
	
}
