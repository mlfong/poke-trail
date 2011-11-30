package org.jamieandtheboys.poketrail;

import java.io.Serializable;

public class MapNode implements Serializable
{
	private Location location;
	private MapNode next;
	private boolean isARiver;
	private int riverDepth;
	
	/**
	 * Constructor for MapNode
	 * @param location The location the node holds
	 */
	public MapNode(Location location)
	{
		this.location = location;
		this.isARiver = false;
	}
	
	public MapNode(Location location, boolean isRiver, int depth)
	{
		this.location = location;
		this.isARiver = isRiver;
		this.riverDepth = depth;
	}
	
	public void setIsARiver(boolean b)
	{
		this.isARiver = b;
	}
	
	public void setDepth(int d)
	{
		this.riverDepth = d;
	}
	
	public void setNext(MapNode next)
	{
		this.next = next;
	}
	
	public boolean isARiver()
	{
		return this.isARiver;
	}
	
	public int getRiverDepth()
	{
		return this.riverDepth;
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
