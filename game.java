import java.util.Scanner; 
import java.util.Random;  

class game 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        Random rd = new Random(); 
        
        // Game Variables 
        String[] enemies = { "Skeleton", "Zombie", "Magician", "Titan", "Ghost"}; 
        int maxEnemyHP = 80; 
        int enemyDmg = 10; 
        
        // Player Variables 
        int playerHP = 100; 
        int attackDmg = 15; 
        int healthPotions = 5; 
        int healthPotionHealAmt = 20; 
        int hpPotionsDropAmt = 50; 

        // Grenade Varables 
        int grenadeDmg  = 50; 
        int playerGrenadeDmg = 30; 
        int playerDmgChance = 25; 
        int grenadeDropChance = 40; 
        int grenades = 2; 

        
        boolean running = true; 
        
        // Game
        System.out.println("Welcome to the cave!"); 
        
        GAME:
        while(running) {
            System.out.println("---------------------------------------------------"); 
            
            int enemyHP = rd.nextInt(maxEnemyHP); 
            String enemy = enemies[rd.nextInt(enemies.length)];
            System.out.println("\t# A "+enemy+" has appeared! #\n"); 
            
            while(enemyHP > 0) {
                System.out.println("\t> Your health: "+playerHP); 
                System.out.println("\t> "+enemy+"'s health: "+enemyHP+"\n");
                System.out.println("\t# INVENTORY #");
                System.out.println("\tHealth potions: "+healthPotions+"\tGrenades: "+grenades+"\n");
                System.out.println("\tWhat would you like to do?"); 
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use Health Potion");
                System.out.println("\t3. Use Grenade");
                System.out.println("\t4. Run\n");

                int ch = sc.nextInt();    

                if(ch == 1) {
                    int dmgDealt = rd.nextInt(attackDmg); 
                    int dmgRecieved = rd.nextInt(enemyDmg); 

                    enemyHP -= dmgDealt; 
                    playerHP -= dmgRecieved; 

                    if(dmgRecieved > 1) {
                        System.out.println("\t> You took "+dmgRecieved+" damage!");

                    } else if(dmgRecieved < 1) {
                        System.out.println("\t> Fortunately the "+enemy+" didn't do any damage do you!");
                    }
                    if(dmgDealt > 1) {
                        System.out.println("\t> You strike the "+enemy+" for "+dmgDealt+" damage!");   
                    } else if (dmgDealt < 1) {
                        System.out.println("\t> You strike but your attack fails to do any damage!");
                    }
                    if(playerHP < 1) {
                        System.out.println("\t> You lost all your health!\n\t> You lost to "+enemy+"!\n");
                        break; 
                    }
                } 
                else if(ch == 2) {
                    if( healthPotions >= 1) {
                        playerHP += healthPotionHealAmt; 
                        healthPotions--; 
                        System.out.println("\t> You drank a health potion! You now healed "+healthPotionHealAmt+" HP."); 
                        System.out.println("\t> Your health is now "+playerHP+" HP.");
                        System.out.println("\t> You now have "+healthPotions+" health potions left.\n");

                    } else {
                        System.out.println("\t> You do not have any health potions left!\n\t> When you kill an enemy you have a 50% chance to get one!");
                    }
                }
                else if(ch == 3) {
                        if(grenades >= 1) {
                            if(rd.nextInt(100) < playerDmgChance) {
                                playerHP -= playerGrenadeDmg; 
                                grenades--; 
                                System.out.println("\t> You used a grenade but it fell to close to you!\n\t> You lost "+playerGrenadeDmg+" HP.");
                            } else {
                                enemyHP -= grenadeDmg; 
                                grenades--;
                                System.out.println("\t> You used a grenade and it was effective!\n\t> You dealt "+grenadeDmg+" HP.");                               
                            }                         
                        } else {
                            System.out.println("\t> You do not have any grenades left!\n\t> When you kill an enemy you have a 40% chance to get one!");
                        }
                }
                else if(ch == 4) {
                    System.out.println("\t> You chose to run away from the "+enemy+"!\n\t> A new enemy now appears!");
                    continue GAME; 
                } else {
                    System.out.println("Invalid option");
                }
            }

            if(playerHP < 1) {
                System.out.println("\t> You exited out of the cave because you are too weak to fight!");
                break; 
            }

            System.out.println("---------------------------------------------------");
            System.out.println("\n\t"+enemy+" was defeated!");
            System.out.println("\tYou have "+playerHP+" HP left!\n"); 
            if(rd.nextInt(100) < hpPotionsDropAmt) {
                healthPotions++;
                System.out.println("\t> You got lucky! The "+enemy+" dropped a health potion!\n\t- You now have "+healthPotions+" health potions left.\n");

            }
            if(rd.nextInt(100) < grenadeDropChance) {
                grenades++;
                System.out.println("\t> You got lucky! The "+enemy+" dropped a grenade!\n\t- You now have "+grenades+" grenades left.");

            }
            System.out.println("---------------------------------------------------");
            System.out.println("What would you like to do now?"); 
            System.out.println("1. Continue fighting\n2. Exit the cave"); 

            int ch1 = sc.nextInt(); 

            while(ch1 != 1 && ch1 != 2) {
                System.out.println("Invalid choice! Please input again."); 
                ch1 = sc.nextInt();
            }

            if(ch1 == 1) {
                System.out.println("You continue your adventure"); 
            } 
            else if(ch1 == 2) {
                System.out.println("You exit the cave!");
                break;  
            }

            System.out.println("Thanks for playing!");          
           
        }               
    }
}