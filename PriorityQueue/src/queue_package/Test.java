package queue_package;

public class Test {

	public static void main(String[] args) 
	{
		PriorityQueue<String> p = new PriorityQueue<String>(4);
		p.push(3, "sdfhesd");
		p.push(1, "sdfhsd");
		p.push(7, "sed");
		p.push(67, "d");
		p.push(0, "s");
		System.out.println(p.peek());
		String temp = p.pop();
		//for(QueueElement<String> el: p) System.out.println(el.getValue());
		while(!p.isEmpty()) 
		{
			temp = p.pop();
			System.out.println(temp);
		}
		temp = p.pop();

		PriorityQueue<Integer> p1 = new PriorityQueue<Integer>(4);
		p1.push(3, 5);
		p1.push(1, 23);
		p1.push(67, 56);
		p1.push(7, 32);
		p1.push(0, 1);
		System.out.println(p1.peek());
		Integer temp1 = p1.pop();
		for(QueueElement<Integer> el: p1) System.out.println(el.getValue());
	}

}
