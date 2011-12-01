/**
 * JUnit Test for Wagon and its pertinent subclasses
 * 	tests all attributes corresponding to weight
 * 			-- to inventory
 * 			-- to location
 *  does not explicitly test basic getters / setters
 */
package org.jamieandtheboys.tests;

import static org.junit.Assert.*;

import org.jamieandtheboys.items.*;
import org.jamieandtheboys.poketrail.*;
import org.junit.Test;

public class JUnit_mfong
{
	/*
	 * Tests Wagon and its weight capacities
	 * Methods:
	 * 		addWeight(int)
	 * 		subWeight(int)
	 * 		setWeight(int)
	 * 		isOverweight()
	 * 		availableWeight()
	 */
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
	
	/*
	 * Tests inventory of Wagon
	 * Methods:
	 * 		isEmpty()
	 * 		addItem(Item, int)
	 * 		subItem(Item, int)
	 * 		size()
	 * Inventory is essentially a HashMap, but 
	 * this JUnit was necessary because it also
	 * tests Item's hashcode override
	 */
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
	
	/*
	 * Tests Wagon's Map / location information
	 * Methods:
	 * 		addDistTraveled()
	 * 		isARiver()
	 * 		getCurr()
	 * 		getDest()
	 */
	@Test
	public void testLocation()
	{
		Wagon w = new Wagon();
		assertEquals(w.getDistTraveled(), 0);
		w.addDistTraveled(20);
		assertEquals(w.getDistTraveled(), 20);
		PokeMap m = w.getMap();
		MapNode mn = m.getCurr();
		MapNode dest = m.getDest();
		assertEquals(mn.getLocation().getName(), "Pallet Town");
		assertEquals(dest.getLocation().getName(), "Indigo Plateau");
		assertFalse(mn.isARiver());
		mn = mn.getNext();
		assertEquals(mn.getLocation().getName(), "River Crossing");
		assertTrue(mn.isARiver());
	}
	

}
