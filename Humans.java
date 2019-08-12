package gameCharacterCreation;

public class Humans extends CommonCharacteristics{
	
	private static final int baseHP = 1500;
	private static final int baseResistance = 30;
	private static final double baseEvasion = 0.06;
	private static final int baseDamage = 40;
	private static final int baseRange = 0;
	private static final int baseSpeed = 6;
	
	
	Humans(String name, String gender, String chClass)
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
			System.out.println("Giant Slash Attack!!!!");
			m.setMonsterResistance((int)(m.getMonsterResistance() * 0.9));
		}
		else
		{
			System.out.println("Lightning Attack!!!!");
			m.setMonsterDamage((int)(m.getMonsterDamage() * 0.9));
		}
	}

}
