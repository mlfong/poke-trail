package org.jamieandtheboys.io;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Character;

/****
 * Will handle all of the saving and loading, as well as keep track of user information
 * For connection between UI and back-end, just worry about the first 4 functions.
 * Also take a look at FileManager
 * @author Wisdom
 *
 */
public class SaveAndLoad
{
	//constants
	private static final String KEYWORD = "jamieandtheboys";
	private static final String userFile = "user.ser";
	//instance properties
	private String password;
	private int m, a;
	private UserList users = null;
	private FileInputStream fis = null;
	private ObjectInputStream in = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream out = null;

  /*
  * Standard constructor
  */
	public SaveAndLoad()
	{
		loadUsers();
	}//end constructor

  /*
  * desc creates a new user for the game
  * @param Strings name and password
  * @ret boolean - if user was created
  */
	public boolean createUser(String name, String pass)
	{
		try
		{
			String encrypted = this.encode(pass);
			this.users.addUser(name, encrypted);
			fos = new FileOutputStream(userFile);
			out = new ObjectOutputStream(fos);
			out.writeObject(users);
			return true;
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
  /*
  * desc - deletes a user give proper credentials
  * @param - Strings name and password
  * @ret - boolean, if user was deleted or not
  */
	public boolean deleteUser(String name, String pass)
	{
		boolean deleted = true;
		if(verify(name, pass) == true)
			this.users.deleteUser(name);
		else
			deleted = false;

		return deleted;
	}
  
  /* 
  * desc - method for actual game loading
  * @param - Strings naem and password
  * @ret - FileManager, state of loaded game
  */
	public FileManager loadSaveFile(String name, String pass)
	{
		FileManager userFile = null;
		if(verify(name, pass) == true)
			userFile = loadFile(name + ".ser");

		return userFile;
	}
	
   /*
   * desc - checks if a user String exists
   * @param - String user
   * @ret - boolean, if user exists
   */
	public boolean exists(String user)
	{
		return users.exists(user);
	}
  
  /*
  * desc - method for game saving
  * @param - String, FileManager
  * @ret - boolean, if save was successful
  */
	public boolean saveFile(String name, FileManager saveFile)
	{
		try
		{
			fos = new FileOutputStream(name + ".ser");
			out = new ObjectOutputStream(fos);
			out.writeObject(saveFile);
			return true;
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * desc - Loads the user list from a file
	 */
	private void loadUsers()
	{
		try
		{
			fis = new FileInputStream(userFile);
			in = new ObjectInputStream(fis);
			users = (UserList) in.readObject();
		}
		catch(IOException ex)
		{
			System.out.println("No Users created");
			users = new UserList();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
  /*
  * desc - creates FileManager from a file
  * @param - String fileName
  * @ret - FileManager, as accessible by the file name given
  */
	private FileManager loadFile(String fileName)
	{
		try
		{
			FileManager saveFile = null;
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			saveFile = (FileManager) in.readObject();
			return saveFile;
		}
		catch(IOException ex)
		{
			System.out.println("A save file does not exist for this user");
			return null;
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
  /*
  * desc - checks validity of name and password combination
  * @param - String name, password
  * @ret - boolean, if name/pw matches
  */
	private boolean verify(String name, String pass)
	{
		String password = users.returnUserPassword(name);
		if(password == null)
			return false;
		if(encode(pass).equals(password))
			return true;

		return false;
		//valid characters for this string of value 32 through 126;
	}
  
  /*
  * desc - encodes our keyword using user's password
  * @param - String password
  * @ret - String encoded keyword
  */
	private String encode(String pass)
	{
		String encoded = "";
		m = convertToInt(pass.substring(0, pass.length()/2));
		a = convertToInt(pass.substring(pass.length()/2));
		
		for(int i = 0; i < KEYWORD.length(); i++)
		{
			int current = (int) KEYWORD.charAt(i);
			if(i%3 == 0)
			{
				current = current*m;
			}
			if(i%3 == 1)
			{
				current = current*a;
			}
			if(i%3 == 2)
			{
				current = current*(m + a);
			}
			encoded = encoded + String.valueOf(current);
		}
		
		return encoded;
	}
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
  
  /*
  *  desc - changes a String to an int dependng on summation of its characters
  *     if summation > 600, return half of that
  * @param - String
  * @ret - int
  */
	private static int convertToInt(String s)
	{
		int ret = 0;
		for(int i = 0; i < s.length(); i++)
			ret += s.charAt(i);
		return ret > 600 ? ret/2 : ret;
	}//end convertToInt
}