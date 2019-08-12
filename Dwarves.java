package gameCharacterCreation;

import java.util.Scanner;

public class Dwarves extends CommonCharacteristics {
	
	/*private int HP;
	private int Resistance;
	private double Evasion;
	private int Damage;
	private int Range;
	private double speed;*/
	private static final int baseHP = 1000;
	private static final int baseResistance = 25;
	private static final double baseEvasion = 0.10;
	private static final int baseDamage = 50;
	private static final int baseRange = 0;
	private static final int baseSpeed = 4;
	
	Dwarves(String name, String gender, String chClass)
	{
		super(name, gender, chClass);
		setInitHP(baseHP, 0.3, 0.25);
		setInitResistance(baseResistance, 0.35, 0.32);
		setInitEvasion(baseEvasion, 0.15, 0.22);
		setInitDamage(baseDamage, 0.1, 0.09);
		setInitRange(baseRange, 0, 2);
		setInitSpeed(baseSpeed);
	}
	
	void specialAttack(String chClass, Monster m)
	{
		if(chClass.equalsIgnoreCase("warrior"))
		{
			System.out.println("Drill Attack!!!!");
			m.setMonsterResistance((int)(m.getMonsterResistance() * 0.7));
		}
		else
		{
			System.out.println("Molten Rock Attack!!!!");
			m.setMonsterDamage((int)(m.getMonsterDamage() * 0.85));
		}
	}

}
