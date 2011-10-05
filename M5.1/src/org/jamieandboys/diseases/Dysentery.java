package org.jamieandboys.diseases;

import org.jamieandtheboys.persons.Person;

public class Dysentery extends Disease
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
