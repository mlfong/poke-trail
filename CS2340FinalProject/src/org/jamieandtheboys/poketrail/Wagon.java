package org.jamieandtheboys.poketrail;

import java.util.HashMap;
import org.jamieandtheboys.items.*;

public class Wagon
{
	private int health, weight, pace, distTraveled;
	private HashMap<Item, Integer> inventory;
	private PokeMap map;
	private static final int MAX_WEIGHT = 3500;
	private static final int GAME_LENGTH = 1;
	private double percentageToNext;

	/**
	 * Constructor for Wagon
	 */
	public Wagon()
	{
		this.health = 100;
		this.weight = 0;
		this.pace = 0;
		this.distTraveled = 0;
		inventory = new HashMap<Item, Integer>();
		this.map = makeMap();
//		this.map = makeMapTest();
		this.percentageToNext = 1;
	}

	/**
	 * Creates the map for the game
	 * @return the map
	 */
		private PokeMap makeMap()
	{
		MapNode m01 = makeMapNode("Pallet Town", true, 0);
		MapNode m02 = makeMapNode("River Crossing", false, 50 * GAME_LENGTH);
		m02.isARiver=true;
		m02.riverDepth=2;
		MapNode m03 = makeMapNode("Viridian Forest", true, 45 * GAME_LENGTH);
		MapNode m04 = makeMapNode("Pewter City", true, 20 * GAME_LENGTH);
		MapNode m05 = makeMapNode("Mt. Moon", false, 40 * GAME_LENGTH);
		MapNode m06 = makeMapNode("River Crossing 2.0!", false, 60 * GAME_LENGTH);
		m06.isARiver=true;
		m04.riverDepth=2;
		MapNode m07 = makeMapNode("Vermilion City", true, 60 * GAME_LENGTH);
		MapNode m08 = makeMapNode("Dark Cave", false, 65 * GAME_LENGTH);
		MapNode m09 = makeMapNode("Lavender Town", true, 40 * GAME_LENGTH);
		MapNode m10 = makeMapNode("Celadon City", true, 45 * GAME_LENGTH);
		MapNode m11 = makeMapNode("Saffron City", true, 30 * GAME_LENGTH);
		MapNode m12 = makeMapNode("Fuchsia City", true, 55 * GAME_LENGTH);
		MapNode m13 = makeMapNode("Seafom Islands", false, 70 * GAME_LENGTH);
		MapNode m14 = makeMapNode("Cinnabar Island", true, 50 * GAME_LENGTH);
		MapNode m15 = makeMapNode("Viridian City", true, 35 * GAME_LENGTH);
		MapNode m16 = makeMapNode("Victory Road", false, 20 * GAME_LENGTH);
		MapNode m17 = makeMapNode("Indigo Plateau", false, 80 * GAME_LENGTH);
		m01.setNext(m02);
		m02.setNext(m03);
		m03.setNext(m04);
		m04.setNext(m05);
		m05.setNext(m06);
		m06.setNext(m07);
		m07.setNext(m08);
		m08.setNext(m09);
		m09.setNext(m10);
		m10.setNext(m11);
		m11.setNext(m12);
		m12.setNext(m13);
		m13.setNext(m14);
		m14.setNext(m15);
		m15.setNext(m16);
		m16.setNext(m17);
		return new PokeMap(m01, m17);
	}


	private PokeMap makeMapTest()
	{
		MapNode m01 = makeMapNode("Pallet Town", true, 0);
		MapNode m02 = makeMapNode("Viridian City", true, 50);
		MapNode m17 = makeMapNode("Indigo Plateau", false, 80);
		m01.setNext(m02);
		m02.setNext(m17);
		PokeMap map = new PokeMap(m01, m17);
		return map;
	}

	/**
	 * Helper method for makeMap()
	 * @param town the name for the location in the node
	 * @param store true if there is a store at the location, else false
	 * @param dTo distance to this location from the previous location
	 * @return the map node
	 */
	private MapNode makeMapNode(String town, boolean store, int dTo)
	{
		return new MapNode(new Location(town, store==false? null : new Store(town+" Market"), dTo));
	}


	/**
	 * Checks if current weight is greater than MAX_WEIGHT
	 * @return true if weight > MAX_WEIGHT, else false
	 */
	public boolean isOverweight()
	{
		return this.weight > MAX_WEIGHT;
	}

	public double getPercentagToNext()
	{
		return this.percentageToNext;
	}

	public int getMaxWeight()
	{
		return MAX_WEIGHT;
	}

	public int getHealth()
	{
		return this.health;
	}

	public int getWeight()
	{
		return this.weight;
	}

	public int getPace()
	{
		return this.pace;
	}

	public HashMap<Item, Integer> getInventory()
	{
		return this.inventory;
	}

	public PokeMap getMap()
	{
		return this.map;
	}

	public int getDistTraveled()
	{
		return this.distTraveled;
	}

	/**
	 * Adds the specified amount of weight to the total weight in the wagon
	 * @param weight the weight to add
	 */
	public void addWeight(int weight)
	{
		setWeight(this.weight + weight);
	}

	/**
	 * Subtracts the specified amount of weight from the total weight in the wagon
	 * @param weight the weight to subtract
	 */
	public void subWeight(int weight)
	{
		setWeight(this.weight - weight);
	}

	/**
	 * The percent of the distance traveled from the previous location to the next location
	 * @param p
	 */
	public void setPercentageToNext(double p)
	{
		this.percentageToNext = p;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	/**
	 * 
	 * @param dist
	 */
	public void addDistTraveled(int dist)
	{
		this.distTraveled += dist;
	}
	public void setDistTraveled(int dist)
	{
		this.distTraveled = dist;
	}

	/**
	 * Adds to the wagon's health by the specified amount
	 * @param health the amount of health to add
	 */
	public void addHealth(int health)
	{
		setHealth(this.health + health);
	}

	/**
	 * Subtracts from the wagon's health by the specified amount
	 * @param health the amount of health to subtract
	 */
	public void subHealth(int health)
	{
		setHealth(this.health - health);
	}

	private void setHealth(int health)
	{
		this.health = health;
	}

	public void setPace(int pace)
	{
		this.pace = pace;
	}

	/**
	 * Adds a specified amount of an Item to the inventory
	 * @param i the item to add
	 * @param amount the amount of the item to put in
	 */
	public void addItem(Item i, int amount)
	{
		Integer currAmount = this.inventory.get(i);
		if(currAmount == null)
			currAmount = 0;
		this.inventory.put(i, currAmount + amount);
	}

	/**
	 * Removes a specified amount of an Item from the inventory, if the Item is not there or amount specified is
	 * greater than amount in inventory, return.
	 * @param i the Item to remove
	 * @param amount the number of the item to remove
	 */
	public void subItem(Item i, int amount)
	{
		Integer currAmount = this.inventory.get(i);
		if(currAmount == null)//i doesn't exist
			return;
		else if(currAmount < amount) // trying to take too much
			return;
		else if(currAmount == amount) // exactly 0
			this.inventory.remove(i);
		else // subtract
			this.inventory.put(i, currAmount - amount);
	}

	/**
	 * Returns available weight of wagon
	 * @return max weight - current weight
	 */
	public int availableWeight()
	{
		return MAX_WEIGHT - this.weight;
	}

	/**
	 * Checks where in the map, the wagon is. If the wagon hits the next location, the party is sent
	 * into the store. Else update the distance traveled and percentage
	 */
	public void updateLocation()
	{
		if ( distTraveled >= this.map.getDistBetween())
		{
			if(this.map.getCurr() == this.map.getDest())
			{
				return;
				// you win the game
			}
			distTraveled = 0;
			this.map.setCurr(this.map.getCurr().getNext());
			this.map.setDistToNext(this.map.getCurr().getLocation().getDistanceTo());
			this.map.setDistBetween(this.map.getCurr().getLocation().getDistanceTo());
			System.out.println(this.map.getCurr().getLocation().getDistanceTo());
			if (this.map.getCurr().getLocation().getStore() != null)
			{
				// cue store using this.map.getCurr().getLocation.getStore()
			}
			else
			{
				// no store, proceed? add any other game elements you want
			}
			this.percentageToNext = 0;
		}//end if
		else
		{
			System.out.println("Location not hit");
			this.map.setDistToNext(this.map.getDistBetween() - distTraveled);
			this.percentageToNext = (double)distTraveled / (double)this.map.getCurr().getLocation().getDistanceTo();
		}
	}
}
