package org.jamieandtheboys.diseases;

import org.jamieandtheboys.persons.Person;

public abstract class Disease
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
