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
        int maxEnemyHP = 100; 
        int enemyDmg = 20;  
        int playerHP = 100; 
        int attackDmg = 25; 

        // Health Potion Variables
        int healthPotions = 5; 
        int healthPotionHealAmt = 20; 
        int hpPotionsDropAmt = 50; 

        // Grenade Varables 
        int grenadeDmg  = 50; 
        int playerGrenadeDmg = 30; 
        int playerDmgChance = 25; 
        int grenadeDropChance = 40; 
        int grenades = 3; 

        // Sword Variables 
        int swordDmg = 100; 
        int swordFailChance = 70; 
        int swordUses = 2;
        int swordUseDropChance = 25; 

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
                System.out.println("\tWhat would you like to do?"); 
                System.out.println("\t1. Attack");
                System.out.println("\t2. Inventory");
                System.out.println("\t3. Run\n");

                int ch = sc.nextInt();    

                if(ch == 1) {
                    int dmgDealt = rd.nextInt(attackDmg); 
                    int dmgRecieved = rd.nextInt(enemyDmg); 

                    enemyHP -= dmgDealt; 
                    playerHP -= dmgRecieved; 

                    if(dmgRecieved >= 1) {
                        System.out.println("\t> You took "+dmgRecieved+" damage!");

                    } else if(dmgRecieved < 1) {
                        System.out.println("\t> Fortunately the "+enemy+" didn't do any damage do you!");
                    }
                    if(dmgDealt >= 1) {
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
                    System.out.println("\t# INVENTORY #");
                    System.out.println("\t* Health potions: "+healthPotions+"\n\t* Grenades: "+grenades+"\n\t* Sword Uses: "+swordUses+"\n");
                    System.out.println("\tWhat would you like to use?"); 
                    System.out.println("\t1. Health Potion\n\t2. Grenade\n\t3. Sword");
                    int ch_ = sc.nextInt(); 

                    switch(ch_)
                    {
                        case 1: 
                        if(healthPotions >= 1) {
                            playerHP += healthPotionHealAmt; 
                            healthPotions--; 
                            System.out.println("\t> You drank a health potion! You now healed "+healthPotionHealAmt+" HP."); 
                            System.out.println("\t> Your health is now "+playerHP+" HP.");
                            System.out.println("\t> You now have "+healthPotions+" health potions left.\n");
    
                        } else {
                            System.out.println("\t> You do not have any health potions left!\n\t> When you kill an enemy you have a 50% chance to get one!");
                        }
                        break; 

                        case 2:
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
                        break; 

                        case 3: 
                        if(swordUses >= 1) {
                            if(rd.nextInt(100) < swordFailChance) {
                                swordUses--; 
                                System.out.println("\t> You used the sword but your attack fails to do any damage!");
                            } else {
                                enemyHP -= swordDmg; 
                                swordUses--; 
                                System.out.println("\t> You used the sword and it instantly eliminated the "+enemy+"!");
                            }
                        } else {
                            System.out.println("\t> Your sword doesn't have any uses left! When you kill an enemy there is a 25% chance your sword gets fired up to one use!");
                        }
                        break; 

                        default:
                        System.out.println("Invalid option!");
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
                System.out.println("\t> You got lucky! The "+enemy+" dropped a grenade!\n\t- You now have "+grenades+" grenades left.\n");

            }
            if(rd.nextInt(100) < swordUseDropChance) {
                swordUses++;
                System.out.println("\t> You got lucky! Because you killed the "+enemy+" your sword was fired up to 1 use!\n\t- You now have "+swordUses+" Sword uses left.\n");

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
                System.out.println("> You continue your adventure"); 
            } 
            else if(ch1 == 2) {
                System.out.println("> You exit the cave!");
                System.out.println("Thanks for playing!"); 
                break;  
            }                           
        }               
    }
}