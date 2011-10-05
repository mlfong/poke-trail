package org.jamieandboys.poketrail;

import org.jamieandboys.diseases.*;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;

import java.util.HashMap;

public class Test
{
	public static void main(String[] args)
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
