package org.jamieandtheboys.poketrail;


import org.jamieandtheboys.UI.Startup;
import org.jamieandtheboys.UI.GameFrameMain;
import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JDialog;

public class GameLogic
{
	private final static int LEISURELY = 3;
	private final static int NORMAL = 5;
	private final static int FAST = 7;
	private static Random generator = new Random();
	static GameFrameMain frame;
	
	public static boolean tired = false;
	public static boolean gameover = false;
	public static Store s;
	public static Wagon w;
	public static ArrayList<Person> p;
	public static GameInitObj gameData = new GameInitObj();
	public static Startup dialog;
	public static void main(String[] args)
	{
		//TO-DO
		//		startScreen();
		//run();
		newGame();
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
		//new game dialogue
		try {
			dialog = new Startup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	public static void loadGame()
	{
		// we can save this for later
	}

	public static void run()
	{
		s = new Store("Pallet Town General Store");
		p = GameInitObj.Party;
		w = new Wagon();

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					frame = new GameFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void update()
	{
		/*
		  w.addDistTraveled( pace? ) ;
		w.subItem(new Food(),  ration plan?  );
		for(int i = 0; i < p.size(); i++)
		{
			p.get(i).setHunger( hunger )
			p.get(i).setFatigue( fatigue );
			// later, will check for health, and then death
		}
		w.updateLocation();
		 */
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


	private static void randomEvent()
	{
		int rand = generator.nextInt(100);
		
		//Just some arbitrary numbers to decide if the random events should be done or not 
		if(rand < 5)
		{
			//Articuno uses blizzard! Lose a few days
			//Replace the strings with your variables you use to keep track
			int delay = generator.nextInt(3);
			"day" += delay + 1;
			for(int i = 0; i < delay; i++)
				w.subItem(new Food(), "rations");
		}
		else if(rand >= 10 && rand < 18)
		{
			//Team rocket steals something!
			int rand2 = generator.nextInt(7);
			if(rand2 == 0)
			{
				int amount = (int) ((int) w.getInventory().get(new Clothing())*.10);
				int rand3 = generator.nextInt(amount);
				w.subItem(new Clothing(), rand3);
			}
			if(rand2 == 1)
			{
				int amount = (int) ((int) w.getInventory().get(new Food())*.10);
				int rand3 = generator.nextInt(amount);
				w.subItem(new Food(), rand3);
			}
			if(rand2 == 2)
			{
				int amount = (int) ((int) w.getInventory().get(new FullHeal())*.10);
				int rand3 = generator.nextInt(amount);
				w.subItem(new FullHeal(), rand3);
			}
			if(rand2 == 3)
			{
				int amount = (int) ((int) w.getInventory().get(new Pokeball())*.10);
				int rand3 = generator.nextInt(amount);
				w.subItem(new Pokeball(), rand3);
			}
			if(rand2 == 4 && (int) w.getInventory().get(new SpareAxle()) > 0)
			{
				w.subItem(new SpareAxle(), 1);
			}
			if(rand2 == 5 && (int) w.getInventory().get(new SpareTongue()) > 0)
			{
				w.subItem(new SpareTongue(), 1);
			}
			if(rand2 == 6 && (int) w.getInventory().get(new SpareWheel()) > 0)
			{
				w.subItem(new SpareWheel(), 1);
			}
		}
		else if(rand >= 65 && rand < 70)
		{
			//Wagon part is broken!
			int rand2 = generator.nextInt(3);
			if(rand2 == 0 && (int) w.getInventory().get(new SpareAxle()) > 0)
			{
				w.subItem(new SpareAxle(), 1);
			}
			else if(rand2 == 1 && (int) w.getInventory().get(new SpareTongue()) > 0)
			{
				w.subItem(new SpareTongue(), 1);
			}
			else if(rand2 == 2 && (int) w.getInventory().get(new SpareWheel()) > 0)
			{
				w.subItem(new SpareWheel(), 1);
			}
			else
				tired = true;
		}
		else if(rand >= 42 && rand < 49)
		{
			//The PokeFan club gives your party some food!
			int amount = generator.nextInt(91) + 10;
			w.addItem(new Food(), amount);
		}
		else if(rand >= 90 && tired == true)
		{
			//A Tauros has died!
			w.subItem(new Oxen(), 1);
			if(w.getInventory().get(new Oxen()) <= 0)
				gameover = true;
		}
		
		//Tauros is tired! 
		if(tired == true)
		{
			/*Temporarily set wagon pace to lower pace,
			 *  I'll leave this unfinished until random events is connected
			 */
			if(w.getPace() == "leisurely")
				tired = false;
		}
		else
		{	//You'll have to replace grueling with whatever you're using to keep track of pace
			if(w.getPace() == "grueling" || "Been on steady pace for ten turns straight or more");
			{
				if(generator.nextInt(2) == 1)
					tired = true;
			}
		}
		
		
		//Generate for diseases
		for(int i = 0; i < p.size(); i++)
		{
			if(p.get(i).isSick() == false)
			{
				double phealth = p.get(i).getHealth()/100;
				double pfatigue = p.get(i).getFatigue()/100;

				//Maximum chance of getting a disease is a little less than 90%
				int chance = (int) ((1 - phealth*pfatigue)*90);
				if(chance >= generator.nextInt(100))
				{
					int rand2 = generator.nextInt(3);
					if(rand2 == 0)
					{
						p.get(i).setDisease(new Dysentery());
					}
					if(rand2 == 1)
					{
						p.get(i).setDisease(new Paralysis());
					}
					if(rand2 == 2)
					{
						p.get(i).setDisease(new Poison());
					}
				}
				else
				{//Player stays healthy
				}
			}
			else
			{
				if(p.get(i).getDiseaseDuration() > 7)
				{
					//Person is healthy again
					if(generator.nextInt(2) == 0)
						p.get(i).setDisease(null);
				}
				p.get(i).doDisease();
			}
			//To Do: Remove diseases after a certain amount of time has passed
		}
	}

	public static void endgame(){
		frame.dispose();
	}
}
