package ClassSearcher;

import java.util.Arrays;

public class Searcher implements ISearcher
{
	public Searcher() {}
	
	private static MyPair[] arrayForWork;
	private static int[] frequencyArray;
	
	/*
	 *Алгоритм следующий: получая на вход массив имен классов и массив дат их создания, я создаю
	 *из них один массив класса MyPair, затем я сортирую этот массив лексикографичеки и по дате 
	 *создания (именно в таком порядке: это нужно для оптимизации метода guess), процедура 
	 *calcAccelerator создает массив, в котором подсчитано, сколько классов с какой буквы/цифры 
	 *буквы/цифры начинаются (этим занимается метод matching), затем, при вызове guess, я не бегу
	 *по всему массиву arrayForWork, а сразу начинаю с места, где впервые встретился класс, 
	 *начинающийся с той же буквы, что и заданная подстрока, затем я найденные классы заношу в 
	 *requiredClasses, но, поскольку там может оказаться меньше 12, приходится ненулевые элементы 
	 *переносить в ещё один массив notNullClassesArray, вот его уже сортируем в указанном
	 *в задании порядке, остается только выписать названия классов, отделив от времени их создания
	*/
	@Override
	public void refresh(String[] classNames, long[] modificationDates) 
	{
		// TODO Auto-generated method stub
		MyPair arrayForWork[] = new MyPair[classNames.length];
		for(int i = 0; i < classNames.length; i++) 
			arrayForWork[i] = new MyPair(classNames[i], modificationDates[i]);
		Arrays.sort(arrayForWork, new SortLexicographically());
		Searcher.arrayForWork = arrayForWork;
		calcAccelerator(); 	//поскольку допустимо, что метод refresh будет работать относительно
							//небыстро, вынесем оптимизацию сюда, насколько я понял, главное, 
							//чтобы guess работал быстро 
	}
	
	private static void calcAccelerator()
	{
		int frequencyArray[] = new int [63];
		for(MyPair p: Searcher.arrayForWork) 
			frequencyArray[matching(p.getValue().charAt(0))]++;
		Searcher.frequencyArray = frequencyArray;
	}
	
	private static int matching(char c)
	{
		if(Character.isDigit(c)) return (int)c - 48; //цифры 0-9 на местах 0-9 соответственно
			else if(Character.isLowerCase(c)) return (int)c - 87; 
										//строчные буквы на местах 10-36
				else if(Character.isUpperCase(c)) return (int)c - 29;
										//заглавные буквы на местах 37-62
					else return 62;
	}

	@Override
	public String[] guess(String start) 
	{
		// TODO Auto-generated method stub
		MyPair [] requiredClasses = new MyPair[12];
		int charIndex = matching(start.charAt(0));
		int startIndex = 0;
		for(int i = 0; i < charIndex; i++)
			startIndex += Searcher.frequencyArray[i];
		int classesCount = 0;
		for(int i = startIndex; i < Searcher.frequencyArray[charIndex] + startIndex; i++)
		{
			if(classesCount < 12 && Searcher.arrayForWork[i].getValue().startsWith(start))
			{
				requiredClasses[classesCount] = 
					new MyPair(Searcher.arrayForWork[i].getValue(), Searcher.arrayForWork[i].getTime());
				classesCount++;
			}
		}
		MyPair[] notNullClassesArray = new MyPair[classesCount];
		System.arraycopy(requiredClasses, 0, notNullClassesArray,0, classesCount);
		Arrays.sort(notNullClassesArray, new SortByTime());
		String [] result = new String [classesCount];
		for(int i = 0; i < classesCount; i++) 
			result[i] = new String(notNullClassesArray[i].getValue());
		return result;
	}
}
