package org.jamieandtheboys.items;

public abstract class Item
{
	private String name;
	private int cost, weight;
	
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
		return this.name + ": Cost " + this.cost + " Weight " + this.weight;
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
	
}
