//Text Based Game
import java.util.Random;
import java.util.Scanner;


public class DarkDungeon {


	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		//Game Variables
		String[] enemies = {"Skeleton","Zombie","Frankenstein","Dracula"};
		int maxEnemyHealth = 85;
		int enemyAttackDamage = 30;
		int count = 0 ;

		//Player Variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3 ;  
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50 ; //50% chance to drop a health potion on killing an enemy
		int knifeChance = 60 ; 
		int knife = 0;
		int knifeDamage = 65 ; 

		boolean running = true;

		System.out.println("Welcome to the Dungeon!");

		GAME:
			while(running){
				System.out.println("-------------------------------------------");

				int enemyHealth = rand.nextInt(maxEnemyHealth);//This will randomly pick a value for health of an enemy btw 0 and 75. 

				String enemy = enemies[rand.nextInt(enemies.length)];//What?..This will randomly pick one of the enemies.

				System.out.println("\t# " + enemy + " has appeared! #\n") ;
				// # Skeleton has appeared! #


				while(enemyHealth>0){ //The Combat loop.

					System.out.println("\tYour HP:" + health);
					System.out.println("\t"+enemy+"'s HP:"+ enemyHealth);
					System.out.println("\n\tWhat would you like to do?");
					System.out.println("\t1.Attack ");
					System.out.println("\t2.Throw knife");
					System.out.println("\t3.Drink Health Potion");
					System.out.println("\t4.Run!");


					String input = in.nextLine();

					if(input.equals("1")){ //Attack

						int damageDealt = rand.nextInt(attackDamage);
						int damageTaken = rand.nextInt(enemyAttackDamage);

						enemyHealth = enemyHealth - damageDealt;
						health = health - damageTaken;

						System.out.println("\t> You strike the "+enemy+" for "+damageDealt+" damage");
						System.out.println("\t> You recieved "+damageTaken+" in retaliation\n");
						
						if(health<1){
							System.out.println("\t You were defeated by the "+ enemy +"\n");
							break;
						}
					}
					else if(input.equals("2")){//KNIFE
					
						if(knife==0){
							System.out.println(" You have no knife(ves) yet!  Defeat enemies for a chance to get one! \n");
							continue GAME;
						}
						
					int damageDealt = knifeDamage;
					
					enemyHealth = enemyHealth - damageDealt;
					System.out.println(" You strike the " + enemy + " with a knife for " + damageDealt + " damage ");
					
					knife--;
					
						
					}
						else if(input.equals("3")) //Drink Potion
						{
							if(health==100){
								System.out.println("Your HP is already full ! ");
								continue GAME;
							}
							else if(numHealthPotions>0){
								
								health = health + healthPotionHealAmount;
								if(health>100){
									health=100;
								}
								numHealthPotions--;
								System.out.println("\t>You drink health potion,healing yourself for "+healthPotionHealAmount+"."
										+"\n\t>You now have "+health+" HP." 
										+"\n\t>You have "+ numHealthPotions +" left.\n");
							}
							else{
								System.out.println("\t>You have no health potions left! Defeat enemies for a chance to get one!\n");
							}
						}
					
					else if(input.equals("4")) { //Run
						System.out.println("\t You ran away from the " + enemy + "!");
						continue GAME ; 
					}
					else{
						System.out.println("\tInvalid Input!\n");//We head straight to the GAME loop.
					}
				}

				if(health<1){ //still inside the game loop
					System.out.println("You limp out of the dungeon,weak from battle.\n");
					break;
				}
				System.out.println("--------------------------------------------------");
				System.out.println(" # " + enemy + " was defeated! #"  );
				count++;
				System.out.println(" # You have " + health + " HP left. #");

				if(rand.nextInt(100)<healthPotionDropChance){ //rand.nextInt will generate a rand no. btw 0 and 100.

					numHealthPotions++;
					System.out.println("# The "+ enemy+" dropped a health potion! # ");
					System.out.println(" # You now have "+ numHealthPotions + " health potion(s). # ");
				}
				if(rand.nextInt(100)<knifeChance){
					
					System.out.println("You found a knife!!");
					knife++ ;
					
				}

				System.out.println("--------------------------------------------------");
				System.out.println("\t What would you like to do now ? \n");
				System.out.println("1. Continue fighting ");
				System.out.println("2. Exit dungeon");

				String input = in.nextLine();


				while(!input.equals("1") && !input.equals("2")){

					System.out.println("Invalid command");
					input = in.nextLine();
				}

				if(input.equals("1")){
					System.out.println("You continue on your adventure!");
				}
				else if(input.equals("2")){
					System.out.println("You exit the dungeon, successful from your battle :-)");
					break;
				}



			}
		System.out.println("$$ Congratulations you defeated "+ count + " enemies $$");
		System.out.println("---------------------");
		System.out.println("# THANKS FOR PLAYING ! #");
		System.out.println("---------------------");



	}
}
