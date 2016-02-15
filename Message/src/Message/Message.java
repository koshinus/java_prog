package Message;

import java.lang.StringBuilder;

public class Message
{
  private String m_strMsg;  // текущее сообщение

  // Создает новый контейнер с текстом
  public Message(String strMsg)
  {
    setMessage(strMsg);
  }

  // Извлекает сообщение
  public String getMessage()
  {
    return m_strMsg;
  }

  // Устанавливает сообщение
  public void setMessage(String strMsg)
  {
    m_strMsg = strMsg;
  }
  
  public int countWords()// возвращает количество слов
  {
	  return m_strMsg.split("\\s").length;
  }
  
  public String reverse()        // возвращает перевернутую строку
  {
	  return new StringBuilder(m_strMsg).reverse().toString();
  }

  public int count(char c)      // возвращает кол-во вхождений символа в строку
  {
	  int count = 0;
	  for(int i = 0; i < m_strMsg.length(); i++) 
	  {
		  if(m_strMsg.charAt(i) == c) count++;
	  }
	  return count;
  }
  
  public boolean isValid()       // проверяет правильность расстановки скобок []{}()<> в строке
  {
	  if(brackets_balance.correctBrackets(m_strMsg) == m_strMsg.length()+1) return true;
	  else return false;
  }
  
  public String encode(int shift)       // увеличивает код каждого символа на shift
  {
	  char str [] = new char [m_strMsg.length()];
	  for(int i = 0; i < m_strMsg.length(); i++) str[i] = (char)((int)m_strMsg.charAt(i)+shift);
	  return new String(str);
  }

}