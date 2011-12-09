package org.jamieandtheboys.diseases;

import java.io.Serializable;

import org.jamieandtheboys.persons.Person;

public class Dysentery extends Disease implements Serializable
{
	public Dysentery()
	{
		super("Dysentery");
	}

	@Override
	public void doEffect(Person person)
	{
		person.setHealth(person.getHealth() - 13);	
	}
}
