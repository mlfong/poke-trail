package org.jamieandtheboys.poketrail;

public class SaveAndLoad
{
	//constants
	private static final String KEYWORD = "jamieandtheboys";
	
	//instance properties
	private String password;
	private int m, a;
	
	public SaveAndLoad(String password)
	{
		this.password = password;
		m = convertToInt(password.substring(0, password.length()/2));
		a = convertToInt(password.substring(password.length()/2));
	}//end constructor
	
//	public String getPassword()
//	{
//		return password;
//	}//end getPassword
//	
//	public int getM()
//	{
//		return m;
//	}//end getM
//	
//	public int getA()
//	{
//		return a;
//	}//end getA
	
	public static int convertToInt(String s)
	{
		int ret = 0;
		for(int i = 0; i < s.length(); i++)
			ret += s.charAt(i);
		return ret > 600 ? ret/2 : ret;
	}//end convertToInt
}
