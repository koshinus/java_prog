package queue_package;
import java.lang.reflect.Array;
import java.util.Iterator;

public class PriorityQueue<T> 
	implements Iterable<QueueElement<T>>
{
	private QueueElement<T> [] queue;
	private int queue_size;

	public PriorityQueue(int size)
	{
		queue = (QueueElement<T>[]) Array.newInstance(QueueElement.class, size);
		queue_size = 0;
	}
	
	private void heapify(QueueElement<T>[] A, int i, int queue_size)
	{
		int left = 2*i+1;
		int right = 2*(i+1);
		int largest = i;
		if(left < queue_size && 
				A[left].getKey() > A[i].getKey()) largest = left;
			else if(right < queue_size && 
					A[right].getKey() > A[i].getKey()) largest = right;
		if(largest != i) 
		{
			QueueElement<T> temp = 
					new QueueElement<T>(A[i].getKey(), A[i].getValue());
			A[i] = A[largest];
			A[largest] = temp;
			heapify(A, largest, queue_size);
		}
	}
	
	public PriorityQueue(QueueElement<T>[] A)
	{
		queue_size = A.length;
		for(int i = A.length/2; i >= 0; i--) heapify(A, i, queue_size);
	}
	
	private void changeQueue(QueueElement<T> [] A, int i, QueueElement<T> El)
	{
		if(El.getKey() < A[i].getKey()) 
		{
			A[i] = El;
			heapify(A, i, queue_size);
		}
		A[i] = El;
		while(i > 0 && A[i/2].getKey() < A[i].getKey())
		{
			QueueElement<T> temp = 
					new QueueElement<T>(A[i].getKey(), A[i].getValue());
			A[i] = A[i/2];
			A[i/2] = temp;
			i /= 2;
		}
	}
	
	public void push(int priority, T value)
	{
		if(queue_size == queue.length)
		{
			QueueElement<T>[] res = 
					(QueueElement<T>[]) Array.newInstance(QueueElement.class, 2*queue_size);
			for(int i = 0; i < queue_size; i++) res[i] = queue[i];
			res[queue_size] = new QueueElement<T>(0, value);
			queue = res;
		}
		else queue[queue_size] = new QueueElement<T>(0, value);
		queue_size++;
		changeQueue(queue, queue_size-1, new QueueElement<T>(priority, value));
	}
	
	public T pop()
	{
		T res = null;
		if(queue_size < 1) System.out.println("Очередь уже пуста!");
		else
		{
			res = queue[0].getValue();
			queue[0] = queue[queue_size-1];
			queue[queue_size-1] = null;
			queue_size--;
			heapify(queue, 0, queue_size);
		}
		return res;
	}
	
	public T peek()
	{
		T res = null;
		if(queue_size < 1) System.out.println("Очередь пуста!");
		else res = queue[0].getValue();
		return res;
	}

	public int size()
	{
		return queue_size;
	}
	
	public boolean isEmpty()
	{
		return queue_size == 0; 
	}

	@Override
	public Iterator<QueueElement<T>> iterator() 
	{
		return new Iterator<QueueElement<T>>()
		{
			int i = 0;
			@Override
			public boolean hasNext() 
			{
				return i < queue_size;
			}

			@Override
			public QueueElement<T> next() 
			{
				return queue[i++];
			}
			
		};
	}
	
}
