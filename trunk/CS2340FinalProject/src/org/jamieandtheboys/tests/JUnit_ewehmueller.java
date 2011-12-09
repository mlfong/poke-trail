package org.jamieandtheboys.tests;

import junit.framework.TestCase;

import org.jamieandtheboys.persons.Person;
import org.jamieandtheboys.persons.Trainer;
import org.jamieandtheboys.io.Logger;

public class JUnit_ewehmueller extends TestCase {
	public void testEntry()
	{
		Logger l= new Logger();
		l.entry("test");
		assertEquals("test",l.log.get(0));
		l.entry("aslas;lkdfj78187!9209!)0");
		assertEquals("aslas;lkdfj78187!9209!)0", l.log.get(1));
	}
	
	public void testCreateLogFile()
	{
		Person p= new Trainer("Eric");
		String time = Integer.toString(6) + Integer.toString(55);
		String path = p.getName() + time + ".txt";
		assertEquals("Eric655.txt", path);
	}
}
