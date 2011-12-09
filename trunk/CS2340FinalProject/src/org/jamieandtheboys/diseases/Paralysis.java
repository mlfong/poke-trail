package org.jamieandtheboys.diseases;

import java.io.Serializable;

import org.jamieandtheboys.persons.Person;

public class Paralysis extends Disease implements Serializable
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
