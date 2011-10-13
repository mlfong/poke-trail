package org.jamieandboys.poketrail;
import java.util.ArrayList;

import org.jamieandtheboys.items.*;

public class Store
{
	private ArrayList<Item> stock;
	private String name;
	private ArrayList<Item> cart;
	
	/**
	 * Constructor for store
	 * @param name The name of the store
	 * @param items a variable parameter taking in the items that the store will sell
	 */
	public Store(String name, Item... items)
	{
		this.name = name;
		stock = new ArrayList<Item>();
		for(Item i : items)
			stock.add(i);
		
	}
	
	public Store(String name){
		this(name, new Food(), new FullHeal(), new Pokeball(), new SpareAxle(), new SpareTongue(), new SpareWheel(), new Clothing(), new Oxen());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public ArrayList<Item> getStock()
	{
		return stock;
	}
	
	/**
	 * Checks if an item is in the store, given the Item name
	 * @param s the name of the item to search for
	 * @return true if item is in store, else false
	 */
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
