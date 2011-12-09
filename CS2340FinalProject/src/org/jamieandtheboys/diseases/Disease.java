package org.jamieandtheboys.diseases;

import java.io.Serializable;

import org.jamieandtheboys.persons.Person;

public abstract class Disease implements Serializable
{
	private String name;
	
	public Disease(String name)
	{
		this.name = name;
	}
	
	public abstract void doEffect(Person person);
	
	public String toString()
	{
		return this.name;
	}
}
