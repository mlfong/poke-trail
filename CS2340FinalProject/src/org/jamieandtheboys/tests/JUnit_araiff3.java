package org.jamieandtheboys.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.jamieandtheboys.UI.GameFrameMain;
import org.jamieandtheboys.io.FileManager;
import org.jamieandtheboys.persons.GenericPerson;
import org.jamieandtheboys.persons.Person;
import org.jamieandtheboys.poketrail.GameLogic;
import org.jamieandtheboys.poketrail.Wagon;
import org.junit.Test;

/**
 * Tests to make sure that Saving and Loading Games work correctly
 * This is a combination of three classes:
 * FileManager
 * SaveAndLoad
 * UserList
 * @author User
 *
 */
public class JUnit_araiff3 
{
	@Test
	public void testSaveGame()
	{

		
		GameLogic.day= 7;
		GameLogic.gameover = false;
		GameLogic.pace = 3;
		GameLogic.tired = false;
		GameLogic.rations = 10;
		ArrayList<Person> party = new ArrayList<Person>();
		party.add(new GenericPerson("1"));
		party.add(new GenericPerson("2"));
		party.add(new GenericPerson("3"));
		party.add(new GenericPerson("4"));
		party.add(new GenericPerson("5"));
		GameLogic.party = party;
		Wagon w = new Wagon();
		GameLogic.wagon = w;
		try {
			GameFrameMain frame = new GameFrameMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GameFrameMain.textArea.append("Knock Knock, Hurricane");
		String textareaans = GameFrameMain.textArea.getText();
		FileManager fm = GameLogic.saveGame();
		assertEquals(fm.getDay(), GameLogic.day);
		assertEquals(fm.getGameOver(), GameLogic.gameover);
		assertEquals(fm.getPace(), (Integer) GameLogic.pace);
		assertEquals(fm.getTired(), GameLogic.tired);
		assertEquals(fm.getRations(), (Integer) GameLogic.rations);
		assertEquals(fm.getParty().equals(party), true);
		assertEquals(fm.getWagon().equals(w), true);
		assertEquals(fm.getLog(), textareaans);
	}
	@Test
	public void testLoadGame()
	{

		GameLogic.loadGame();
		assertEquals(GameLogic.day, (Integer) 7);
		assertEquals(GameLogic.gameover , false);
		assertEquals((Integer) GameLogic.pace, (Integer) 3);
		assertEquals(GameLogic.tired , false);
		assertEquals((Integer)GameLogic.rations ,(Integer) 10);
		ArrayList<Person> party = new ArrayList<Person>();
		party.add(new GenericPerson("1"));
		party.add(new GenericPerson("2"));
		party.add(new GenericPerson("3"));
		party.add(new GenericPerson("4"));
		party.add(new GenericPerson("5"));
		assertEquals(GameLogic.party.get(0).getName(),"1");
		assertEquals(GameLogic.party.get(1).getName(),"2");
		assertEquals(GameLogic.party.get(2).getName(),"3");
		assertEquals(GameLogic.party.get(3).getName(),"4");
		assertEquals(GameLogic.party.get(4).getName(),"5");
		assertEquals(GameLogic.wagon.getInventory() , new Wagon().getInventory());
	}
}
