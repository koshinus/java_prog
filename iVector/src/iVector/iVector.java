package iVector;

public interface iVector 
{	
	public double scalar(iVector v);
	
	public double len();
	
	public iVector multiple(double factor);
	
	public iVector add(iVector v);
	
	public iVector sub(iVector v);
	
	public double projection(iVector v);
}
