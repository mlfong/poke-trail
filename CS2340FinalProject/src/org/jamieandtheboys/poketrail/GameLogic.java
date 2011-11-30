package org.jamieandtheboys.poketrail;


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
import java.util.Random;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GameLogic
{
	private final static int LEISURELY = 3;
	private final static int NORMAL = 5;
	private final static int FAST = 7;



	private static Random generator = new Random();
	static GameFrameMain frame;

	public static boolean tired = false;
	public static boolean gameover = false;
	public static Store store;
	public static Wagon wagon;
	public static ArrayList<Person> party;
	public static GameInitObj gameData = new GameInitObj();
	public static Startup dialog;
	public static int pace, rations;
	public static PokeMap map;
	public static Integer day=0;
	public static boolean isNewGame = true;
	

	public static void main(String[] args)
	{
		//TO-DO
		startScreen();
		//run();
		//newGame();
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
		if(wagon.inventory.containsKey(new Food()) && wagon.inventory.get(new Food())>0){
			wagon.subItem(new Food(), rations);
			//update food label
			GameFrameMain.lblFoodSupply.setText(wagon.inventory.get(new Food()).toString());
		}
		else{
			//set out-of-food variable
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
				notify = "You have reached " + wagon.map.getCurr().getLocation().getName() +"! You Win!";	
				gameover=true;
			}
			//notify reached new location
			else{
				notify = "You have reached " + wagon.map.getCurr().getLocation().getName();
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
			wagon.map.setCurr(wagon.map.getCurr().getNext());
			wagon.map.setDistToNext(0);
			if(wagon.map.getCurr().getNext()!=null)
				wagon.map.setDistBetween(wagon.map.getCurr().getNext().getLocation().getDistanceTo());
		}
		//increase day
		day++;
		//update day label
		GameFrameMain.days.setText(day.toString());
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
				GameFrameMain.textArea.append("You hunted and got 2 more food!");
			}
			else
				GameFrameMain.textArea.append("You hunted but didn't catch anything...");
		}
		else
			GameFrameMain.textArea.append("You need at least 1 Pokeball to hunt.");
	}
	
	public static void scavenge()
	{
		if(party.get(1).getName().equals("Breeder"))
		{
			int amount = generator.nextInt(6);
			wagon.addItem(new Food(), amount);
			GameFrameMain.textArea.append("You scavenged and got "
					+ amount + " more food!");
		}
		else  //Not a Breeder! Can't scavenge
		{
			GameFrameMain.textArea.append("Only breeders can scavenge.");
		}
	}
	
	private static void updateHealth()
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
			plusFatigue = 10;
		}
		else //Leisurely or the oxen are tired
		{
			minusHealth = -1;
			plusFatigue = 5;
		}
		
		if(rations == 0)
			plusFatigue += 10;
		if(rations == party.size())
			plusFatigue += 5;
		if(rations == 2*party.size())
			plusFatigue += 2;
		if(rations == 4*party.size())
			plusFatigue -= 5;
		
		for(int i = 0; i < party.size(); i++)
		{
			Person p = party.get(i);
			int fatigue = p.getFatigue() + plusFatigue;
			if(fatigue >= 100)
			{
				p.setFatigue(100);
				minusHealth += 10;
			}
			
			int health = p.getHealth() - minusHealth;
			if(health <= 0)
				//remove the player?
				party.remove(i);
			else
				p.setHealth(health);
		}
		
		if(party.size() <= 0)
			gameover = true;
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
				GameFrameMain.textArea.append("Articuno uses blizzard! Lose a few days");
				//Replace the strings with your variables you use to keep track
				int delay = generator.nextInt(3);
				day += delay + 1;
				for(int i = 0; i < delay; i++)
					wagon.subItem(new Food(), rations);
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
				}
				if(rand2 == 1 && wagon.getInventory().containsKey(new Food()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new Food())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new Food(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of food!");
				}
				if(rand2 == 2 && wagon.getInventory().containsKey(new FullHeal()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new FullHeal())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new FullHeal(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Medicine!");
				}
				if(rand2 == 3 && wagon.getInventory().containsKey(new Pokeball()) == true)
				{
					int amount = (int) ((int) wagon.getInventory().get(new Pokeball())*.10);
					int rand3 = generator.nextInt(amount);
					wagon.subItem(new Pokeball(), rand3);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Pokeballs!");
				}
				if(rand2 == 4 &&  wagon.getInventory().containsKey(new SpareAxle()))
				{
					wagon.subItem(new SpareAxle(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Axle!");
				}
				if(rand2 == 5 && wagon.getInventory().containsKey(new SpareTongue()))
				{
					wagon.subItem(new SpareTongue(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Tongue!");
				}
				if(rand2 == 6 && wagon.getInventory().containsKey(new SpareWheel()))
				{
					wagon.subItem(new SpareWheel(), 1);
					GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Wheel!");
				}
			}
			else if(rand >= 65 && rand < 70)
			{
				GameFrameMain.textArea.append("\nWagon part is broken!");
				if(party.get(1).equals("Trainer"))
				{
					//do nothing, the carpenter can fix the part
				}
				else
				{
					int rand2 = generator.nextInt(3);
					if(rand2 == 0 && wagon.getInventory().get(new SpareAxle())!=null)
					{
						wagon.subItem(new SpareAxle(), 1);
					}
					else if(rand2 == 1 && wagon.getInventory().get(new SpareTongue())!=null)
					{
						wagon.subItem(new SpareTongue(), 1);
					}
					else if(rand2 == 2 &&  wagon.getInventory().get(new SpareWheel())!=null)
					{
						wagon.subItem(new SpareWheel(), 1);
					}
					else
						tired = true; //just using the same boolean as the oxen is tired
				}
			}
			else if(rand >= 42 && rand < 49)
			{
				GameFrameMain.textArea.append("\nThe PokeFan club gives your party some food!");
				int amount = generator.nextInt(91) + 10;
				wagon.addItem(new Food(), amount);
			}
			else if(rand >= 90 && tired == true)
			{
				GameFrameMain.textArea.append("\nA Tauros has died!");
				wagon.subItem(new Oxen(), 1);
				if(wagon.getInventory().get(new Oxen()) <= 0)
					gameover = true;
			}


			if(tired == true)
			{
				GameFrameMain.textArea.append("\nTauros is tired!"); 
				/*Temporarily set wagon pace to lower pace,
				 *  I'll leave this unfinished until random events is connected
				 */
				if(pace == LEISURELY)
					tired = false;
			}
			else
			{
				if(pace == FAST);
				{
					if(generator.nextInt(2) == 1)
						tired = true;
				}
			}

			//      int totalHealth = 0;
			//    for(int i = 0; i < Party.size(); i++)
			//       totalHealth += Party.get(i).getHealth();
			//    if(totalHealth == Party.size() * 100)
			//      return;

			//Generate for diseases
			for(int i = 0; i < party.size(); i++)
			{
				if(party.get(i).isSick() == false)
				{
					double phealth = party.get(i).getHealth()/100;
					double pfatigue = (100 - party.get(i).getFatigue())/100;



					//Maximum chance of getting a disease is a little less than 90%
					double chance = ((1.0 - phealth*pfatigue)*90);
					if(chance > generator.nextInt(100))
					{
						int rand2 = generator.nextInt(3);
						if(rand2 == 0)
						{
							party.get(i).setDisease(new Dysentery());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Dysentery.");
						}
						if(rand2 == 1)
						{
							party.get(i).setDisease(new Paralysis());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Paralysis.");
						}
						if(rand2 == 2)
						{
							party.get(i).setDisease(new Poison());
							GameFrameMain.textArea.append("\n"+party.get(i).getName()+" now has Poison.");
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
							party.get(i).setDisease(null);
						GameFrameMain.textArea.append("\n"+party.get(i).getName()+" has been cured of disease.");
					}
					party.get(i).doDisease();
				}
			}
		}
	}

	public static void endgame(){
		frame.dispose();
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
		GameFrameMain.rightPanel.remove(GameFrameMain.RiverPanel);
		GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
		GameFrameMain.rightPanel.updateUI();
		return results;
	}


	public static void saveGame(){
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


}
