package org.jamieandtheboys.tests;

import static org.junit.Assert.*;

import java.awt.TextArea;

import javax.swing.JProgressBar;

import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.items.Food;
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
		
		gl.frame.progressBar_1 = new JProgressBar();
		gl.frame.progressBar_2 = new JProgressBar();
		gl.frame.progressBar_3 = new JProgressBar();
		gl.frame.progressBar_4 = new JProgressBar();
		gl.frame.progressBar_5 = new JProgressBar();
		gl.frame.textArea = new TextArea();
		
		gl.wagon.addItem(new Food(), 1000);
		Breeder guy = new Breeder("Guy");
		GenericPerson gal = new GenericPerson("Gal");
		GenericPerson boy = new GenericPerson("Boy");
		GenericPerson girl = new GenericPerson("Girl");
		GenericPerson hermaphrodite = new GenericPerson("Hermaphrodite");
		
		gl.party.add(guy);
		gl.party.add(gal);	
		gl.party.add(boy);	
		gl.party.add(girl);	
		gl.party.add(hermaphrodite);	
		
		gl.pace = 15; //Grueling
		gl.rations = 2*5; //meager
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(gal.getHealth(), 100);
		
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 99);
		assertEquals(guy.getFatigue(), 17);
		assertEquals(boy.getHealth(), 99);
		assertEquals(boy.getFatigue(), 17);
		
		
		gl.pace = 10; //Normal
		gl.rations = 0; //none
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 99);
		assertEquals(guy.getFatigue(), 32);
		assertEquals(girl.getHealth(), 99);
		assertEquals(girl.getFatigue(), 32);
		
		gl.pace = 5;   //Leisurely
		gl.rations = 1*5; //bare-bones
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(guy.getFatigue(), 32);
		assertEquals(hermaphrodite.getHealth(), 100);
		assertEquals(hermaphrodite.getFatigue(), 32);
		
		gl.pace = 0; //Stopped
		gl.rations = 4*5; //Well-fed
		gl.updateHealth();
		
		assertEquals(guy.getHealth(), 100);
		assertEquals(guy.getFatigue(), 17);
		assertEquals(gal.getHealth(), 100);
		assertEquals(gal.getFatigue(), 17);
		
		gl.pace = 15;	//Grueling
		gl.rations = 3*5; // Normal
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
		
		guy.setHealth(1);
		gal.setHealth(1);
		boy.setHealth(1);
		girl.setHealth(1);
		hermaphrodite.setHealth(1);

		gl.updateHealth();
		
		assertEquals(gl.gameover, true);
	}
	
}
