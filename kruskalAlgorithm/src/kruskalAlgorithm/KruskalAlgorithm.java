package kruskalAlgorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class KruskalAlgorithm 
{

	public boolean recursive(HashMap< Integer, LinkedList<IntPair> > g, Integer key,
			LinkedList<Integer> unReviewed, LinkedList<Integer> toReview,
			LinkedList<Integer>   Reviewed)
	{
		for(IntPair j: g.get(key))
		{
			Integer pt = j.getPoint();
			if (toReview.contains(pt))
			return true;
			else if (unReviewed.contains(pt))
			{
				toReview.addLast(pt);
				unReviewed.remove(pt);
			}
		}
		Reviewed.addLast(toReview.poll());
		if(toReview.isEmpty()) return false;
		else return recursive(g, toReview.peek(), unReviewed, toReview, Reviewed);
	}

	public boolean cyclic(HashMap< Integer, LinkedList<IntPair> > g)
	{
		LinkedList<Integer> unReviewed 	= new LinkedList<Integer>();
		LinkedList<Integer> toReview	= new LinkedList<Integer>();
		LinkedList<Integer> Reviewed 	= new LinkedList<Integer>();
		for(Integer i: g.keySet())
			unReviewed.addLast(i);
		if(unReviewed.size() < 2) return false;
		else toReview.addLast(unReviewed.poll());
		return recursive(g, toReview.peek(), unReviewed, toReview, Reviewed);
	}
	
	/*public void addVerticle(HashMap< Integer, LinkedList<IntPair> > g, 
							LinkedList<Integer> lst)
	{
		LinkedList<IntPair> candidates = new LinkedList<IntPair>();
		for(Integer i: lst)
			for(IntPair pr: g.get(i)) candidates.addLast(pr);
		Collections.sort(candidates);
		HashMap< Integer, LinkedList<IntPair> > toCheck =
				new HashMap< Integer, LinkedList<IntPair> >();
		for(Integer i: lst) toCheck.put(i, g.get(i));
		for(IntPair ip: candidates)
		{
			if(cyclic(toCheck.put(null, null)))
		}
	}*/
	public void addVerticle
			(HashMap< Integer, LinkedList<IntPair> > g,
			Integer [] marker, Integer connectComponenet)
	{
		LinkedList<IntPair> candidates = new LinkedList<IntPair>();
		for(Integer i: marker)
		{
			if(i == connectComponenet)
				for(IntPair pr: g.get(i)) candidates.addLast(pr);
		}
		Collections.sort(candidates);
		IntPair [] res = new IntPair [candidates.size()];
		for(int i = 1; i < candidates.size(); i++)
			if(candidates[i]. == candidates[i-1])
	}
	
	public static void main(String[] args) 
	{
		
	}

}
