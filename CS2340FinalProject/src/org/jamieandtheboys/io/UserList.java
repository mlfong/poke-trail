package org.jamieandtheboys.io;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains the list of users and their respective passwords. Basically a Serializable ArrayList
 */
public class UserList implements Serializable {
	
	ArrayList<String[]> users;
	
	/**
	 * Default constructor
	 */
	public UserList()
	{
		users = new ArrayList<String[]>();
	}
	
	public void addUser(String name, String password)
	{
		String[] newUser = new String[2];
		newUser[0] = name;
		newUser[1] = password;
		users.add(newUser);
	}
	
	public boolean deleteUser(String name)
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i)[0].equals(name))
			{
				users.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public String returnUserPassword(String name)
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i)[0].equals(name))
			{
				return users.get(i)[1];
			}
		}
		
		return null;
	}
	
	public boolean exists(String name)
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i)[0].equals(name))
			{
				return true;
			}
		}
		
		return false;
	}
}
