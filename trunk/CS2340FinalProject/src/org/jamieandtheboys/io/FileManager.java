package org.jamieandtheboys.io;
import java.io.Serializable;

import org.jamieandtheboys.persons.*;
import org.jamieandtheboys.poketrail.Wagon;

public class FileManager implements Serializable {
	
	Wagon wagon;
	Person[] players = new Person[5];
	
	public FileManager()
	{
		wagon = null;
	}
	
	public void setPlayer(Person player)
	{
		players[0] = player;
	}
	
	public void setParty0(Person party0)
	{
		players[1] = party0;
	}
	
	public void setParty1(Person party1)
	{
		players[2] = party1;
	}
	
	public void setParty2(Person party2)
	{
		players[3] = party2;
	}
	
	public void setParty3(Person party3)
	{
		players[4] = party3;
	}
	
	public void setWagon(Wagon w)
	{
		wagon = w;
	}
	
	
	public Person getPlayer()
	{
		return players[0];
	}
	
	public Person getParty0()
	{
		return players[1];
	}
	
	public Person getParty1()
	{
		return players[2];
	}
	
	public Person getParty2()
	{
		return players[3];
	}
	
	public Person setParty3()
	{
		return players[4];
	}
	
	public Wagon getWagon()
	{
		return wagon;
	}
}
