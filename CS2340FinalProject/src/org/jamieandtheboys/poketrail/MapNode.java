package org.jamieandtheboys.poketrail;

import java.io.Serializable;

public class MapNode implements Serializable
{
	private Location location;
	private MapNode next;
	public boolean isARiver=false;
	public int riverDepth;
	
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
