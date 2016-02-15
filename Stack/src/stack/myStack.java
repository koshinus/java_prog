package stack;

import java.util.Iterator;

public class myStack<T extends Object> 
	implements Iterable<T> 
{
	private T [] st;
	int elem_count;
	
	public myStack(int size)
	{
		st = (T[]) new Object [size];
		elem_count = 0;
	}
	
	public void push(T value)
	{
		if(elem_count == st.length) 
		{
			T [] res = (T[]) new Object [elem_count*2];
			for(int i = 0; i < elem_count; i++) res[i] = st[i];
			res[elem_count] = value;
			st = res;
			elem_count++;
		}
		else 
		{
			st[elem_count] = value;
			elem_count++;
		}
	}
	
	public void pop()
	{
		st[elem_count-1] = null;
		elem_count--;
	}
	
	public T peek()
	{
		return st[elem_count-1];
	}
	
	public int size()
	{
		return elem_count;
	}
	
	public boolean isEmpty()
	{
		return elem_count==0;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new Iterator<T>()
				{
					int i = elem_count-1;
					@Override
					public boolean hasNext() 
					{
						if(i >= 0) return true;
						return false;
					}

					@Override
					public T next() 
					{
						return st[i--];
					}
					
				};
	}
}
