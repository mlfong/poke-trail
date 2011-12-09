package org.jamieandtheboys.diseases;

import java.io.Serializable;

import org.jamieandtheboys.persons.Person;

public class Poison extends Disease implements Serializable
{
	public Poison()
	{
		super("Poison");
	}
	
	@Override
	public void doEffect(Person person)
	{
		person.setHealth(person.getHealth() - 4);
	}

}
