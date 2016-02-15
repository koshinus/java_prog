package AbstractVector;

public class AbstractVector 
{
	private int dimension;
	private double AbstractVector [] = new double [dimension];
	
	public double getComponent(int i)
	{
		return AbstractVector[i];
	}
	
	public AbstractVector (int size)
	{
		dimension = size;
		AbstractVector = new double [dimension];
		for(int i = 0; i < dimension; i++) AbstractVector[i] = 0;
	}

	public AbstractVector (int size, double num)
	{
		dimension = size;
		AbstractVector = new double [dimension];
		for(int i = 0; i < dimension; i++) AbstractVector[i] = num;
	}
	
	public AbstractVector (double ar [])
	{
		dimension = ar.length;
		AbstractVector = new double [dimension];
		for(int i = 0; i < dimension; i++) AbstractVector[i] = ar[i];
	}
	
	public double scalar(AbstractVector v)
	{
		double scal = 0;
		for(int i = 0; i < dimension; i++) scal += getComponent(i)*v.getComponent(i);
		return scal;
	}
	
	public double len()
	{
		return Math.sqrt(scalar(this));
	}
	
	public AbstractVector multiple(double factor)
	{
		double ar [] = new double [AbstractVector.length];
		for(int i = 0; i < dimension; i++) ar[i] = AbstractVector[i] * factor;
		return new AbstractVector(ar);
	}

	public AbstractVector add(AbstractVector v)
	{
		double ar [] = new double [AbstractVector.length];
		for(int i = 0; i < dimension; i++) ar[i] = getComponent(i) + v.getComponent(i);
		return new AbstractVector(ar);
	}
	
	public AbstractVector sub(AbstractVector v)
	{
		double ar [] = new double [AbstractVector.length];
		for(int i = 0; i < dimension; i++) ar[i] = getComponent(i) - v.getComponent(i);
		return new AbstractVector(ar);
	}

}
