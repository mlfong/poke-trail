package org.jamieandboys.poketrail;
import java.util.ArrayList;

import org.jamieandtheboys.items.*;

public class Store
{
	private ArrayList<Item> stock;
	private String name;
	
	public Store(String name, Item... items)
	{
		this.name = name;
		stock = new ArrayList<Item>();
		for(Item i : items)
			stock.add(i);
		
	}
	public String getName()
	{
		return this.name;
	}
	public ArrayList<Item> getStock()
	{
		return stock;
	}
	public boolean inStore(String s)
	{
		for(int i = 0; i < stock.size(); i++)
			if(stock.get(i).getName().equalsIgnoreCase(s))
				return true;
		return false;
	}
	public Item getItem(String s)
	{
		for(int i = 0; i < stock.size(); i++)
			if(stock.get(i).getName().equalsIgnoreCase(s))
				return stock.get(i);
		return null;
	}
	public void printStock()
	{
		for( int i = 0; i < stock.size(); i++ )
			System.out.println("\t" + stock.get(i));
	}
}
