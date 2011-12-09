package org.jamieandtheboys.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.jamieandtheboys.poketrail.Store;

public class JamieCrabb_JUnit_StoreTest {

	/**
	 * @test
	 *	This tests the Store class methods: getName(), getItem() and inStore()
	 */
	@Test
	public void test() {
		Store store = new Store("Jamie's Test Store");
		assertEquals("Jamie's Test Store", store.getName());
		
		assertEquals(null , store.getItem("Pikachu"));
		
		assertTrue(store.inStore("Food"));
		assertTrue(store.inStore("Clothing"));
		assertTrue(store.inStore("SpareAxle"));
		assertTrue(store.inStore("FullHeal"));
		assertTrue(store.inStore("Oxen"));
		assertTrue(store.inStore("Pokeball"));		
		assertTrue(store.inStore("SpareWheel"));
		assertTrue(store.inStore("SpareTongue"));
		
		assertFalse(store.inStore(""));
		assertFalse(store.inStore(null));
		assertFalse(store.inStore("Pikachu"));
	
	}
}