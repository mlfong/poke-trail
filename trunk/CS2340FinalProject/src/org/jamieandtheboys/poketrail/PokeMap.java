package org.jamieandtheboys.poketrail;

import java.io.Serializable;

public class PokeMap implements Serializable
{
	private MapNode head;
	private MapNode curr;
	private MapNode dest;
	private int distToNext;
	private int totalDist;
	private int between;
	
	/**
	 * The Map for the game
	 * @param head the head MapNode, this is the location where the player will start
	 * @param dest the next location to travel to, acts as the next node in the linked list
	 */
	public PokeMap(MapNode head, MapNode dest)
	{
		this.head = head;
		this.curr = head;
		this.dest = dest;
		distToNext = 0;
		totalDist = 0;
		between = curr.getNext().getLocation().getDistanceTo();
	}
	
	public MapNode getHead()
	{
		return this.head;
	}
	
	public MapNode getCurr()
	{
		return this.curr;
	}
	
	public int getDistToNext()
	{
		return this.distToNext;
	}
	
	public int getDistBetween()
	{
		return this.between;
	}
	
	public int getTotalDist()
	{
		return this.totalDist;
	}
	
	public MapNode getDest()
	{
		return this.dest;
	}
	
	/**
	 * Adds to total distance needed to travel, do we need this function?
	 * @param dist the distance to add
	 */
	public void addToTotalDist(int dist)
	{
		this.totalDist += dist;
	}
	
	public void setDistToNext(int dist)
	{
		this.distToNext = dist;
	}
	
	public void setDistBetween(int bet)
	{
		between = bet;
	}
	
	public void setCurr(MapNode curr)
	{
		this.curr = curr;
	}
}
