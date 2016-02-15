package kruskalAlgorithm;

public class IntPair implements Comparable<IntPair>
{
	private Integer point;
	private Integer price;
	
	IntPair(Integer pt, Integer pr)
	{
		point = pt;
		price = pr;
	}
	
	public Integer getPoint()
	{
		return point;
	}
	
	public Integer getPrice()
	{
		return price;
	}

	@Override
	public int compareTo(IntPair o) 
	{
		// TODO Auto-generated method stub
		if(getPrice().compareTo(o.getPrice()) == 0)
			return getPoint().compareTo(o.getPoint());
		else return getPrice().compareTo(o.getPrice());
	}
}
