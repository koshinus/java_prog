package Vector3D;

public class Segment 
{
	private Vector3D start;
	private Vector3D end;
	
	Segment() {}
	
	Segment(Vector3D s, Vector3D e) 
	{
		start = s;
		end = e;
	}
	
	Vector3D getStart()
	{
		return start;
	}
	
	 Vector3D getEnd()
	 {
		 return end;
	 }
	 
	 double len()
	 {
		 return Math.sqrt(end.sub(start).scalar(end.sub(start)));
	 }
	 
	 double distanceTo(Vector3D point)
	 {
		 Vector3D v, w, vert;
	      v = end.sub(start);
	      w = point.sub(start);
	      double c1,c2,b;
	      if ( (c1 = w.scalar(v)) <= 0 )
	            return w.len();
	      if ( (c2 = v.scalar(v)) <= c1 )
	            return end.sub(point).len();
	      b = c1 / c2; 
	      vert = start.add(v.multiple(b));
	      return vert.sub(point).len();
	  }
	 
	public static void main(String[] args) 
	{
		/*String s1 = "Hello World!";
		String s2 = s1;
		System.out.println(s2);
		s2 = "sdugfy";
		System.out.println(s2);*/
		Vector3D vec1 = new Vector3D(2,1,0);
		Vector3D vec2 = new Vector3D(5,1,0);
		Vector3D point1 = new Vector3D(1,4,0);
		Vector3D point2 = new Vector3D(3,4,0);
		Vector3D point3 = new Vector3D(7,4,0);
		Segment s1 = new Segment(vec1,vec2);
		System.out.println(s1.distanceTo(point1));
		System.out.println(s1.distanceTo(point2));
		System.out.println(s1.distanceTo(point3));
	}

}
