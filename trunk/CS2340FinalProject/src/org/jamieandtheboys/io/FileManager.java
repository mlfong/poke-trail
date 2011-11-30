package org.jamieandtheboys.io;
import java.io.Serializable;
import java.util.ArrayList;

import org.jamieandtheboys.persons.*;
import org.jamieandtheboys.poketrail.Wagon;

public class FileManager implements Serializable
{
	private Integer Day;
	private Wagon wagon;
	private ArrayList<Person> Party = new ArrayList<Person>();
	private boolean tired, gameover;
	private int Pace, Rations;
	private String log;
	
	public FileManager()
	{
		wagon = null;
	}
	
	public void setParty(ArrayList<Person> Party)
	{
		this.Party=Party;
	}
	public void setLog(String log)
	{
		this.log=log;
	}
	public String getLog()
	{
		return log;
	}
	public void setWagon(Wagon w)
	{
		wagon = w;
	}
	public void setTired(boolean tired)
	{
		this.tired=tired;
	}
	public void setGameOver(boolean gameover)
	{
		this.gameover=gameover;
	}
	public void setDay(Integer Day)
	{
		this.Day = Day;
	}
	public void setPace(int Day)
	{
		this.Pace = Day;
	}
	public void setRations(int Day)
	{
		this.Rations = Day;
	}
	public boolean getGameOver()
	{
		return gameover;
	}
	public Integer getPace()
	{
		return Pace;
	}
	public Integer getRations()
	{
		return Rations;
	}
	public Integer getDay()
	{
		return Day;
	}
	public boolean getTired()
	{
		return tired;
	}
	public Wagon getWagon()
	{
		return wagon;
	}
	public ArrayList<Person> getParty()
	{
		return Party;
	}
}
