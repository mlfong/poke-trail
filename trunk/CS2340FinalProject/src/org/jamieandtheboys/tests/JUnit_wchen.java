package org.jamieandtheboys.tests;

import static org.junit.Assert.*;

import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.persons.Breeder;
import org.jamieandtheboys.persons.GenericPerson;
import org.jamieandtheboys.poketrail.GameLogic;
import org.junit.Test;

public class JUnit_wchen {

	/**
	 * 
	 */
	@Test
	public void testHealth()
	{
		GameLogic gl = new GameLogic();
		gl.run();
		
		
		Breeder guy = new Breeder("Guy");
		GenericPerson gal = new GenericPerson("Gal");
		gl.party.add(guy);
		gl.party.add(gal);	
		
		gl.pace = 15; //Grueling
		gl.rations = 2*2; //meager
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(gal.getHealth(), 100);
		
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 99);
		assertEquals(guy.getFatigue(), 17);
		assertEquals(gal.getHealth(), 99);
		assertEquals(gal.getFatigue(), 17);
		
		
		gl.pace = 10; //Normal
		gl.rations = 0; //none
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 99);
		assertEquals(guy.getFatigue(), 32);
		assertEquals(gal.getHealth(), 99);
		assertEquals(gal.getFatigue(), 32);
		
		gl.pace = 5;   //Leisurely
		gl.rations = 1*2; //bare-bones
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(guy.getFatigue(), 32);
		assertEquals(gal.getHealth(), 100);
		assertEquals(gal.getFatigue(), 32);
		
		gl.pace = 0; //Stopped
		gl.rations = 4*2; //Well-fed
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(guy.getFatigue(), 17);
		assertEquals(gal.getHealth(), 100);
		assertEquals(gal.getFatigue(), 17);
		
		gl.pace = 15;	//Grueling
		gl.rations = 3*2; // Normal
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 99);
		assertEquals(guy.getFatigue(), 32);
		assertEquals(gal.getHealth(), 99);
		assertEquals(gal.getFatigue(), 32);
		
		//Check disease, although its in randomevent
		
		guy.setDisease(new Poison());
		gal.setDisease(new Dysentery());
		
		guy.doDisease();
		gal.doDisease();
		
		assertEquals(gl.party.get(0).getHealth(), 95);
		assertEquals(gl.party.get(1).getHealth(), 86);
		
		guy.setDisease(null);
		gal.setDisease(null);
		
		
		//Check player death
		
		guy.setHealth(2);
		gal.setHealth(1);
		gl.updateHealth();
		
		assertEquals(gl.party.size(), 1);
		
		gl.updateHealth();
		
		assertEquals(gl.party.size(), 0);
		assertEquals(gl.gameover, true);
	}
	
}
