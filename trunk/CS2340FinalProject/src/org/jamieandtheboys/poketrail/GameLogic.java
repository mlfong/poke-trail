package org.jamieandtheboys.poketrail;


import org.jamieandtheboys.UI.InGame;
import org.jamieandtheboys.UI.StartScreen;
import org.jamieandtheboys.UI.Startup;
import org.jamieandtheboys.UI.GameFrameMain;
import org.jamieandtheboys.diseases.*;
import org.jamieandtheboys.io.FileManager;
import org.jamieandtheboys.io.SaveAndLoad;
import org.jamieandtheboys.items.*;
import org.jamieandtheboys.persons.*;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GameLogic
{
	private final static int LEISURELY = 5;
	private final static int NORMAL = 10;
	private final static int FAST = 15;



	private static Random generator = new Random();
	public static GameFrameMain frame;
	public static Queue<String> maps;
	public static boolean tired = false;
	public static boolean gameover = false;
	public static Store store;
	public static Wagon wagon;
	public static ArrayList<Person> party;
	public static GameInitObj gameData = new GameInitObj();
	public static Startup dialog;
	public static int pace, previousPace, rations, tiredDuration;
	public static Integer day=0, partySize=5;
	public static boolean isNewGame = true;
	public static boolean changeNext=true;
	public static String reasonForGameover;
	private static boolean outOfFood;

	public GameLogic()
	{}

	public static void main(String[] args)
	{
		//TO-DO
		makeQueue();
		startScreen();
		//run();
		//newGame();
	}

	private static void makeQueue() {
		maps= new LinkedList<String>();
		maps.add("map1.5.png");
		maps.add("map2.png");
		maps.add("map2.5.png");
		maps.add("map3.png");
		maps.add("map3.5.png");
		maps.add("map4.png");
		maps.add("map4.5.png");
		maps.add("map5.png");
		maps.add("map5.5.png");
		maps.add("map6.png");
		maps.add("map6.5.png");
		maps.add("map7.png");
		maps.add("map7.5.png");
		maps.add("map8.png");
		maps.add("map8.5.png");
		maps.add("map9.png");
		maps.add("map9.5.png");
		maps.add("map10.png");
		maps.add("map10.5.png");
		maps.add("map11.png");
		maps.add("map11.5.png");
		maps.add("map12.png");
		
		
	}

	public static void startScreen()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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


	public static void run()
	{
		//This is where gameData unloads its information
		store = new Store("Pallet Town General Store");
		party = GameInitObj.Party;
		wagon = GameInitObj.Wagon;
		day = GameInitObj.Day;
		pace = GameInitObj.Pace;
		rations = GameInitObj.Rations;
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					frame = new GameFrameMain();
					if(!isNewGame){
						GameFrameMain.rightPanel.remove(GameFrameMain.displayPanel);
						GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
						GameFrameMain.rightPanel.updateUI();
						GameFrameMain.textArea.setText(GameInitObj.log);
						GameFrameMain.lblMiles.setText(wagon.getDistTraveled()+" Miles");
						GameFrameMain.lblPokedollars.setText(party.get(0).getMoney().toString());
						if(wagon.inventory.containsKey(new Food()))
							GameFrameMain.lblFoodSupply.setText(wagon.inventory.get(new Food()).toString());
					}
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static String update()
	{
		String notify="";
		//sub food
		if(wagon.inventory.containsKey(new Food()) && wagon.inventory.get(new Food())>rations){
			outOfFood=false;
			wagon.subItem(new Food(), rations);
			//update food label
			GameFrameMain.lblFoodSupply.setText(wagon.inventory.get(new Food()).toString());
		}
		else{
			wagon.inventory.put(new Food(), 0);
			outOfFood = true;
		}
		//move ahead on map if needed
		if(changeNext&&!(wagon.map.getCurr().equals(wagon.map.getDest()))){
			GameFrameMain.mappic.setIcon(new ImageIcon(InGame.class.getResource("/images/"+maps.poll())));
			changeNext=false;
		}
		//increase distance
		wagon.map.addToTotalDist(pace);
		//update total distance
		GameFrameMain.lblMiles.setText(wagon.map.getTotalDist() +" miles");
		wagon.map.setDistToNext(wagon.map.getDistToNext()+pace);
		//update progress bar
		GameFrameMain.progressBar.setValue((int)(((double)wagon.map.getDistToNext()/(double)wagon.map.getDistBetween())*100)); 
		randomEvent();
		if(wagon.map.getDistToNext()>=wagon.map.getDistBetween()){
			//notify reached destination and won
			if(wagon.map.getCurr().equals(wagon.map.getDest())){
				reasonForGameover = "You have reached " + wagon.map.getCurr().getLocation().getName() +"! You Win!";	
				gameover=true;
			}
			//notify reached new location
			else{
				notify = "You have reached " + wagon.map.getCurr().getLocation().getName();
				GameFrameMain.mappic.setIcon(new ImageIcon(InGame.class.getResource("/images/"+maps.poll())));
				changeNext= true;
			}
			//go to river events if new location is a river
			if(wagon.map.getCurr().isARiver()){
				GameFrameMain.rightPanel.remove(GameFrameMain.GoPanel);
				GameFrameMain.rightPanel.add(GameFrameMain.RiverPanel, "cell 0 0,growx,aligny center");
				GameFrameMain.rightPanel.updateUI();
			}
			//notify store event if new location is store
			if(wagon.map.getCurr().getLocation().getStore()!=null){
				GameFrameMain.rightPanel.remove(GameFrameMain.GoPanel);
				GameFrameMain.rightPanel.add(GameFrameMain.displayPanel, "cell 0 0,growx,aligny center");
				GameFrameMain.lblYouHave.setText("You have "+ party.get(0).getMoney() +" PokeDollars.");
				GameFrameMain.rightPanel.updateUI();
			}
			if(!gameover){
				wagon.map.setCurr(wagon.map.getCurr().getNext());
				wagon.map.setDistToNext(0);
				if(wagon.map.getCurr().getNext()!=null)
					wagon.map.setDistBetween(wagon.map.getCurr().getNext().getLocation().getDistanceTo());
				}
			}
		//increase day
		day++;
		//update day label
		GameFrameMain.days.setText(day.toString());
		updateHealth();
		//hunger levels and fatigue
		//health

		//		  Wagon.addDistTraveled( pace? ) ;
		//		w.subItem(new Food(),  ration plan?  );
		//		for(int i = 0; i < p.size(); i++)
		//		{
		//			p.get(i).setHunger( hunger )
		//			p.get(i).setFatigue( fatigue );
		//			// later, will check for health, and then death
		//		}
		//		w.updateLocation();
		return notify;

	}



	/**
	 * Text-based store simulator. For reference purposes only
	 */
	public static void storeEvent()
	{
		System.out.println("Welcome to the " + store.getName());
		System.out.println("Look at our selection of items:");
		store.printStock();
		System.out.println("Current money: $" + party.get(0).getMoney());
		System.out.println("Current weight: " + wagon.getWeight() + "lbs");
		System.out.println("Available weight: " + wagon.availableWeight() + "lbs");
		Scanner sc = new Scanner(System.in);
		String choice = "";
		while(!choice.equalsIgnoreCase("quit"))
		{
			System.out.println("What do you want to buy? (or quit)");
			choice = sc.next();
			if(store.inStore(choice))
			{
				Item want = store.getItem(choice);
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
								if(cost > party.get(0).getMoney())
								{
									System.out.println("Insufficient money, going back to main menu.");
									break;
								}//end if
								else if(weight > wagon.availableWeight())
								{
									System.out.println("Insufficient room on wagon, going back to main menu.");
									break;
								}//end else if
								else
								{
									System.out.println("You have purchased " + want.getName() + " x" + a);
									wagon.addItem(want, a);
									wagon.addWeight(weight);
									party.get(0).subMoney(cost);
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
				store.printStock();
				System.out.println("Current money: $" + party.get(0).getMoney());
				System.out.println("Current weight: " + wagon.getWeight() + "lbs");
				System.out.println("Available weight: " + wagon.availableWeight() + "lbs");
			}
			else if(choice.equalsIgnoreCase("quit"))
			{
				System.out.println("Thanks for shopping at " + store.getName() + "!");
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

	public static void hunt()
	{
		if(wagon.getInventory().containsKey(new Pokeball()))
		{
			wagon.subItem(new Pokeball(), 1);
			int rand = generator.nextInt(10);
			if( rand < 4)
			{
				wagon.addItem(new Food(), 2);
				GameFrameMain.textArea.append("\nYou hunted and got 2 more food!");
				GameFrameMain.log.entry("\nYou hunted and got 2 more food!");
				GameFrameMain.lblFoodSupply.setText(wagon.inventory.get(new Food()).toString());
				
			}
			else {
				GameFrameMain.textArea.append("\nYou hunted but didn't catch anything...");
				GameFrameMain.log.entry("\nYou hunted but didn't catch anything...");
			}
		}
		else {
			GameFrameMain.textArea.append("\nYou need at least 1 Pokeball to hunt.");
			GameFrameMain.log.entry("\nYou hunted but didn't catch anything...");
		}
	}

	public static void scavenge()
	{
		if(party.get(1).getName().equals("Breeder"))
		{
			int amount = generator.nextInt(6);
			wagon.addItem(new Food(), amount);
			GameFrameMain.textArea.append("You scavenged and got "
					+ amount + " more food!");
			GameFrameMain.log.entry("You scavenged and got "
					+ amount + " more food!");
		}
		else  //Not a Breeder! Can't scavenge
		{
			GameFrameMain.textArea.append("Only breeders can scavenge.");
			GameFrameMain.log.entry("Only breeders can scavenge.");
		}
	}

	public static void updateHealth()
	{
		int minusHealth;
		int plusFatigue;
		if(pace == FAST)
		{
			minusHealth = 1;
			plusFatigue = 15;
		}
		else if(pace == NORMAL)
		{
			minusHealth = 0;
			plusFatigue = 5;
		}
		else if(pace == LEISURELY) //Leisurely or the oxen are tired
		{
			minusHealth = -1;
			plusFatigue = -5;
		}
		else //Stopped
		{
			minusHealth = -5;
			plusFatigue = -10;
		}

		if(outOfFood)
			plusFatigue +=10;
		else{
			if(rations == 0)
				plusFatigue += 10;
			if(rations == partySize)
				plusFatigue += 5;
			if(rations == 2*partySize)
				plusFatigue += 2;
			if(rations == 4*partySize)
				plusFatigue -= 5;
		}
		
		int currentSize = partySize;
		for(int i = 0; i < currentSize; i++)
		{
			Person p = party.get(i);
			if(!(p.isDead())){
				int fatigue = p.getFatigue() + plusFatigue;
				if(fatigue > 50)
				{
					p.setFatigue(50);
					minusHealth += 5;
				}
				else if(fatigue < 0)
					p.setFatigue(0);
				else
					p.setFatigue(fatigue);
	
				int health = p.getHealth() - minusHealth;
				if(health <= 0){
					String notify = p.death();
					GameFrameMain.textArea.append("\n"+notify);
					GameFrameMain.log.entry("\n"+notify);
					JOptionPane.showMessageDialog(GameFrameMain.contentPane, notify);	
					partySize--;
					rations=rations-(rations/(partySize+1));
				}
				
				else if(health > 100)
					p.setHealth(100);
				else
					p.setHealth(health);
			}
		}
		
		if(party.get(0).isDead()){
			GameFrameMain.progressBar_1.setValue(0);
		}
		else{
			GameFrameMain.progressBar_1.setValue(party.get(0).getHealth());
		}
		if(party.get(1).isDead()){
			GameFrameMain.progressBar_2.setValue(0);
		}
		else{
			GameFrameMain.progressBar_2.setValue(party.get(1).getHealth());
		}
		if(party.get(2).isDead()){
			GameFrameMain.progressBar_3.setValue(0);
		}
		else{
			GameFrameMain.progressBar_3.setValue(party.get(2).getHealth());
		}
		if(party.get(3).isDead()){
			GameFrameMain.progressBar_4.setValue(0);
		}
		else{
			GameFrameMain.progressBar_4.setValue(party.get(3).getHealth());
		}
		if(party.get(4).isDead()){
			GameFrameMain.progressBar_5.setValue(0);
		}
		else{
			GameFrameMain.progressBar_5.setValue(party.get(4).getHealth());
		}

		
		if(party.get(0).isDead()&&party.get(1).isDead()&&party.get(2).isDead()&&party.get(3).isDead()&&party.get(4).isDead()){
			reasonForGameover = "Everyone in your party has died. You lose.";
			gameover = true;
		}
	}

	private static void randomEvent()
	{
		int rand = generator.nextInt(100);
		int doItOrNo = generator.nextInt(10);
		if(doItOrNo < 3)
		{
			//Just some arbitrary numbers to decide if the random events should be done or not 
			if(rand < 5)
			{
				GameFrameMain.textArea.append("\nArticuno uses blizzard! Lose a few days");
				GameFrameMain.log.entry("\nArticuno uses blizzard! Lose a few days");
				//Replace the strings with your variables you use to keep track
				int delay = generator.nextInt(3);
				day += delay + 1;
				for(int i = 0; i < delay; i++)
					wagon.subItem(new Food(), rations);
			}
			else if(rand == 11)
			{
				if(wagon.map.getCurr().getNext() != wagon.map.getDest())
				{
					wagon.map.setCurr(wagon.map.getCurr().getNext());
					GameFrameMain.textArea.append("\nA Mew appeared and teleported you to the next area!");
					GameFrameMain.log.entry("\nA Mew appeared and teleported you to the next area!");
				}
				else
				{ /* nothing happens, we don't want auto-win */ }
			}
			else if(rand == 12)
			{
				for(int i = 1; i < partySize; i++)
				{
					party.get(i).setHealth(1);
				}
				GameFrameMain.textArea.append("\nA Charizard burned your entire party, luckily you were not hurt!");
				GameFrameMain.log.entry("\nA Charizard burned your entire party, luckily you were not hurt!");
			}
			else if(rand == 13)
			{
				for(int i = 0; i < partySize; i++)
					party.get(i).setDisease(new Poison());
				GameFrameMain.textArea.append("\nEKANS, EKANS EVERYWHERE. Your entire party was poisoned!");
				GameFrameMain.log.entry("\nEKANS, EKANS EVERYWHERE. Your entire party was poisoned!");

			}
			else if(rand >= 10 && rand < 18)
			{
				//Team rocket steals something!
				int rand2 = generator.nextInt(7);
				if(rand2 == 0 && wagon.getInventory().containsKey(new Clothing()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new Clothing())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new Clothing(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole " + rand3+" amount of clothes!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole " + rand3+" amount of clothes!");
				}
				if(rand2 == 1 && wagon.getInventory().containsKey(new Food()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new Food())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new Food(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of food!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole " + rand3+" amount of food!");
				}
				if(rand2 == 2 && wagon.getInventory().containsKey(new FullHeal()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new FullHeal())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new FullHeal(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Medicine!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole " + rand3+" amount of Medicine!");
				}
				if(rand2 == 3 && wagon.getInventory().containsKey(new Pokeball()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new Pokeball())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new Pokeball(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Pokeballs!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole " + rand3+" amount of Pokeballs!");
				}
				if(rand2 == 4 &&  wagon.getInventory().containsKey(new SpareAxle()))
				{
					wagon.subItem(new SpareAxle(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Axle!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole a Spare Axle!");
				}
				if(rand2 == 5 && wagon.getInventory().containsKey(new SpareTongue()))
				{
					wagon.subItem(new SpareTongue(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Tongue!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole a Spare Tongue!");
				}
				if(rand2 == 6 && wagon.getInventory().containsKey(new SpareWheel()))
				{
					wagon.subItem(new SpareWheel(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Wheel!");
					GameFrameMain.log.entry("\nOh no! Team Rocket stole a Spare Wheel!");
				}
			}
			else if(rand >= 65 && rand < 70)
			{
				if(party.get(1).equals("Trainer"))
				{
					GameFrameMain.textArea.append("\nWagon part is broken! But with your amazing trainer skills, you fixed it. All is well.");
					GameFrameMain.log.entry("\nWagon part is broken! But with your amazing trainer skills, you fixed it. All is well.");
				}
				else
				{
					int rand2 = generator.nextInt(3);
					if(rand2 == 0 && wagon.getInventory().get(new SpareAxle())!=null)
					{
						wagon.subItem(new SpareAxle(), 1);
						GameFrameMain.textArea.append("\nWagon axle is broken!");
						GameFrameMain.log.entry("\nWagon axle is broken!");
					}
					else if(rand2 == 1 && wagon.getInventory().get(new SpareTongue())!=null)
					{
						wagon.subItem(new SpareTongue(), 1);
						GameFrameMain.textArea.append("\nWagon tongue is broken!");
						GameFrameMain.log.entry("\nWagon axle is broken!");
					}
					else if(rand2 == 2 &&  wagon.getInventory().get(new SpareWheel())!=null)
					{
						wagon.subItem(new SpareWheel(), 1);
						GameFrameMain.textArea.append("\nWagon wheel is broken!");
						GameFrameMain.log.entry("\nWagon axle is broken!");
					}
					else
						tired = true; //just using the same boolean as the oxen is tired
				}
			}
			else if(rand >= 42 && rand < 49)
			{
				GameFrameMain.textArea.append("\nThe PokeFan club gives your party some food!");
				GameFrameMain.log.entry("\nThe PokeFan club gives your party some food!");
				int amount = generator.nextInt(91) + 10;
				wagon.addItem(new Food(), amount);
			}
			else if(rand >= 90 && tired == true)
			{
				int die = 0;
				if(party.get(0).getName() == "Breeder")
					die = generator.nextInt(3);
				if(die == 0)
				{
					GameFrameMain.textArea.append("\nA Tauros has died!");
					GameFrameMain.log.entry("\nA Tauros has died!");
					wagon.subItem(new Oxen(), 1);
					if(wagon.getInventory().get(new Oxen()) == null){
						gameover = true;
						reasonForGameover = "You do not have any Tauros left to pull your wagon. You lose.";
					}
						
					else{
						GameFrameMain.taurosDead((wagon.inventory.get(new Oxen())));
					}
				}
			}
			
			if(tired == true)
			{
				
				pace = LEISURELY;
				tiredDuration++;
				if(tiredDuration == 4)
				{
					GameFrameMain.textArea.append("\nTauros are feeling better!");
					GameFrameMain.log.entry("\nTauros are feeling better!");
					GameFrameMain.taurosTired(false);
					pace = previousPace;
					tired = false;
				}
			}
			else
			{
				if(pace == FAST);
				{
					if(generator.nextInt(3) == 1)
					{
						GameFrameMain.textArea.append("\nTauros is tired!");
						GameFrameMain.log.entry("\nTauros is tired!");
						GameFrameMain.taurosTired(true);
						previousPace = pace;
						tiredDuration = 0;
						tired = true;
					}
				}
			}

			//      int totalHealth = 0;
			//    for(int i = 0; i < partySize; i++)
			//       totalHealth += Party.get(i).getHealth();
			//    if(totalHealth == partySize * 100)
			//      return;

			//Generate for diseases
			for(int i = 0; i < partySize; i++)
			{
				if(party.get(i).isSick() == false)
				{
					double phealth = party.get(i).getHealth()/100;
					double pfatigue = (100 - party.get(i).getFatigue())/100;



					//Maximum chance of getting a disease is a little less than 90%
					double chance = ((1.0 - phealth*pfatigue)*20);
					if(chance > generator.nextInt(100))
					{
						int rand2 = generator.nextInt(3);
						if(rand2 == 0)
						{
							party.get(i).setDisease(new Dysentery());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Dysentery.");
							GameFrameMain.log.entry("\n"+party.get(i).getName()+" now has Dysentery.");
						}
						if(rand2 == 1)
						{
							party.get(i).setDisease(new Paralysis());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Paralysis.");
							GameFrameMain.log.entry("\n"+party.get(i).getName()+" now has Paralysis.");
						}
						if(rand2 == 2)
						{
							party.get(i).setDisease(new Poison());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Poison.");
							GameFrameMain.log.entry("\n"+party.get(i).getName()+" now has Poison.");
						}
					}
					else
					{//Player stays healthy
					}
				}
				else
				{
					if(party.get(i).getDiseaseDuration() > 7)
					{
						//Person is healthy again
						if(generator.nextInt(2) == 0)
						{
							party.get(i).setDisease(null);
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" has been cured of disease.");
							GameFrameMain.log.entry("\n"+party.get(i).getName()+" has been cured of disease.");
						}
						else
							party.get(i).doDisease();
					}
					else
						party.get(i).doDisease();
				}
			}
		}
	}

	public static void endgame(){
		frame.dispose();
	}

	public static void trade()
	{
		Random generator = new Random();
		int additem = generator.nextInt(7);
		int amount, amount2;


		Item getItem = null;
		Item loseItem = null;

		for(int i = 0; i < 2; i++)
		{
			if(additem == 0)
			{
				if(i == 0)
					getItem = new Clothing();
				else
					loseItem = new Clothing();
			}
			if(additem == 1)
			{
				if(i == 0)
					getItem = new Food();
				else
					loseItem = new Food();
			}
			if(additem == 2)
			{
				if(i == 0)
					getItem = new FullHeal();
				else
					loseItem = new Pokeball();
			}
			if(additem == 3)
			{
				if(i == 0)
					getItem = new Pokeball();
				else
					loseItem = new Pokeball();
			}
			if(additem == 4)
			{
				if(i == 0)
					getItem = new SpareAxle();
				else
					loseItem = new SpareAxle();
			}
			if(additem == 5)
			{
				if(i == 0)
					getItem = new SpareTongue();
				else
					loseItem = new SpareTongue();
			}
			if(additem == 6)
			{
				if(i == 0)
					getItem = new SpareWheel();
				else
					loseItem = new SpareWheel();
			}
			additem = generator.nextInt(7);
		}

		if(wagon.getInventory().containsKey(getItem) == false || wagon.getInventory().containsKey(loseItem) == false)
		{
			GameFrameMain.textArea.append("\nNobody is around to trade");
			GameFrameMain.log.entry("\nNobody is around to trade");
		} // No-one wants to trade
		else
		{
			int am = (int) Math.floor(wagon.getInventory().get(getItem)*.1);
			if(am==0)
				am=1;
			int am2 = (int) Math.floor(wagon.getInventory().get(loseItem)*.1);
			if(am2==0)
				am2=1;
			amount = generator.nextInt(am);
			if (amount==0)
				amount=1;
			amount2 = generator.nextInt(am2);
			if(amount2==0)
				amount2=1;

			//Display items and amounts and ask if user wants to trade
			int answer = JOptionPane.showConfirmDialog(
				    frame,
				    "Would you like to trade "+amount2+" "+loseItem.getName()+" for "+amount+" "+getItem.getName()+"?",
				    "Trading",
				    JOptionPane.YES_NO_OPTION);
				    		
			if(answer == JOptionPane.YES_OPTION) //yes
			{
				wagon.addItem(getItem, amount);
				wagon.subItem(loseItem, amount2);
				GameFrameMain.textArea.append("\nYou traded "+amount2+" "+loseItem.getName()+" for "+amount+" "+getItem.getName());
				GameFrameMain.log.entry("\nYou traded "+amount2+" "+loseItem.getName()+" for "+amount+" "+getItem.getName());
			}
			else
			{
				GameFrameMain.textArea.append("\nYou declined the trade offer");
				GameFrameMain.log.entry("\nYou declined the trade offer");

			} // trade cancelled
		}


	}

	public static String FerryCrossing()
	{
		String notify="";
		//if you have enough money
		if(party.get(0).getMoney() > 50)
		{
			party.get(0).subMoney(50);
			GameFrameMain.lblPokedollars.setText(party.get(0).getMoney()+" PokeDollars");
			notify = "You made it across the river safely.";
			GameFrameMain.rightPanel.remove(GameFrameMain.RiverPanel);
			GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
			GameFrameMain.rightPanel.updateUI();
		}
		else
			notify = "You don't have enough money!";
		return notify;
	}

	public static String FordCrossing() {
		String results="";
		int probability;

		Random random = new Random();
		if(wagon.map.getCurr().getRiverDepth() < 3)
			probability = 2;
		else
			probability = 5;

		if(random.nextInt(10)<probability)
		{
			if(random.nextInt(10)>1)
			{
				results="Your wagon flipped and you lost an item!";
				//take away an item
			}
			else{
				results="Your wagon flipped and one of your party members died!";
				//kill a party member
			}
		}
		else{
			results="You made it across the river safely.";
		}
		GameFrameMain.rightPanel.remove(GameFrameMain.RiverPanel);
		GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
		GameFrameMain.rightPanel.updateUI();
		return results;
	}

	public static String CaulkCrossing() {
		String results="";
		Random random = new Random();
		if(random.nextInt(10)<5){
			if(random.nextInt(10)>1){
				results="Your wagon flipped and you lost an item!";
				//take away an item
			}
			else{
				results="Your wagon flipped and one of your party members died!";
				//kill a member
			}
		}
		else{
			results="You made it across the river safely.";
		}
		GameFrameMain.rightPanel.remove(GameFrameMain.RiverPanel);
		GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
		GameFrameMain.rightPanel.updateUI();
		return results;
	}


	public static FileManager saveGame(){
		FileManager fm = new FileManager();
		//import data to fm
		fm.setDay(day);
		fm.setGameOver(gameover);
		fm.setPace(pace);
		fm.setTired(tired);
		fm.setRations(rations);
		fm.setParty(party);
		fm.setWagon(wagon);
		fm.setLog(GameFrameMain.textArea.getText());
		SaveAndLoad snl = new SaveAndLoad();
		snl.createUser("Ash", "password");
		snl.saveFile("Ash", fm);
		return fm;
	}

	public static void loadGame(){
		SaveAndLoad snl = new SaveAndLoad();
		FileManager fm = snl.loadSaveFile("Ash", "password");
		//import data
		GameInitObj.Party=fm.getParty();
		GameInitObj.Wagon=fm.getWagon();
		GameInitObj.Day = fm.getDay();
		GameInitObj.Pace = fm.getPace();
		GameInitObj.Rations=fm.getRations();
		GameInitObj.log=fm.getLog();
		tired = fm.getTired();
		gameover = fm.getGameOver();
	}

	public static void heal(Person person) {
		if(person.isDead())
			JOptionPane.showMessageDialog(GameFrameMain.contentPane, "You can't heal the dead!");	
		else if(wagon.inventory.containsKey(new FullHeal())){
			wagon.subItem(new FullHeal(), 1);
			person.setHealth(100);
			person.setDisease(null);
			person.setFatigue(0);
			person.setHunger(0);
			GameFrameMain.textArea.append("\n"+person.getName()+" has been fully healed!");
			GameFrameMain.log.entry("\n"+person.getName()+" has been fully healed!");
			JOptionPane.showMessageDialog(GameFrameMain.contentPane, person.getName()+" has been fully healed!");	
			//refresh health bars really fast (crappy copy pasta code)
			if(party.get(0).isDead()){
				GameFrameMain.progressBar_1.setValue(0);
			}
			else{
				GameFrameMain.progressBar_1.setValue(party.get(0).getHealth());
			}
			if(party.get(1).isDead()){
				GameFrameMain.progressBar_2.setValue(0);
			}
			else{
				GameFrameMain.progressBar_2.setValue(party.get(1).getHealth());
			}
			if(party.get(2).isDead()){
				GameFrameMain.progressBar_3.setValue(0);
			}
			else{
				GameFrameMain.progressBar_3.setValue(party.get(2).getHealth());
			}
			if(party.get(3).isDead()){
				GameFrameMain.progressBar_4.setValue(0);
			}
			else{
				GameFrameMain.progressBar_4.setValue(party.get(3).getHealth());
			}
			if(party.get(4).isDead()){
				GameFrameMain.progressBar_5.setValue(0);
			}
			else{
				GameFrameMain.progressBar_5.setValue(party.get(4).getHealth());
			}
		}
		else{
			JOptionPane.showMessageDialog(GameFrameMain.contentPane, "You don't have any medicine!");	
		}
		
	}


}
