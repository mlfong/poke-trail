package org.jamieandtheboys.io;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Character;

/**
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

	public SaveAndLoad()
	{
		loadUsers();
	}//end constructor


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

	public boolean deleteUser(String name, String pass)
	{
		boolean deleted = true;
		if(verify(name, pass) == true)
			this.users.deleteUser(name);
		else
			deleted = false;

		return deleted;
	}

	public FileManager loadSaveFile(String name, String pass)
	{
		FileManager userFile = null;
		if(verify(name, pass) == true)
			userFile = loadFile(name + ".ser");

		return userFile;
	}
	
	public boolean exists(String user)
	{
		return users.exists(user);
	}

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

	/**
	 * Loads the user list from a file
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

	private static int convertToInt(String s)
	{
		int ret = 0;
		for(int i = 0; i < s.length(); i++)
			ret += s.charAt(i);
		return ret > 600 ? ret/2 : ret;
	}//end convertToInt
}