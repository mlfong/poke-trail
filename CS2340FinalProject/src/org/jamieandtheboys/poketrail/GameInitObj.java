package org.jamieandtheboys.poketrail;
import java.util.ArrayList;

import org.jamieandtheboys.persons.Person;

/**
 * This Class is used to transfer all necessary information to 
 * either create a new game or resume a previous one.
 * More fields will be added when saving/loading is implemented
 * @author Atom Raiff
 *
 */

public class GameInitObj {
	public static ArrayList<Person> Party = new ArrayList<Person>();
	public String Pace, Rations;
	
	GameInitObj(){};
	
}
