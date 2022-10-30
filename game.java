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
                System.out.println("\tYour health: "+playerHP); 
                System.out.println("\t"+enemy+"'s health: "+enemyHP+"\n");
                System.out.println("\tWhat would you like to do?"); 
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use Health Potion");
                System.out.println("\t3. Run\n");

                int ch = sc.nextInt();    

                if(ch == 1) {
                    int dmgDealt = rd.nextInt(attackDmg); 
                    int dmgRecieved = rd.nextInt(enemyDmg); 

                    enemyHP -= dmgDealt; 
                    playerHP -= dmgRecieved; 

                    System.out.println("\t> You strike the "+enemy+" for "+dmgDealt+" damage!");
                    System.out.println("\t> You took "+dmgRecieved+" damage!\n");

                    if(playerHP < 1) {
                        System.out.println("\t> You have taken too much damage. You are too weak to go on!");
                        break; 
                    }
                } 
                else if(ch == 2) {
                    if( healthPotions > 1) {
                        playerHP += healthPotionHealAmt; 
                        healthPotions--; 
                        System.out.println("\t> You drank a health potion! You now healed "+healthPotionHealAmt+" HP."); 
                        System.out.println("\t> Your health is now "+playerHP+" HP.");
                        System.out.println("\t> You now have "+healthPotions+" health potions left.\n");

                    } else {
                        System.out.println("\t> You do not have any health potions left! Please defeat an enemy for a chance to get one!");
                    }
                }
                else if(ch == 3) {
                    System.out.println("\t> You chose to run away from the "+enemy+"!");
                    continue GAME; 
                }
                else {
                    System.out.println("Invalid option!");
                }
            }

            if(playerHP < 1) {
                System.out.println("\t> You exited out of the cave because you are too weak to fight!");
                break; 
            }

            System.out.println("---------------------------------------------------");
            System.out.println("\t"+enemy+" was defeated!");
            System.out.println("\tYou have "+playerHP+" HP left!"); 
            if(rd.nextInt(100) < hpPotionsDropAmt) {
                healthPotions++;
                System.out.println("\tYou got lucky! The "+enemy+" dropped a health potion!\n\tYou now have "+healthPotions+" health potions left.");

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