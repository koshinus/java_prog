package Message;

import java.lang.StringBuilder;

public class Message
{
  private String m_strMsg;  // ������� ���������

  // ������� ����� ��������� � �������
  public Message(String strMsg)
  {
    setMessage(strMsg);
  }

  // ��������� ���������
  public String getMessage()
  {
    return m_strMsg;
  }

  // ������������� ���������
  public void setMessage(String strMsg)
  {
    m_strMsg = strMsg;
  }
  
  public int countWords()// ���������� ���������� ����
  {
	  return m_strMsg.split("\\s").length;
  }
  
  public String reverse()        // ���������� ������������ ������
  {
	  return new StringBuilder(m_strMsg).reverse().toString();
  }

  public int count(char c)      // ���������� ���-�� ��������� ������� � ������
  {
	  int count = 0;
	  for(int i = 0; i < m_strMsg.length(); i++) 
	  {
		  if(m_strMsg.charAt(i) == c) count++;
	  }
	  return count;
  }
  
  public boolean isValid()       // ��������� ������������ ����������� ������ []{}()<> � ������
  {
	  if(brackets_balance.correctBrackets(m_strMsg) == m_strMsg.length()+1) return true;
	  else return false;
  }
  
  public String encode(int shift)       // ����������� ��� ������� ������� �� shift
  {
	  char str [] = new char [m_strMsg.length()];
	  for(int i = 0; i < m_strMsg.length(); i++) str[i] = (char)((int)m_strMsg.charAt(i)+shift);
	  return new String(str);
  }

}