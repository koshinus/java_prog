package Vector3D;

//import java.lang.Math;
public class Vector3D 
{
	private double X;
	private double Y;
	private double Z;
	
	Vector3D(){}
	
	Vector3D(double x, double y, double z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	
	Vector3D(Vector3D v)
	{
		X = v.X;
		Y = v.Y;
		Z = v.Z;
	}
	
	public double getX()
	{
		return X;
	}
	
	public double getY()
	{
		return Y;
	}
	
	public double getZ()
	{
		return Z;
	}
	
	public double scalar(Vector3D v)
	{
		return v.X*X+v.Y*Y+v.Z*Z;
	}
	
	public double len()
	{
		return Math.sqrt(scalar(this));
	}
	
	public Vector3D multiple(double factor)
	{
		return new Vector3D(X*factor,Y*factor,Z*factor);
	}

	public Vector3D add(Vector3D v)
	{
		return new Vector3D(v.X+X,v.Y+Y,v.Z+Z);
	}
	
	public Vector3D sub(Vector3D v)
	{
		return new Vector3D(X-v.X,Y-v.Y,Z-v.Z);
	}
	
	public Vector3D vector(Vector3D v)
	{
		return new Vector3D(Y*v.Z - Z*v.Y, Z*v.X - X*v.Z, X*v.Y - Y*v.X);
	}

	public void show()
	{
		System.out.print("X = ");
		System.out.println(X);
		System.out.print("Y = ");
		System.out.println(Y);
		System.out.print("Z = ");
		System.out.println(Z);
	}
	
	public static void createSquare(Vector3D p1, Vector3D p2, Vector3D p3)
	{
		if( (p2.sub(p1).len() == p3.sub(p1).len()) && (p2.sub(p1).scalar(p3.sub(p1)) == 0) )
			p2.sub(p1).add(p3.sub(p1)).show();
		else
		if( (p1.sub(p3).len() == p2.sub(p3).len()) && (p1.sub(p3).scalar(p2.sub(p3)) == 0) )
			p1.sub(p3).add(p2.sub(p3)).show();
		else
		if( (p1.sub(p2).len() == p3.sub(p2).len()) && (p1.sub(p2).scalar(p3.sub(p2)) == 0) )
			p1.sub(p2).add(p3.sub(p2)).show();
		else 
		System.out.println("Введенные точки не образуют квадрата");
	}
	
	public static void main(String [] args)
	{
		//double p = Double.POSITIVE_INFINITY;
		Vector3D vec1 = new Vector3D(3,1,-1);
		Vector3D vec2 = new Vector3D(5,2,1);
		Vector3D point = new Vector3D(0,2,3);
		Vector3D directional_vector = vec2.sub(vec1);
		//vec1.sub(point).show(); vec1.scalar(vec2);
		//directional_vector.show();
		//vec1.sub(point).vector(directional_vector).show();
		System.out.println("Расстояние от точки до прямой равно: ");
		System.out.println(vec1.sub(point).vector(directional_vector).len()/directional_vector.len());
		Vector3D p2 = new Vector3D(0,0,0);
		Vector3D p1 = new Vector3D(1,0,0);
		Vector3D p3 = new Vector3D(0,1,0);
		createSquare(p1,p2,p3);
		/*Vector3D dir_vec1 = p2.sub(p1);
		Vector3D dir_vec2 = p3.sub(p1);
		if(  (p2.sub(p1).len() == p3.sub(p1).len()) && (p2.sub(p1).scalar(p3.sub(p1)) == 0) 
		  || (p2.sub(p3).len() == p1.sub(p3).len()) && (p2.sub(p3).scalar(p1.sub(p3)) == 0) 
		  || (p3.sub(p2).len() == p1.sub(p2).len()) && (p3.sub(p2).scalar(p1.sub(p2)) == 0) 
		  ) dir_vec1.add(dir_vec2).show();
			else System.out.println("Введенные точки не образуют квадрата");
		System.out.println(vec1.getZ());
		System.out.println(vec1.scalar(vec2));
		System.out.println(vec1.len());
		System.out.println(vec1.multiple(3).getZ());
		System.out.println(vec1.add(vec2).getX());*/
	}
}
