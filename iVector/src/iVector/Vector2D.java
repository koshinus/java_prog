package iVector;

public class Vector2D implements iVector
{
	private double X;
	private double Y;
	
	public Vector2D(double x, double y)
	{
		X = x;
		Y = y;
	}
	public double scalar(iVector v) 
	{
		Vector2D vec = (Vector2D) v;
		return (X*vec.X+Y*vec.Y);
	}
	
	public double len()
	{
		return Math.sqrt(scalar(this));
	}

	public Vector2D multiple(double factor) 
	{
		return new Vector2D(X*factor, Y*factor);
	}
	
	public Vector2D add(iVector vec) 
	{
		Vector2D v = (Vector2D) vec;
		return new Vector2D(X+v.X, Y+v.Y);
	}
	
	public Vector2D sub(iVector vec) 
	{
		Vector2D v = (Vector2D) vec;
		return new Vector2D(X-v.X, Y-v.Y);
	}

	public double projection(iVector vec)
	{
		Vector2D v = (Vector2D) vec;
		return this.scalar(v)/v.len();
	}
}
