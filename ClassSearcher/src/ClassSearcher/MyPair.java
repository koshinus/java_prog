package ClassSearcher;

public class MyPair
{
	private String value;
	private Long time;
	
	MyPair(String val, Long t)
	{
		value = val;
		time = t;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public Long getTime()
	{
		return time;
	}
}
