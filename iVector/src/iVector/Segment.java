package iVector;

public class Segment <TVector extends iVector>// implements iVector
{
	private TVector start;
	private TVector end;
	
	Segment(TVector s, TVector e) 
	{
		start = s;
		end = e;
	}
	
	TVector getStart()
	{
		return start;
	}
	
	TVector getEnd()
	 {
		 return end;
	 }
	 
	 double len()
	 {
		 return Math.sqrt(end.sub(start).scalar(end.sub(start)));
	 }
	 
	 double distanceTo(TVector point)
	 {
		 iVector v, w, vert;
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

	public static void main(String [] args)
	{
		Vector3D vec1 = new Vector3D(2,1,0);
		Vector3D vec2 = new Vector3D(5,1,0);
		Vector3D point1 = new Vector3D(1,4,0);
		Vector3D point2 = new Vector3D(3,4,0);
		Vector3D point3 = new Vector3D(7,4,0);
		Segment s1 = new Segment(vec1,vec2);
		System.out.println(s1.getStart().sub(s1.getEnd()).len());
		System.out.println(s1.distanceTo(point1));
		System.out.println(s1.distanceTo(point2));
		System.out.println(s1.distanceTo(point3));
		Vector2D vec21 = new Vector2D(2,1);
		Vector2D vec22 = new Vector2D(5,1);
		Vector2D point12 = new Vector2D(1,4);
		Vector2D point22 = new Vector2D(3,4);
		Vector2D point32 = new Vector2D(7,4);
		Segment s2 = new Segment(vec21,vec22);
		System.out.println(s2.getStart().sub(s2.getEnd()).len());
		System.out.println(s2.distanceTo(point12));
		System.out.println(s2.distanceTo(point22));
		System.out.println(s2.distanceTo(point32));
		System.out.println(vec1.projection(vec2));
		System.out.println(vec21.projection(vec22));
	}
}