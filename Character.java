package gameCharacterCreation;

import java.util.Scanner;

public class Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "";
		String gender = "";
		String characterClass = "";
		
		String race = "";
		
		Dwarves dwarf = null;
		Humans human = null;
		Elves elf = null;
		Orcs orc = null;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to Wanderer Quest!!\nPlease follow the instruction below to play the game..."
				+ "\nHope you enjoy the game!!");
		
		System.out.print("Enter your character name : ");
		name = in.nextLine();
		
		System.out.print("Two genders are available :\n\t1 : Male\n\t2 : Female\nEnter your character gender as \"Male\" or \"Female\" : ");
		gender = in.nextLine();
		
		System.out.print("Two character classes are available :\n\t"
				+ "1 : Warrior\n\t2 : Mage\n\t"
				+ "Enter your character class as \"Warrior\" or \"Mage\" : ");
		characterClass = in.nextLine();
		
		System.out.print("Four character races are available :\n\t"
				+ "1: Dwarves\n\t2: Humans\n\t3: Elves\n\t4: Orcs\n\t"
				+ "Enter your character race as \"Dwarves\" or \"Humans\" or \"Elves\" or \"Orcs\" : ");
		race = in.nextLine();
		
		switch(race)//To create the character based on the race selected
		{
		case "Dwarves":
		case "dwarves":
			dwarf = new Dwarves(name, gender, characterClass);
			System.out.println("Character of race " + race + " has been created");
			break;
			
		case "Humans":
		case "humans":
			human = new Humans(name, gender, characterClass);
			System.out.println("Character of race " + race + " has been created");
			break;
			
		case "Elves":
		case "elves":
			elf = new Elves(name, gender, characterClass);
			System.out.println("Character of race " + race + " has been created");
			break;
			
		case "Orcs":
		case "orcs":
			orc = new Orcs(name, gender, characterClass);
			System.out.println("Character of race " + race + " has been created");
			break;
			
		default:
			System.out.println("Incorrect race entered... THE END");
		}
		
		System.out.println("Use the command \"Move To\" to move around and find the monsters.. "
				+ "\nOR enter \"use coins\" to use levelUp coins..\nOR enter \"Quit\" to quit the game...");
		while(true)
		{
			System.out.print("Enter command : ");
			String response = in.nextLine();
			if(response.equalsIgnoreCase("move to"))//to move to a location in map to find a monster
			{
				System.out.print("Enter distance in x direction : ");
				int x = in.nextInt();
				System.out.print("Enter distance in y direction : ");
				int y = in.nextInt();
				
				switch(race)
				{
				case "Dwarves":
				case "dwarves":
					dwarf.moveBy(x, y);
					break;
					
				case "Humans":
				case "humans":
					human.moveBy(x, y);
					break;
					
				case "Elves":
				case "elves":
					elf.moveBy(x, y);
					break;
					
				case "Orcs":
				case "orcs":
					orc.moveBy(x, y);
					break;
					
				default:
					System.out.println("Incorrect location entered... THE END");
				}
				in.nextLine(); // to clear the buffer of stray data elements
			}
			else if(response.equalsIgnoreCase("use coins"))//To use the level up coins to improve stats
			{
				
				switch(race)
				{
				case "Dwarves":
				case "dwarves":
					dwarf.useLevelUpCoins();
					break;
					
				case "Humans":
				case "humans":
					human.useLevelUpCoins();
					break;
					
				case "Elves":
				case "elves":
					elf.useLevelUpCoins();
					break;
					
				case "Orcs":
				case "orcs":
					orc.useLevelUpCoins();
					break;
				}
			}
			else if(response.equalsIgnoreCase("quit"))
			{
				System.out.println("Thank you for playing Wanderer Quest!! Hope you enjoyed it..");
				break;
			}
			else
			{
				System.out.println("Incorrect input! Please enter the command again..");
			}
		}

	}

}
