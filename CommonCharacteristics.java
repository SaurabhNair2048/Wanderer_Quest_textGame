package gameCharacterCreation;

import java.util.Scanner;

public abstract class CommonCharacteristics {
	
	private String characterName;
	private String gender;
	/*private static final int baseHP = 1000;
	private static final int baseResistance = 20;
	private static final double baseEvasion = 0.10;
	private static final int baseDamage = 50;
	private static final int baseRange = 0;*/
	private static int uniqueID = 0;
	protected int level;
	protected int exp;
	protected int levelUpCoins;
	protected Location location;
	private String characterClass;
	
	
	
	private int HP;
	private int Resistance;
	private double Evasion;
	private int Damage;
	private int Range;
	private double speed;
	
	CommonCharacteristics(String name, String gender, String chClass)
	{
		this.characterName = name + uniqueID++;
		this.gender = gender;
		this.level = 0;
		this.location = new Location();
		this.characterClass = chClass;
	}
	
	//Methods that need to be implemented by each character based on race and class
	//abstract void battle(Monster m);
	
	//abstract void moveBy(int x, int y);
	
	abstract void specialAttack(String chClass, Monster m);
	
	//abstract void useLevelUpCoins();
	
	//getters for the base character combat abilities
	/*int getBaseHP()
	{
		return baseHP;
	}
	
	int getBaseResistance()
	{
		return baseResistance;
	}
	
	double getBaseEvasion()
	{
		return baseEvasion;
	}
	
	int getBaseDamage()
	{
		return baseDamage;
	}
	
	int getBaseRange()
	{
		return baseRange;
	}*/
	
	String getGender()
	{
		return this.gender;
	}
	
	String getCharacterClass()
	{
		return this.characterClass;
	}
	
	
	//Getter and Setter for level, speed and Locations
	int getLevel()
	{
		return this.level;
	}
	
	void setLevel()
	{
		this.level++;
	}
	
	Location getLocation()
	{
		return this.location;
	}
	
	void setLocation(int x, int y)
	{
		this.location.setX(x);
		this.location.setY(y);
	}
	
	public final int getHP() {
		return HP;
	}

	public final int getResistance() {
		return Resistance;
	}

	public final double getEvasion() {
		return Evasion;
	}

	public final int getDamage() {
		return Damage;
	}

	public final int getRange() {
		return Range;
	}

	public final double getSpeed() {
		return speed;
	}
	
	//Setters to set the characters characteristics
	
	void setInitHP(int baseHP, double m, double f)
	{
		int HP = 0;
		//Set HP based on gender
		if(this.gender.equalsIgnoreCase("male"))
		{
			HP = (int)(baseHP + (baseHP * m));
		}
		else
		{
			HP = (int)(baseHP + (baseHP * f));
		}
		//Modify HP based on character class
		if(this.characterClass.equalsIgnoreCase("warrior"))
		{
			this.HP = (int)(HP + (HP + 0.04));
		}
		else
		{
			this.HP = (int)(HP + (HP - 0.02));
		}
	}
	
	void setInitResistance(int baseResistance, double m, double f)
	{
		int res = 0;
		//Set res based on gender
		if(this.gender.equalsIgnoreCase("male"))
		{
			res = (int)(baseResistance + (baseResistance * m));
		}
		else
		{
			res = (int)(baseResistance + (baseResistance * f));
		}
		//Modify res based on character class
		if(this.characterClass.equalsIgnoreCase("warrior"))
		{
			this.Resistance = (int)(res + (res + 0.05));
		}
		else
		{
			this.Resistance = (int)(res + (res - 0.03));
		}
	}
	
	void setInitEvasion(double baseEvasion, double m, double f)
	{
		double evs = 0;
		//Set evs based on gender
		if(this.gender.equalsIgnoreCase("male"))
		{
			evs =  (int)(baseEvasion + (baseEvasion * m));
		}
		else
		{
			evs = (int)(baseEvasion + (baseEvasion * f));
		}
		//Modify res based on character class
		if(this.characterClass.equalsIgnoreCase("warrior"))
		{
			this.Evasion = (int)(evs + (evs + 0.01));
		}
		else
		{
			this.Evasion = (int)(evs + (evs - 0.01));
		}
	}
	
	void setInitDamage(int baseDamage, double m, double f)
	{
		int dmg = 0;
		//Set dmg based on gender
		if(this.gender.equalsIgnoreCase("male"))
		{
			dmg = (int)(baseDamage + (baseDamage * m));
		}
		else
		{
			dmg = (int)(baseDamage + (baseDamage * f));
		}
		//Modify dmg based on character class
		if(this.characterClass.equalsIgnoreCase("warrior"))
		{
			this.Damage = (int)(dmg + (dmg + 0.015));
		}
		else
		{
			this.Damage = (int)(dmg + (dmg - 0.005));
		}
	}
	
	void setInitRange(int baseRange, int warrior, int mage)
	{
		if(this.characterClass.equalsIgnoreCase("warrior"))
		{
			this.Range = (baseRange + warrior);
		}
		else
		{
			this.Range = (baseRange + mage);
		}
	}
	
	void setInitSpeed(int baseSpeed)
	{
		if(this.gender.equalsIgnoreCase("male"))
		{
			this.speed = baseSpeed + (baseSpeed * 0.01);
		}
		else
		{
			this.speed = baseSpeed - (baseSpeed * 0.005);
		}
	}
	
	
	
	
	//If a monster appears at your location and you accept the challenge the 
	//battle is called to see if you win or lose 
	void battle(Monster m)
	{
		int mHP = m.getMonsterHP();
		int mRes = m.getMonsterResistance();
		int mDmg = m.getMonsterDamage();
		int playerHP = this.HP;
		int count = 0;
		int toRange = 0;
		if(getCharacterClass().equalsIgnoreCase("mage"))
		{
			while(toRange < this.Range)
			{
				toRange++;
				if(count == 5)
				{
					count = 0;
					specialAttack("mage", m);
					mRes = m.getMonsterResistance();
					mDmg = m.getMonsterDamage();
				}
				else
				{
					System.out.println("Regular character attack!!");
					count++;
				}
				if((this.Damage - mRes) > 0)
				{
					m.setMonsterHP(mHP - (this.Damage - mRes));
					mHP = m.getMonsterHP();
				}
				if(mHP <= 0)
				{
					levelUpPlayer(m);
					return;
				}
			}
		}
		while(true)
		{
			if(count == 5)
			{
				count = 0;
				specialAttack(this.getCharacterClass(), m);
				mRes = m.getMonsterResistance();
				mDmg = m.getMonsterDamage();
			}
			else
			{
				System.out.println("Regular character attack!!");
				count++;
			}
			if((this.Damage - mRes) > 0)
			{
				m.setMonsterHP(mHP - (this.Damage - mRes));
				mHP = m.getMonsterHP();
			}
			if((Math.random() + this.Evasion) < 0.9)
			{
				System.out.println("Regular monster attack!!");
				if((mDmg - this.Resistance) > 0)
				{
					playerHP -= (mDmg - this.Resistance);
				}
			}
			if(mHP <= 0)
			{
				System.out.println("You defeated the Monster.. Congratulations!!!!");
				levelUpPlayer(m);
				return;
			}
			else if(playerHP <= 0)
			{
				System.out.println("The monster defeated you!! Level Up and try again later...");
				this.exp += 20;
				return;
			}
		}
	}
	//To move to certain location in the map.
	//The x and y are the displacement values by which the character is to be moved from current location
	void moveBy(int x, int y)
	{
		try {
			Thread.sleep((long)(Math.sqrt((x*x) + (y*y))/speed)*100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLocation(x, y);
		System.out.println("You have reached the destination..");
		Location loc = getLocation();
		double monsterProbability = Math.random()*(1 + (loc.getX() + loc.getY())/(2*100.0));
		if(monsterProbability > 0.5)
		{
			Monster m = new Monster(1 + ((loc.getX() + loc.getY())/(2*10)));
			if(m.isChallengeAccepted())
			{
				battle(m);
			}
			else
			{
				System.out.println("Challenge was not accepted...\nMonster thinks you are scared and leaves with a laugh :D");
			}
		}
		else
		{
			System.out.println("No monster here.. Try again at a different location :)");
		}
		
	}
	
	//On winning against a monster this levelUpPlayer is called to give the exp to the player
	//And also to calculate the levelUpCoins the user gets 
	private void levelUpPlayer(Monster m)
	{
		this.exp += m.getExpGiven();
		while(this.exp >= (this.level * 50))
		{
			this.exp -= (this.level * 50);
			this.level++;
			this.levelUpCoins++;
		}
		System.out.println("Would you like to use the LevelUp Coins??\nType \"Yes\" to use them or anything else to continue...");
		Scanner in = new Scanner(System.in);
		String resp = in.nextLine();
		if(resp.equalsIgnoreCase("yes"))
		{
			useLevelUpCoins();
		}
		else
		{
			System.out.println("You can use the level up coins later by calling the \"use coins\" command...");
		}
		System.out.println("Your current level is : " + this.level);
	}
	
	//The below method is used to consume the levelUpCoins to raise user stat
	void useLevelUpCoins()
	{
		Scanner in = null;
		int response = 0;
		System.out.println("You have " + this.levelUpCoins + " available to be used...");
		while(this.levelUpCoins > 0)
		{
			in = new Scanner(System.in);
			System.out.println("Enter a number based on following instructions:\n\t"
					+ "1 : For increasing HP\n\t"
					+ "2 : For increasing Resistance\n\t"
					+ "3 : For increasing Evasion\n\t"
					+ "4 : For increasing Damage");
			if(this.getCharacterClass().equalsIgnoreCase("mage"))
			{
				System.out.println("\t5 : For increasing Range");
			}
			System.out.println("\t0 : To quit level up menu");
			response = in.nextInt();
			if(response == 0)
			{
				break;
			}
			else
			{
				switch(response)
				{
				case 1:
					if(this.levelUpCoins >= 1)
					{
						this.HP += (int)(this.HP * 0.1);
						this.levelUpCoins--;
					}
					else
					{
						System.out.println("Invalid input!!");
					}
					break;
				
				case 2:
					if(this.levelUpCoins >= 1)
					{
						this.Resistance += (int)(this.Resistance * 0.1);
						this.levelUpCoins--;
					}
					else
					{
						System.out.println("Invalid input!!");
					}
					break;
					
				case 3:
					if(this.levelUpCoins >= 1)
					{
						this.Evasion += (this.Evasion * 0.1);
						this.levelUpCoins--;
					}
					else
					{
						System.out.println("Invalid input!!");
					}
					break;
					
				case 4:
					if(this.levelUpCoins >= 1)
					{
						this.Damage += (int)(this.Damage * 0.1);
						this.levelUpCoins--;
					}
					else
					{
						System.out.println("Invalid input!!");
					}
					break;
					
				case 5:
					if(this.getCharacterClass().equalsIgnoreCase("mage") && this.levelUpCoins >= 5)
					{
						this.Range += (this.Range + 1);
						this.levelUpCoins -= 5;
					}
					else
					{
						System.out.println("Invalid input!!");
					}
					break;
					
				default:
					System.out.println("Invalid input!!");
				}
			}
		}
	}

}
