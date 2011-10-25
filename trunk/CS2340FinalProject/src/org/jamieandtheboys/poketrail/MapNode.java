package org.jamieandtheboys.poketrail;

public class MapNode
{
	private Location location;
	private MapNode next;
	
	/**
	 * Constructor for MapNode
	 * @param location The location the node holds
	 */
	public MapNode(Location location)
	{
		this.location = location;
	}
	
	public void setNext(MapNode next)
	{
		this.next = next;
	}
	
	public MapNode getNext()
	{
		return this.next;
	}
	
	public Location getLocation()
	{
		return this.location;
	}
}
