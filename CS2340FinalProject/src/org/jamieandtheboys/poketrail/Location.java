package org.jamieandtheboys.poketrail;

import java.io.Serializable;

public class Location implements Serializable
{
	private String name;
	private Store store;
	private int distanceTo;
	
	/**
	 * Constructor for Location
	 * @param name the name of the location
	 * @param store the store the location holds, is null if there is no store
	 * @param dTo distance to this location
	 */
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
