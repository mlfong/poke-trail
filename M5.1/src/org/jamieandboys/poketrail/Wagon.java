package org.jamieandboys.poketrail;

import java.util.HashMap;
import org.jamieandtheboys.items.*;

public class Wagon
{
	private int health, weight, pace;
	private HashMap<Item, Integer> inventory;
	
	private static final int MAX_WEIGHT = 3500;
	
	public Wagon()
	{
		this.health = 100;
		this.weight = 0;
		this.pace = 0;
		inventory = new HashMap<Item, Integer>();
	}
	
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
	
	public void addWeight(int weight)
	{
		setWeight(this.weight + weight);
	}
	
	public void subWeight(int weight)
	{
		setWeight(this.weight - weight);
	}
	
	private void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public void addHealth(int health)
	{
		setHealth(this.health + health);
	}
	
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
	
	public void addItem(Item i, int amount)
	{
		if(this.inventory.containsKey(i))
			this.inventory.put(i, this.inventory.get(i) + amount);
		else
			setItem(i, amount);
	}
	
	public void subItem(Item i, int amount)
	{
		if(this.inventory.containsKey(i))
		{
			if(this.inventory.get(i) < amount)
				return;
			else
				this.inventory.put(i, this.inventory.get(i) - amount);
		}
		else
			return;
	}
	
	private void setItem(Item i, int amount)
	{
		this.inventory.put(i, amount);
	}
}
