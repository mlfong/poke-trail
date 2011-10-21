package org.jamieandtheboys.poketrail;

public class Location
{
	private String name;
	private Store store;
	private int distanceTo;
	
	public Location(String name, Store store, int dTo)
	{
		this.name = name;
		this.store = store;
		this.distanceTo = dTo;
	}
	
	public String getName()
	{
		return this.name;
	}
	public Store getStore()
	{
		return this.store;
	}
	public int getDistanceTo()
	{
		return this.distanceTo;
	}
}
