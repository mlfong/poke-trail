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
	public static Store Store;
	public static Wagon Wagon;
	public static ArrayList<Person> Party;
	public static GameInitObj gameData = new GameInitObj();
	public static Startup dialog;
	public static int Pace, Rations;
	public static PokeMap Map;
	public static Integer Day=0;
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
		Store = new Store("Pallet Town General Store");
		Party = GameInitObj.Party;
		Wagon = GameInitObj.Wagon;
		Day = GameInitObj.Day;
		Pace = GameInitObj.Pace;
		Rations = GameInitObj.Rations;
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
		if(Wagon.inventory.containsKey(new Food()) && Wagon.inventory.get(new Food())>0){
			Wagon.subItem(new Food(), Rations);
			//update food label
			GameFrameMain.lblFoodSupply.setText(Wagon.inventory.get(new Food()).toString());
		}
		else{
			//set out-of-food variable
		}
		//increase distance
		Wagon.map.addToTotalDist(Pace);
		//update total distance
		GameFrameMain.lblMiles.setText(Wagon.map.getTotalDist() +" miles");
		Wagon.map.setDistToNext(Wagon.map.getDistToNext()+Pace);
		//update progress bar
		GameFrameMain.progressBar.setValue((int)(((double)Wagon.map.getDistToNext()/(double)Wagon.map.getDistBetween())*100)); 
		randomEvent();
		if(Wagon.map.getDistToNext()>=Wagon.map.getDistBetween()){
			//notify reached destination and won
			if(Wagon.map.getCurr().equals(Wagon.map.getDest())){
				notify = "You have reached " + Wagon.map.getCurr().getLocation().getName() +"! You Win!";	
				gameover=true;
			}
			//notify reached new location
			else{
				notify = "You have reached " + Wagon.map.getCurr().getLocation().getName();
			}
			//go to river events if new location is a river
			if(Wagon.map.getCurr().isARiver){
				GameFrameMain.rightPanel.remove(GameFrameMain.GoPanel);
				GameFrameMain.rightPanel.add(GameFrameMain.RiverPanel, "cell 0 0,growx,aligny center");
				GameFrameMain.rightPanel.updateUI();
			}
			//notify store event if new location is store
			if(Wagon.map.getCurr().getLocation().getStore()!=null){
				GameFrameMain.rightPanel.remove(GameFrameMain.GoPanel);
				GameFrameMain.rightPanel.add(GameFrameMain.displayPanel, "cell 0 0,growx,aligny center");
				GameFrameMain.lblYouHave.setText("You have "+ Party.get(0).getMoney() +" PokeDollars.");
				GameFrameMain.rightPanel.updateUI();
			}
			Wagon.map.setCurr(Wagon.map.getCurr().getNext());
			Wagon.map.setDistToNext(0);
			if(Wagon.map.getCurr().getNext()!=null)
				Wagon.map.setDistBetween(Wagon.map.getCurr().getNext().getLocation().getDistanceTo());
			}
		//increase day
		Day++;
		//update day label
		GameFrameMain.days.setText(Day.toString());
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
		System.out.println("Welcome to the " + Store.getName());
		System.out.println("Look at our selection of items:");
		Store.printStock();
		System.out.println("Current money: $" + Party.get(0).getMoney());
		System.out.println("Current weight: " + Wagon.getWeight() + "lbs");
		System.out.println("Available weight: " + Wagon.availableWeight() + "lbs");
		Scanner sc = new Scanner(System.in);
		String choice = "";
		while(!choice.equalsIgnoreCase("quit"))
		{
			System.out.println("What do you want to buy? (or quit)");
			choice = sc.next();
			if(Store.inStore(choice))
			{
				Item want = Store.getItem(choice);
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
								if(cost > Party.get(0).getMoney())
								{
									System.out.println("Insufficient money, going back to main menu.");
									break;
								}//end if
								else if(weight > Wagon.availableWeight())
								{
									System.out.println("Insufficient room on wagon, going back to main menu.");
									break;
								}//end else if
								else
								{
									System.out.println("You have purchased " + want.getName() + " x" + a);
									Wagon.addItem(want, a);
									Wagon.addWeight(weight);
									Party.get(0).subMoney(cost);
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
				Store.printStock();
				System.out.println("Current money: $" + Party.get(0).getMoney());
				System.out.println("Current weight: " + Wagon.getWeight() + "lbs");
				System.out.println("Available weight: " + Wagon.availableWeight() + "lbs");
			}
			else if(choice.equalsIgnoreCase("quit"))
			{
				System.out.println("Thanks for shopping at " + Store.getName() + "!");
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
		int doItOrNo = generator.nextInt(10);
  if(doItOrNo < 3) {
		//Just some arbitrary numbers to decide if the random events should be done or not 
		if(rand < 5)
		{
			GameFrameMain.textArea.append("Articuno uses blizzard! Lose a few days");
			//Replace the strings with your variables you use to keep track
			int delay = generator.nextInt(3);
			Day += delay + 1;
			for(int i = 0; i < delay; i++)
				Wagon.subItem(new Food(), Rations);
		}
		else if(rand >= 10 && rand < 18)
		{
			//Team rocket steals something!
			int rand2 = generator.nextInt(7);
			if(rand2 == 0)
			{
				int amount = (int) ((int) Wagon.getInventory().get(new Clothing())*.10);
				int rand3 = generator.nextInt(amount);
				Wagon.subItem(new Clothing(), rand3);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole " + rand3+" amount of clothes!");
			}
			if(rand2 == 1)
			{
				int amount = (int) ((int) Wagon.getInventory().get(new Food())*.10);
				int rand3 = generator.nextInt(amount);
				Wagon.subItem(new Food(), rand3);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of food!");
			}
			if(rand2 == 2)
			{
				int amount = (int) ((int) Wagon.getInventory().get(new FullHeal())*.10);
				int rand3 = generator.nextInt(amount);
				Wagon.subItem(new FullHeal(), rand3);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Medicine!");
			}
			if(rand2 == 3)
			{
				int amount = (int) ((int) Wagon.getInventory().get(new Pokeball())*.10);
				int rand3 = generator.nextInt(amount);
				Wagon.subItem(new Pokeball(), rand3);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole "+rand3+" amount of Pokeballs!");
			}
			if(rand2 == 4 &&  Wagon.getInventory().get(new SpareAxle())!=null)
			{
				Wagon.subItem(new SpareAxle(), 1);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Axle!");
			}
			if(rand2 == 5 && Wagon.getInventory().get(new SpareTongue())!=null)
			{
				Wagon.subItem(new SpareTongue(), 1);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Tongue!");
				
			}
			if(rand2 == 6 && Wagon.getInventory().get(new SpareWheel()) !=null)
			{
				Wagon.subItem(new SpareWheel(), 1);
				GameFrameMain.textArea.append("\nOh no! Team Rocket stole a Spare Wheel!");
			}
		}
		else if(rand >= 65 && rand < 70)
		{
			GameFrameMain.textArea.append("\nWagon part is broken!");
			int rand2 = generator.nextInt(3);
			if(rand2 == 0 && Wagon.getInventory().get(new SpareAxle())!=null)
			{
				Wagon.subItem(new SpareAxle(), 1);
			}
			else if(rand2 == 1 && Wagon.getInventory().get(new SpareTongue())!=null)
			{
				Wagon.subItem(new SpareTongue(), 1);
			}
			else if(rand2 == 2 &&  Wagon.getInventory().get(new SpareWheel())!=null)
			{
				Wagon.subItem(new SpareWheel(), 1);
			}
			else
				tired = true;
		}
		else if(rand >= 42 && rand < 49)
		{
			GameFrameMain.textArea.append("\nThe PokeFan club gives your party some food!");
			int amount = generator.nextInt(91) + 10;
			Wagon.addItem(new Food(), amount);
		}
		else if(rand >= 90 && tired == true)
		{
			GameFrameMain.textArea.append("\nA Tauros has died!");
			Wagon.subItem(new Oxen(), 1);
			if(Wagon.getInventory().get(new Oxen()) <= 0)
				gameover = true;
		}
		
		
		if(tired == true)
		{
			GameFrameMain.textArea.append("\nTauros is tired!"); 
			/*Temporarily set wagon pace to lower pace,
			 *  I'll leave this unfinished until random events is connected
			 */
			if(Pace== LEISURELY)
				tired = false;
		}
		else
		{	//You'll have to replace grueling with whatever you're using to keep track of pace
			if(Pace == FAST);
			{
				if(generator.nextInt(2) == 1)
					tired = true;
			}
		}
		
      int totalHealth = 0;
    for(int i = 0; i < Party.size(); i++)
       totalHealth += Party.get(i).getHealth();
    if(totalHealth == Party.size() * 100)
      return;
		
		//Generate for diseases
		for(int i = 0; i < Party.size(); i++)
		{
			if(Party.get(i).isSick() == false)
			{
				double phealth = Party.get(i).getHealth()/100;
				double pfatigue = Party.get(i).getFatigue()/100;

				//Maximum chance of getting a disease is a little less than 90%
				int chance = (int) ((1 - phealth*pfatigue)*90);
				if(chance >= generator.nextInt(100))
				{
					int rand2 = generator.nextInt(3);
					if(rand2 == 0)
					{
						Party.get(i).setDisease(new Dysentery());
						GameFrameMain.textArea.append("\n"+Party.get(i).getName()+" now has Dysentery.");
					}
					if(rand2 == 1)
					{
						Party.get(i).setDisease(new Paralysis());
						GameFrameMain.textArea.append("\n"+Party.get(i).getName()+" now has Paralysis.");
					}
					if(rand2 == 2)
					{
						Party.get(i).setDisease(new Poison());
						GameFrameMain.textArea.append("\n"+Party.get(i).getName()+" now has Poison.");
					}
				}
				else
				{//Player stays healthy
				}
			}
			else
			{
				if(Party.get(i).getDiseaseDuration() > 7)
				{
					//Person is healthy again
					if(generator.nextInt(2) == 0)
						Party.get(i).setDisease(null);
					GameFrameMain.textArea.append("\n"+Party.get(i).getName()+" has been cured of disease.");
				}
				Party.get(i).doDisease();
			}
			//To Do: Remove diseases after a certain amount of time has passed
		}
           }
	}

	public static void endgame(){
		frame.dispose();
	}

	public static String FerryCrossing() {
		String notify="";
		//if you have enough money
		if(Party.get(0).getMoney()>50){
			Party.get(0).subMoney(50);
			GameFrameMain.lblPokedollars.setText(Party.get(0).getMoney()+" PokeDollars");
			notify = "You made it across the river safely.";
			GameFrameMain.rightPanel.remove(GameFrameMain.RiverPanel);
			GameFrameMain.rightPanel.add(GameFrameMain.GoPanel, "cell 0 0,growx,aligny center");
			GameFrameMain.rightPanel.updateUI();
		}
		else{
			notify = "You don't have enough money!";
		}
		return notify;
		
	}

	public static String FordCrossing() {
		String results="";
		int probability;

		Random random = new Random();
		if(Wagon.map.getCurr().riverDepth<3){
			probability = 2;
		}
		else{
			probability = 5;
		}
		
		if(random.nextInt(10)<probability){
			if(random.nextInt(10)>1){
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
		fm.setDay(Day);
		fm.setGameOver(gameover);
		fm.setPace(Pace);
		fm.setTired(tired);
		fm.setRations(Rations);
		fm.setParty(Party);
		fm.setWagon(Wagon);
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
