package org.jamieandboys.diseases;

import org.jamieandtheboys.persons.Person;

public class Poison extends Disease
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
