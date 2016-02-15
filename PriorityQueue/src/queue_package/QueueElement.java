package queue_package;

public class QueueElement<T>
	implements Comparable<QueueElement<T>> 
{
	private int key;
	private T value;

	public QueueElement(int Key, T Value)
	{
		key = Math.abs(Key);
		value = Value;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public T getValue()
	{
		return value;
	}

	@Override
	public int compareTo(QueueElement<T> o) 
	{
		return ((Integer)key).compareTo(o.key);
	}
}