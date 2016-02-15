package iVector;

public class Vector3D implements iVector 
{
	private double X;
	private double Y;
	private double Z;
	
	public Vector3D(double x, double y, double z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	public double scalar(iVector v) 
	{
		Vector3D vec = (Vector3D) v;
		return (X*vec.X+Y*vec.Y+Z*vec.Z);
	}
	
	public double len()
	{
		return Math.sqrt(scalar(this));
	}

	public Vector3D multiple(double factor) 
	{
		return new Vector3D(X*factor, Y*factor, Z*factor);
	}
	
	public Vector3D add(iVector vec) 
	{
		Vector3D v = (Vector3D) vec;
		return new Vector3D(X+v.X, Y+v.Y, Z+v.Z);
	}
	
	public Vector3D sub(iVector vec) 
	{
		Vector3D v = (Vector3D) vec;
		return new Vector3D(X-v.X, Y-v.Y, Z-v.Z);
	}
	
	public double projection(iVector vec)
	{
		Vector3D v = (Vector3D) vec;
		return this.scalar(v)/v.len();
	}
	
}
