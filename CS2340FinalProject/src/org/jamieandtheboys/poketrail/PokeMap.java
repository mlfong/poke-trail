package org.jamieandtheboys.poketrail;

public class PokeMap
{
	private MapNode head;
	private MapNode curr;
	private MapNode dest;
	private int distToNext;
	private int totalDist;
	
	public PokeMap(MapNode head, MapNode dest)
	{
		this.head = head;
		this.curr = head;
		this.dest = dest;
		distToNext = 0;
		totalDist = 0;
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
	public int getTotalDist()
	{
		return this.totalDist;
	}
	public MapNode getDest()
	{
		return this.dest;
	}
	public void addToTotalDist(int dist)
	{
		this.totalDist += dist;
	}
	public void setDistToNext(int dist)
	{
		this.distToNext = dist;
	}
	public void setCurr(MapNode curr)
	{
		this.curr = curr;
	}
}
