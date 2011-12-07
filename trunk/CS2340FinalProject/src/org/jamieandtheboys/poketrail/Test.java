package org.jamieandtheboys.poketrail;

import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.io.SaveAndLoad;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;

import java.util.HashMap;

public class Test
{
	public static void main(String[] args)
	{
//		testHashSL();
//		mapTest();

		Wagon w = new Wagon();
		w.addItem(new Clothing(), 5);

		Item clothes = new Clothing();
		
		System.out.println(w.getInventory().containsKey(clothes));
		System.out.println(w.getInventory().get(clothes));
		
	}

	public static void mapTest()
	{
		Wagon w = new Wagon();

		int count = 10;
		int stuff = 0;
		while(stuff <= 130)
			{
			stuff += 10;
			w.addDistTraveled(count) ;
			//		w.subItem(new Food(),  ration plan?  );
			/*for(int i = 0; i < p.size(); i++)
			{
//				p.get(i).setHunger( hunger )
//				p.get(i).setFatigue( fatigue );
				// later, will check for health, and then death
			}*/
			w.updateLocation();
			System.out.println(stuff);
			}

	}

	private static MapNode makeMapNode(String town, boolean store, int dTo)
	{
		return new MapNode(new Location(town, store==false? null : new Store(town+" Market"), dTo));
	}


	public static void testHashSL()
	{
		/*
		//test hashing for save and loading
		String s = "jamieandtheboys";
		//		String pw = "33mdmamdasndamd";
		String pw = "33mdmsam..././4&#*$";
		int divide = pw.length() / 2;
		int m = SaveAndLoad.convertToInt( pw.substring(0, divide) );
		int a = SaveAndLoad.convertToInt( pw.substring(divide) );
		System.out.println(m + " " + a);
		//		int d = convertToInt( pw.substring(2*divide) );

		String s2 = "";
		for(int i = 0; i < s.length(); i++)
			s2 += "" + (char)(((s.charAt(i) * m ) + a ));

		String s3 = "";
		for(int i = 0; i < s2.length(); i++)
			s3 += "" + (char)(((s2.charAt(i) ) - a) / m);

		System.out.println(s);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s.length() == s3.length());
		System.out.println(s.equals(s3));*/
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
