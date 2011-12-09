package org.jamieandtheboys.poketrail.Store;

import static org.junit.Assert.*;
import org.junit.Test;

public class StoreTest {

	/**
	 * @test
	 *	This tests the Store class methods: getName(), getItem() and inStore()
	 */
	public void test() {
		Store store = new Store("Jamie's Test Store");
		assertEquals("This is not working","Jamie's Test Store", store.getName());
		
		assertEquals("This is not working", null , store.getItem("Pikachu"));
		
		assertTrue("This is not working", store.inStore("Food"));
		assertTrue("This is not working", store.inStore("Clothing"));
		assertTrue("This is not working", store.inStore("SpareAxle"));
		assertTrue("This is not working", store.inStore("FullHeal"));
		assertTrue("This is not working", store.inStore("Oxen"));
		assertTrue("This is not working", store.inStore("Pokeball"));		
		assertTrue("This is not working", store.inStore("SpareWheel"));
		assertTrue("This is not working", store.inStore("SpareTongue"));
		
		assertFalse("This is not working", store.inStore(""));
		assertFalse("This is not working", store.inStore(null));
		assertFalse("This is not working", store.inStore("Pikachu"));
	
	}

}
