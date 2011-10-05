package org.jamieandtheboys.persons;

import org.jamieandboys.diseases.*;

public abstract class Person
{
	private String name, type;
	private int health, hunger, money, fatigue;
	private Disease disease;
	
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
	
	public void doDisease()
	{
		this.disease.doEffect(this);
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

	public int getMoney()
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

	public void setFatigue(int fatigue)
	{
		this.fatigue = fatigue;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public void setHunger(int hunger)
	{
		this.hunger = hunger;
	}
	
	public void addMoney(int money)
	{
		this.setMoney(this.money + money);
	}
	
	public void subMoney(int money)
	{
		this.setMoney(this.money - money);
	}
	
	private void setMoney(int money)
	{
		this.money = money;
	}
	
	public String toString()
	{
		return this.name + "(" + this.type + "): Health " +  this.health + " Hunger " + this.hunger + 
				" Fatigue " + this.fatigue + " Status " + 
				(this.isSick() ? this.disease : "Healthy");
	}
}

