package org.jamieandboys.poketrail;

import java.util.HashMap;
import org.jamieandtheboys.items.*;

public class Wagon
{
	private int health, weight, pace;
	public HashMap<Item, Integer> inventory;
	
	private static final int MAX_WEIGHT = 3500;
	
	/**
	 * Constructor for Wagon
	 */
	public Wagon()
	{
		this.health = 100;
		this.weight = 0;
		this.pace = 0;
		inventory = new HashMap<Item, Integer>();
	}
	
	/**
	 * Checks if current weight is greater than MAX_WEIGHT
	 * @return true if weight > MAX_WEIGHT, else false
	 */
	public boolean isOverweight()
	{
		return this.weight > MAX_WEIGHT;
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
	
	public void setWeight(int weight)
	{
		this.weight = weight;
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
		if(this.inventory.containsKey(i)){
			this.inventory.put(i, this.inventory.get(i) + amount);
		}
		else
			setItem(i, amount);
	}
	
	/**
	 * Removes a specified amount of an Item from the inventory, if the Item is not there or amount specified is
	 * greater than amount in inventory, return.
	 * @param i the Item to remove
	 * @param amount the number of the item to remove
	 */
	public void subItem(Item i, int amount)
	{
		if(this.inventory.containsKey(i))
		{
			if(this.inventory.get(i) < amount)
				return;
			else{
				this.inventory.put(i, this.inventory.get(i) - amount);
			}
		}
		else
			return;
	}
	
	/**
	 * Sets existing Item in inventory to specified amount
	 * @param i Item to set
	 * @param amount amount to set Item to
	 */
	private void setItem(Item i, int amount)
	{
		this.inventory.put(i, amount);
	}
	
	/**
	 * Returns available weight of wagon
	 * @return max weight - current weight
	 */
	public int availableWeight()
	{
		return MAX_WEIGHT - this.weight;
	}
}
