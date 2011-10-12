package org.jamieandboys.poketrail;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic
{
	private final static int LEISURELY = 3;
	private final static int NORMAL = 5;
	private final static int FAST = 7;
	
	public static Store s;
	public static Wagon w;
	public static ArrayList<Person> p;
	public static void main(String[] args)
	{
		//TO-DO
//		startScreen();
		run();
		//run();
	}
	
	public static void startScreen()
	{
		String s = ""+
		"/************************" + "\n" + 
		"*   start screen       *" + "\n"+ 
		 "*     image            *"+ "\n"+
		 "*                      *" + "\n"+
		 "*     new game         *" + "\n" +
 		 "*     continue         *"+ "\n"+
 		 "***********************/";
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		//if new game go to newGame()
		//else go to loadGame() <-- not called continue b/c
		// 			continue is a reserved word
	}
	
	public static void newGame()
	{
		//we must implement this
		
	}
	
	public static void loadGame()
	{
		// we can save this for later
	}
	
	public static void run()
	{
		s = new Store("Viridian Pokemart", new Food(), new FullHeal());
		p = new ArrayList<Person>();
		p.add(new Trainer("Ash"));
		w = new Wagon();
		storeEvent();
	}
	
	/**
	 * Text-based store simulator. For reference purposes only
	 */
	public static void storeEvent()
	{
		System.out.println("Welcome to the " + s.getName());
		System.out.println("Look at our selection of items:");
		s.printStock();
		System.out.println("Current money: $" + p.get(0).getMoney());
		System.out.println("Current weight: " + w.getWeight() + "lbs");
		System.out.println("Available weight: " + w.availableWeight() + "lbs");
		Scanner sc = new Scanner(System.in);
		String choice = "";
		while(!choice.equalsIgnoreCase("quit"))
		{
			System.out.println("What do you want to buy? (or quit)");
			choice = sc.next();
			if(s.inStore(choice))
			{
				Item want = s.getItem(choice);
				System.out.println("You have chosen: " + want);
				String amount = "";
				while(!amount.equalsIgnoreCase("quit"))
				{
					System.out.println("How many do you want? (or quit)");
					amount = sc.next();
					if(isNum(amount))
					{
						int a = Integer.parseInt(amount);
						int cost = a * want.getCost();
						int weight = a * want.getWeight();
						System.out.println("This will cost " + cost + " Okay (Y/N)?");
						String decision = "";
						while(!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n"))
						{
							decision = sc.next();
							if(decision.equalsIgnoreCase("y"))
							{
								if(cost > p.get(0).getMoney())
								{
									System.out.println("Insufficient money, going back to main menu.");
									break;
								}//end if
								else if(weight > w.availableWeight())
								{
									System.out.println("Insufficient room on wagon, going back to main menu.");
									break;
								}//end else if
								else
								{
									System.out.println("You have purchased " + want.getName() + " x" + a);
									w.addItem(want, a);
									w.addWeight(weight);
									p.get(0).subMoney(cost);
								}//end if
							}//end if
							else if(decision.equalsIgnoreCase("n"))
								System.out.println("Going back to main menu.");
							else
								System.out.println("Invalid choice.");
						}//end while
						amount = "quit";
					}//end if
					else
						System.out.println("Invalid choice.");
					//amount = sc.next();
				}//end while
			}//end if
			else if(choice.equalsIgnoreCase("help"))
			{
				System.out.println("Look at our selection of items:");
				s.printStock();
				System.out.println("Current money: $" + p.get(0).getMoney());
				System.out.println("Current weight: " + w.getWeight() + "lbs");
				System.out.println("Available weight: " + w.availableWeight() + "lbs");
			}
			else if(choice.equalsIgnoreCase("quit"))
			{
				System.out.println("Thanks for shopping at " + s.getName() + "!");
				break;
			}
			else
				System.out.println("Invalid choice.");
		}
	}
	
	/**
	 * Checks if the given string is an integer 
	 * @param s the string to check
	 * @return true if string representation of an int, else false
	 */
	private static boolean isNum(String s)
	{
		try { Integer.parseInt(s); }
		catch (NumberFormatException nfe)
		{return false;}
		return true;
	}
}
