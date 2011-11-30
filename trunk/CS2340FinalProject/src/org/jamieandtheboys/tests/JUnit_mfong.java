/**
 * JUnit Test for Wagon
 * 	tests all attributes corresponding to weight
 * 			-- to inventory
 * 			-- to location
 *  does not test basic getters / setters
 */
package org.jamieandtheboys.tests;

import static org.junit.Assert.*;

import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;
import org.jamieandtheboys.poketrail.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit_mfong
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testWeight()
	{
		Wagon w = new Wagon();
		assertEquals(w.getWeight(), 0);
		w.addWeight(100);
		assertEquals(w.getWeight(), 100);
		w.subWeight(50);
		assertEquals(w.getWeight(), 50);
		w.setWeight(0);
		assertEquals(w.getWeight(), 0);
		w.setWeight(5000);
		assertTrue(w.isOverweight());
		w.setWeight(3499);
		assertFalse(w.isOverweight());
		assertEquals(w.availableWeight(), 1);
	}
	
	@Test
	public void testInventory()
	{
		Wagon w = new Wagon();
		//wagon should have 2 oxen
		assertFalse(w.getInventory().isEmpty());
		assertEquals(w.getInventory().get(new Oxen()), new Integer(2));
		w.addItem(new Food(), 4);
		assertEquals(w.getInventory().size(), 2);
		assertEquals(w.getInventory().get(new Food()), new Integer(4));
		w.subItem(new Food(), 3);
		assertEquals(w.getInventory().get(new Food()), new Integer(1));
		w.subItem(new Food(), 1);
		assertEquals(w.getInventory().size(), 1);
	}
	
	@Test
	public void testLocation()
	{
		Wagon w = new Wagon();
		assertEquals(w.getDistTraveled(), 0);
		w.addDistTraveled(20);
		assertEquals(w.getDistTraveled(), 20);
		// all other methods either getters, setters, or constructors
	}
	

}
