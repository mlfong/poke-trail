package org.jamieandtheboys.items;

public abstract class Item
{
	private String name;
	private int cost, weight;
	
	/**
	 * Constructor for Item
	 * @param name the name of the item
	 * @param cost how much money the individual item costs
	 * @param weight how much the item weighs in pounds
	 */
	public Item(String name, int cost, int weight)
	{
		this.name = name;
		this.cost = cost;
		this.weight = weight;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCost()
	{
		return this.cost;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public String toString()
	{
		//return this.name + ": Cost " + this.cost + " Weight " + this.weight;
		return this.name;
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Item)
		{
			Item other = (Item)o;
			return this.name.equals(other.name);
		}
		
		return false;
	}
	public int hashCode()
	{
		int sum = 0;
		for(int i = 0; i < this.name.length(); i++)
			sum += this.name.charAt(i);
		return sum;
	}
	
}
