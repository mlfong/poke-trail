package org.jamieandtheboys.poketrail;

import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;

import java.util.HashMap;

public class Test
{
	public static void main(String[] args)
	{
		testHashAdd();
		
	}
	
	public static void testHM()
	{
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		hm.put("One", 1);
		System.out.println(hm);
		hm.put("One", 2);
		System.out.println(hm);
		Food n = new Food();
		System.out.println(n);
	}
	
	public static void testHashAdd()
	{
		Wagon w = new Wagon();
		System.out.println(w.getInventory());
		w.addItem(new Food(), 2);
		System.out.println(w.getInventory());
		w.addItem(new Food(), 3);
		//should be 5
		System.out.println(w.getInventory());
		w.subItem(new Food(), 1);
		//should be 4
		System.out.println(w.getInventory());
		w.subItem(new FullHeal(), 2);
		//nothing happens
		System.out.println(w.getInventory());
		w.subItem(new Food(), 5);
		//nothing happens
		System.out.println(w.getInventory());
		w.subItem(new Food(), 4);
		System.out.println(w.getInventory());
		
		
	}
	
	public static void testM6()
	{
		Store s = new Store("Viridian PokeMart");
		s.printStock();
		Wagon w = new Wagon();
		System.out.println(w);
		w.addItem(new Food(), 4);
		System.out.println(w);
		System.out.println(w.getInventory());
		
	}
	
	public static void testM5()
	{
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("A", 1);
		hm.put("B", 2);
		System.out.println(hm);
		hm.put("A", 2);
		System.out.println(hm);
		
		System.out.println();
		Person b = new Breeder("Brock");
		b.setDisease(new Poison());
		System.out.println(b);
		
		Person t = new Trainer("Ash");
		System.out.println(t);
		
		Person p = new Professor("Oak");
		System.out.println(p);
		
		Person g = new GenericPerson("Misty");
		System.out.println(g);
		
		Item fh = new FullHeal();
		System.out.println(fh);
	}
}
