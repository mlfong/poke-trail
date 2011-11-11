package org.jamieandtheboys.io;

public class Test {
	public static void main(String[] args)
	{
		SaveAndLoad manager = new SaveAndLoad();

		

		boolean success = manager.exists("Wisdom");
		System.out.println(success);
	}
}
