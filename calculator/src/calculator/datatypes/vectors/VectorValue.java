package calculator.datatypes.vectors;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;

public class VectorValue extends AbstractValue {
	private final int dimension;
	private final double [] vector;
	
	public VectorValue(int dim) {
		super();
		dimension = dim;
		vector = new double [dimension];
	}
	
	public VectorValue(int dim, double value) {
		super();
		dimension = dim;
		vector = new double [dimension];	
		for(int i = 0; i < dimension; i++) vector[i] = value;
	}
	
	public VectorValue(double ar [])
	{
		super();
		dimension = ar.length;
		vector = new double [dimension];
		for(int i = 0; i < dimension; i++) vector[i] = ar[i];
	}
	
	public VectorValue(VectorValue vec)
	{
		super();
		dimension = vec.dimension;
		vector = new double [dimension];
		for(int i = 0; i < dimension; i++) vector[i] = vec.vector[i];
	}
	
	public AbstractValue add(AbstractValue operand) {
		VectorValue vec = (VectorValue)operand;
		if(dimension < vec.dimension) System.out.println("Размерность вектора изменилась!");
		VectorValue new_vec = new VectorValue(Math.max(dimension, vec.dimension), 0);
		int i = 0;
		while(i < Math.min(dimension, vec.dimension))
		{
			new_vec.vector[i] = vec.vector[i] + vector[i];
			i++;
		}
		if (dimension < vec.dimension) 
			while(i < vec.dimension) 
			{
				new_vec.vector[i] = vec.vector[i];
				i++;
			}
		else 
			while(i < dimension) 
			{
				new_vec.vector[i] = vector[i];
				i++;
			}
		return new_vec;
	}
	
	public AbstractValue sub(AbstractValue operand) {
		VectorValue vec = (VectorValue)operand;
		if(dimension < vec.dimension) System.out.println("Размерность вектора изменилась!");
		VectorValue new_vec = new VectorValue(Math.max(dimension, vec.dimension), 0);
		int i = 0;
		while(i < Math.min(dimension, vec.dimension))
		{
			new_vec.vector[i] = vec.vector[i] - vector[i];
			i++;
		}
		if (dimension < vec.dimension) 
			while(i < vec.dimension) 
			{
				new_vec.vector[i] = -vec.vector[i];
				i++;
			}
		else while(i < dimension) 
			{
			new_vec.vector[i] = vector[i];
			i++;
			}
		return new_vec;
	}
		
	public AbstractValue mul(AbstractValue operand) 
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException("*");
	}
		
	public AbstractValue div(AbstractValue operand) 
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException("/");
	}
	
	public String toString() {
		return java.util.Arrays.toString(vector);
	}

}
