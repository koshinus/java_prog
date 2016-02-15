package course_work;

public class mult_inheritance_test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		hd hd1 = new hd();
		hd1.a_show();
		hd1.c_show();
		hd1.d_show();
		hd1.e_show();
		hd1.g_show();
		hd1.h_show();
		int n;
		//std::cin >> n;
	}

	public interface a
	{
		void a_show();
	}

	public class b implements a
	{
		public void a_show()
		{
			System.out.print("ba\n");
		}
		public final void b_show()
		{
			System.out.print("b\n");
		}
	}

	public class c implements a
	{
		public void a_show()
		{
			System.out.print("ca\n");
		}
		public final void c_show()
		{
			System.out.print("c\n");
		}
	}

	public class d extends c
	{
		@Override
		public void a_show()
		{
			System.out.print("da\n");
		}
		public final void d_show()
		{
			System.out.print("d\n");
		}
	}

	public class e
	{
		public void e_show()
		{
			System.out.print("e\n");
		}
	}

	public class f extends e
	{
		@Override
		public void e_show()
		{
			System.out.print("fe\n");
		}
		public final void f_show()
		{
			System.out.print("f\n");
		}
	}

	public class g extends e
	{
		@Override
		public void e_show()
		{
			System.out.print("ge\n");
		}
		public final void g_show()
		{
			System.out.print("g\n");
		}
	}

	public class h extends g
	{
		@Override
		public void e_show()
		{
			System.out.print("he\n");
		}
		public final void h_show()
		{
			System.out.print("h\n");
		}
	}

	//C++ TO JAVA CONVERTER TODO TASK: Multiple inheritance is not available in Java:
	public class hd extends h, d
	{
		@Override
		public void e_show()
		{
			System.out.print("hde\n");
		}
		@Override
		public void a_show()
		{
			System.out.print("hda\n");
		}
		public final void hd_show()
		{
			System.out.print("hd\n");
		}
	}
}
