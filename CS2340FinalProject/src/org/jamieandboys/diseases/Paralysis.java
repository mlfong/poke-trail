package org.jamieandboys.diseases;

import org.jamieandtheboys.persons.Person;

public class Paralysis extends Disease
{
	public Paralysis()
	{
		super("Paralysis");
	}

	@Override
	public void doEffect(Person person)
	{
		person.setFatigue(person.getFatigue() + 5);
		
	}
}
