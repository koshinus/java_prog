package Message;

public class Test 
{
	public static void main(String [] args)
	  {
	    Message h = new Message("Hello<, World!>");
	    Message h1 = new Message("Hello<, World!}");
	    Message h2 = new Message("Hello, World!}");
	    Message h3 = new Message("Hell(o, World!");
	    System.out.println(h.countWords());
	    System.out.println(h.reverse());
	    System.out.println(h.count('l'));
	    System.out.println(h.encode(1));
	    System.out.println(h.isValid());
	    System.out.println(h1.isValid());
	    System.out.println(h2.isValid());
	    System.out.println(h3.isValid());
	  }
}
