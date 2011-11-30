package org.jamieandtheboys.persons;

import java.io.Serializable;

import org.jamieandtheboys.diseases.*;

public abstract class Person implements Serializable
{
	private String name, type;
	private int health, hunger, money, fatigue;
	private Disease disease;
	private int diseaseDuration = 0;
	
	/**
	 * Constructor for Person
	 * @param name the name of the person
	 * @param type the Profession of the person, affects certain parts of the game
	 * @param money the amount of money the player starts with
	 */
	public Person(String name, String type, int money)
	{
		this.name = name;
		this.type = type;
		this.disease = null;
		this.health = 100;
		this.hunger = 0;
		this.fatigue = 0;
		this.money = money;
	}
	
	/**
	 * Called at the end of the turn to affect the person
	 */
	public void doDisease()
	{
		this.disease.doEffect(this);
		diseaseDuration++;
	}
	
	public int getDiseaseDuration()
	{
		return diseaseDuration;
	}
	
	public Boolean isSick()
	{
		return this.disease != null;
	}
	
	public Disease getDisease()
	{
		return this.disease;
	}
	
	public int getFatigue()
	{
		return this.fatigue;
	}

	public int getHealth()
	{
		return this.health;
	}

	public int getHunger()
	{
		return this.hunger;
	}

	public Integer getMoney()
	{
		return this.money;
	}

	public String getName()
	{
		return this.name;
	}

	public String getType()
	{
		return this.type;
	}
	
	public void setDisease(Disease disease)
	{
		this.disease = disease;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setFatigue(int fatigue)
	{
		this.fatigue = fatigue;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	
	public void setHunger(int hunger)
	{
		this.hunger = hunger;
	}
	
	/**
	 * Adds the specified amount to money
	 * @param money the amount to add
	 */
	public void addMoney(int money)
	{
		this.setMoney(this.money + money);
	}
	
	/**
	 * Subtracts the specified amount from money
	 * @param money the amount to subtract
	 */
	public void subMoney(int money)
	{
		this.setMoney(this.money - money);
	}
	
	private void setMoney(int money)
	{
		this.money = money;
	}
	
	/**
	 * A string summary of this object's attributes
	 */
	public String toString()
	{
		return this.name + "(" + this.type + "): Health " +  this.health + " Hunger " + this.hunger + 
				" Fatigue " + this.fatigue + " Status " + 
				(this.isSick() ? this.disease : "Healthy");
	}
}

