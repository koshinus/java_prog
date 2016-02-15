package AbstractVector;

public class Segment 
{
	private AbstractVector start;
	private AbstractVector end;
	
	Segment() {}
	
	Segment(AbstractVector s, AbstractVector e) 
	{
		start = s;
		end = e;
	}
	
	AbstractVector getStart()
	{
		return start;
	}
	
	AbstractVector getEnd()
	 {
		 return end;
	 }
	 
	 double len()
	 {
		 return Math.sqrt(end.sub(start).scalar(end.sub(start)));
	 }
	 
	 double distanceTo(AbstractVector point)
	 {
		 AbstractVector v, w, vert;
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
}
