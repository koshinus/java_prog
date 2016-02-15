package ClassSearcher;

import java.util.Comparator;

public class SortLexicographically implements Comparator<MyPair>
{

	@Override
	public int compare(MyPair o1, MyPair o2) 
	{
		// TODO Auto-generated method stub
		int comp = (o1.getValue()).compareTo(o2.getValue());
		if(comp == 0)
			return (o1.getTime()).compareTo(o2.getTime());
			else return comp;
	}

}
