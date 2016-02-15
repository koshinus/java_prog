package stack;

public class Test {

	public static void main(String[] args) 
	{
		myStack<String> p = new myStack<String>(4);
		p.push("sdfhsd");
		p.push("sed");
		p.push("d");
		p.push("s");
		System.out.println(p.peek());
		p.pop();
		for(String el: p) System.out.println(el);
	}

}
