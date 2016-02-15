package calculator.console;

import java.util.Scanner;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.polinomial.PolinomialValueParser;
import calculator.datatypes.rational.RationalValueParser;
import calculator.datatypes.real.RealValueParser;
import calculator.datatypes.vectors.VectorValueParser;

public class Program {

	private final Scanner scanner;

	private final Calculator calc;

	private AbstractValueParser[] valueParsers;

	public Program() {
		scanner = new Scanner(System.in);
		valueParsers = new AbstractValueParser[] { 
				new IntegerValueParser(),
				new RealValueParser(),  
				new ComplexValueParser(),
				new RationalValueParser(),
				new VectorValueParser(),
				new PolinomialValueParser()
				};
		AbstractValueParser parser = inputValueParser();
		System.out.println("Работаем с типом '" + parser.getDatatypeName()
				+ "'");
		calc = new Calculator(parser);
	}

	private AbstractValueParser inputValueParser() {
		showChoises();
		int choise = scanner.nextInt();
		if (choise >= 1 && choise <= valueParsers.length) {
			System.out.println("Пример корректного ввода выбранного типа данных: ");
			switch(choise) {
			case 1 : System.out.println("3, -9"); break;
			case 2 : System.out.println("3.0, -5.0"); break;
			case 3 : System.out.println("3.0+-4.3i, 0.0+3.2i, 0.0+0.0i"); break;
			case 4 : System.out.println("3%6, 4%5"); break;
			case 5 : System.out.println("[1.8,3.4,2.6,2.8]"); break;
			case 6 : System.out.println("-1.7x^5+3.9x^3+0.0x^2+1.0x^0"); break;
			}
			return valueParsers[choise - 1];
		}
		else {
			System.out.println("Неверный выбор!");
			return inputValueParser();
		}
	}

	private void showChoises() {
		System.out.println("Вам нужно выбрать тип данных. Возможные варианты:");
		for (int i = 0; i < valueParsers.length; i++)
			System.out.println("  " + (i + 1) + ". "
					+ valueParsers[i].getDatatypeName());
	}

	public static void main(String args[]) {
		try {
			Program instance = new Program();
			instance.run(args);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private void run(String[] args) {
		while (true) {
			String arg1 = scanner.next();
			if (arg1.equals("exit"))
				break;
			String op = scanner.next();
			String arg2 = scanner.next();
			try {
				System.out.println(" = " + calc.calculate(arg1, op, arg2));

			} catch (Exception exception) {
				System.out.println(exception.getLocalizedMessage());
			}
		}
	}

}
