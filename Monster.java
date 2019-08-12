package gameCharacterCreation;

import java.util.Scanner;

public class Monster {
	
	private int level;
	private String name;
	private int monsterHP;
	private int monsterResistance;
	private int monsterDamage;
	private int monsterRange;
	private int monsterSpeed;
	private boolean challengeAccepted;
	private int expGiven;
	
	Monster(int level)
	{
		this.level = level;
		this.name = "Monster"+this.level;
		this.monsterHP = (int)(200000*this.level*0.7);
		this.monsterResistance = (int)(10*this.level*0.2);
		this.monsterDamage = (int)(this.level*100*0.5);
		this.monsterRange = 0;
		this.monsterSpeed = 1;
		this.expGiven = 50*this.level;
		
		System.out.println("Monster of level " + this.level + " has appeared and challenges you to a battle!!\nDo you want to battle?");
		System.out.println("mHP " + this.monsterHP + "mRes " + this.monsterResistance
				+ "mDam " + this.monsterDamage);
		this.challengeAccepted = getChallengeResponse();
	}

	private boolean getChallengeResponse()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Type \"Yes\" to accept the challenge or type \"No\" to decline : ");
		while(true)
		{
			String response = in.nextLine();
			if(response.equalsIgnoreCase("YES") || response.equalsIgnoreCase("Y"))
			{
				return true;
			}
			else if(response.equalsIgnoreCase("NO") || response.equalsIgnoreCase("N"))
			{
				return false;
			}
			else
			{
				System.out.println("Invalid input!! Please enter a valid response...");
			}
		}
		
	}
	
	public final int getMonsterHP() {
		return monsterHP;
	}

	public final void setMonsterHP(int monsterHP) {
		this.monsterHP = monsterHP;
	}

	public final int getMonsterResistance() {
		return monsterResistance;
	}

	public final void setMonsterResistance(int monsterResistance) {
		this.monsterResistance = monsterResistance;
	}

	public final int getMonsterDamage() {
		return monsterDamage;
	}

	public final void setMonsterDamage(int monsterDamage) {
		this.monsterDamage = monsterDamage;
	}

	public boolean isChallengeAccepted()
	{
		return challengeAccepted;
	}
	
	public final int getExpGiven() {
		return expGiven;
	}

}
