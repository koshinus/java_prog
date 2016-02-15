package calculator.datatypes.polinomial;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.datatypes.polinomial.PolinomialElement;

import java.util.ArrayList;


public class PolinomialValue extends AbstractValue{

	private final int degree;
	private final int size;
	private final ArrayList <PolinomialElement> pol;
	
	public PolinomialValue(int deg) 
			throws OperationNotSupportedException {
		super();
		degree = deg;
		size = deg+1;
		pol = new ArrayList <PolinomialElement>(size);
	}
	
	public PolinomialValue(int deg, int rSize) 
			throws OperationNotSupportedException {
		super();
		degree = deg;
		size = rSize;
		pol = new ArrayList <PolinomialElement>(size);
	}
	
	public PolinomialValue(int deg, double value) 
			throws OperationNotSupportedException {
		super();
		degree = deg;
		size = deg+1;
		pol = new ArrayList <PolinomialElement>(size);	
		for(int i = 0; i < size; i++) 
			pol.add(new PolinomialElement(value,degree-i));
	}
	
	public PolinomialValue(Double ar []) 
			throws OperationNotSupportedException {
		super();
		degree = ar.length;
		size = ar.length;
		pol = new ArrayList <PolinomialElement>(ar.length);
		int i = 0;
		for(Double value: ar) {
			pol.add(new PolinomialElement(value,degree-i));
			i++;
		}
	}
	
	public PolinomialValue(int deg, ArrayList <PolinomialElement> poli) 
			throws OperationNotSupportedException{
		super();
		degree = deg;
		size = poli.size();
		pol = new ArrayList <PolinomialElement>(size);
		for(PolinomialElement polEl: poli) 
			pol.add(new PolinomialElement(polEl.getFactor(), polEl.getPower()));
	}
	
	public PolinomialValue castToNormal() 
			throws OperationNotSupportedException {
		PolinomialValue res = new PolinomialValue(degree, 0.0);
		for(int i = 0; i <= degree; i++) {
			for(int j = 0; j < size; j++) {
				if(pol.get(j).getPower() == degree - i)
					res.pol.set(i, new PolinomialElement(
							res.pol.get(i).getFactor()+pol.get(j).getFactor(),degree - i)
					);
			}
		}
		PolinomialValue Result = new PolinomialValue(res.degree);
		for(PolinomialElement polEl: res.pol) {
			if(polEl.getFactor() != 0) Result.pol.add(polEl);
		}
		if(Result.pol.isEmpty()) {
			Result.pol.add(new PolinomialElement (0.0, 0));
			return new PolinomialValue(0, res.pol);
		}
			else return new PolinomialValue(Result.pol.get(0).getPower(), Result.pol);
	}
	
	@Override
	public AbstractValue add(AbstractValue operand)
			throws OperationNotSupportedException {
		PolinomialValue poli = (PolinomialValue)operand;
		PolinomialValue res = new PolinomialValue (
				Math.max(pol.get(0).getPower(), poli.pol.get(0).getPower())
				);
		int j = 0, k = 0;
		while(j < poli.size && k < size) {
			if(poli.pol.get(j).getPower() 
					== pol.get(k).getPower()) {
				res.pol.add(new PolinomialElement(
						poli.pol.get(j).getFactor()+pol.get(k).getFactor(), 
						pol.get(k).getPower()));
				j++;
				k++;
			}
				else if(poli.pol.get(j).getPower() > pol.get(k).getPower()) {
					res.pol.add(new PolinomialElement(
							poli.pol.get(j).getFactor(), poli.pol.get(j).getPower()));
					j++;
				}
					else {
					res.pol.add(new PolinomialElement(
							pol.get(k).getFactor(), pol.get(k).getPower()));
					k++;
				}
		}
			if(j == poli.size) for(k = k; k < size; k++) res.pol.add(new PolinomialElement(
					pol.get(k).getFactor(), pol.get(k).getPower()));
			else for(j = j; j < poli.size; j++) res.pol.add(new PolinomialElement(
					poli.pol.get(j).getFactor(), poli.pol.get(j).getPower()));
			
		PolinomialValue Result = new PolinomialValue(res.degree);
		for(j = 0; j < res.pol.size(); j++) {
			if(res.pol.get(j).getFactor() != 0) Result.pol.add(res.pol.get(j));
		}
		if(Result.pol.isEmpty()) {
			Result.pol.add(new PolinomialElement (0.0, 0));
			return new PolinomialValue(0, Result.pol);
		}	
		return new PolinomialValue(Result.degree, Result.pol);
	}

	@Override
	public AbstractValue sub(AbstractValue operand)
			throws OperationNotSupportedException {
		PolinomialValue poli = (PolinomialValue)operand;
		PolinomialValue res = new PolinomialValue(poli.degree, poli.size);
		for(PolinomialElement polEl: poli.pol) res.pol.add(
				new PolinomialElement( -polEl.getFactor(), 
										polEl.getPower())
									);
		/*for(int i = 0;  i < poli.size; i++) res.pol.add(
				new PolinomialElement( -poli.pol.get(i).getFactor(), 
										poli.pol.get(i).getPower()
									 )
				);*/
		return (PolinomialValue)this.add(res);
	}

	@Override
	public AbstractValue mul(AbstractValue operand)
			throws OperationNotSupportedException {
		PolinomialValue poli = (PolinomialValue)operand;
		PolinomialValue res = 
				new PolinomialValue(degree+poli.degree,poli.pol.size()*pol.size());
		for(PolinomialElement polEl1: pol)
			for(PolinomialElement polEl2: poli.pol) 
				res.pol.add(new PolinomialElement(
						polEl1.getFactor() * polEl2.getFactor(),
						 polEl1.getPower() + polEl2.getPower()));
		/*for(int i = 0; i < pol.size(); i++) {
			for(int j = 0; j < poli.pol.size(); j++) {
			res.pol.add(new PolinomialElement(
					poli.pol.get(j).getFactor()*pol.get(i).getFactor(),
					poli.pol.get(j).getPower()+pol.get(i).getPower())
					);
			}
		}*/
		return res.castToNormal();
	}

	@Override
	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException, OperationNotSupportedException {
		PolinomialValue pol1 = this.castToNormal();
		PolinomialValue pol2 = ((PolinomialValue)operand).castToNormal();
		PolinomialValue res = new PolinomialValue(
				degree, new ArrayList <PolinomialElement>()
				);
		if (pol2.pol.get(0).getFactor() == 0.0 &&
			pol2.pol.get(0).getPower() == 0) throw new DivisionByZeroException();
			else if(pol1.pol.get(0).getPower() < pol2.pol.get(0).getPower()) {
				res.pol.add(new PolinomialElement(0.0, 0));
				return new PolinomialValue(0, res.pol);
			}
				else {
					Double mult;
					Integer degMult;
					PolinomialValue divisior = new PolinomialValue(pol2.degree, pol2.pol);
					PolinomialValue temp = new PolinomialValue(pol2.degree, pol2.pol);
					PolinomialValue divinded = new PolinomialValue(pol1.degree, pol1.pol);
					while(divinded.pol.get(0).getPower()>=divisior.pol.get(0).getPower()) {
						mult = divinded.pol.get(0).getFactor() 
								/ divisior.pol.get(0).getFactor();
						degMult = divinded.pol.get(0).getPower() 
								- divisior.pol.get(0).getPower();
						for(int i = 0; i < pol2.size; i++) temp.pol.set(
									i, new PolinomialElement(
											pol2.pol.get(i).getFactor() * mult, 
											pol2.pol.get(i).getPower() + degMult
											)
									);
						res.pol.add(new PolinomialElement(mult, degMult));
						divinded = (PolinomialValue)divinded.sub(temp);
					}
		}
		return new PolinomialValue(res.pol.get(0).getPower(), res.pol);
	}

	@Override
	public String toString() {
			String str = "";
			for(int i = 0; i < size; i++) {
					str += 	"+"+pol.get(i).getFactor().toString()
							+"x^"+pol.get(i).getPower().toString();
					}
		return str.substring(1);
		}
	
}
