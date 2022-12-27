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
        String[] ores = {"Diamond", "Ruby", "Gold", "Platinum", "Emerald"}; 
        int money = 0; 
        boolean game = true; 


       // Fight variables
        int fightMoneyEarned = rd.nextInt(50); 
        int maxEnemyHP = 100; 
        int enemyDmg = 20;  
        int enemyKilled = 0; 
        int playerHP = 100; 
        int attackDmg = 25; 

        // Health Potion Variables
        int healthPotions = 5; 
        int healthPotionHealAmt = 20; 
        int hpPotionsDropAmt = 50; 

        // Grenade Varables 
        int grenadeDmg  = 50; 
        int playerGrenadeDmg = 30; 
        int playerDmgChance = 35; 
        int grenadeDropChance = 40; 
        int grenades = 3; 

        // Sword Variables 
        int swordDmg = 100; 
        int swordFailChance = 70; 
        int swordUses = 2;
        int swordUseDropChance = 25; 

        // Mining Variables 
        double energy = 100.0;  
        int oresMined = 0; 
        int maxOreHP = 10; 

        // Energy Potion Variables
        int enrgPotions = 3; 
        int enrgPotionHealAmt = 10; 
        int enrgPotionsDropAmt = 50;  
        
        // Game 
        GAME:
        while(game) {
        // money += 500; 
        System.out.println("\t# Welcome to the cave! #\n"); 
        System.out.println("\t> What would you like to do?"); 
        System.out.println("\t1. Fight monsters\n\t2. Mining for ores\n\t3. Buy/Sell ttems from the shop\n\t4. Exit the game");
        int h = sc.nextInt(); 
        if(h == 1) {

            // If player chooses one it will open the fight menu and executes the fighting loop
            fighting:
            while(playerHP != 0 ) {
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
                                if(playerHP < 100) {
                                    playerHP += healthPotionHealAmt; 
                                    healthPotions--; 
                                    System.out.println("\t> You drank a health potion! You now healed "+healthPotionHealAmt+" HP."); 
                                    System.out.println("\t> Your health is now "+playerHP+" HP.");
                                    System.out.println("\t> You now have "+healthPotions+" health potions left.\n");
                                }
                                else {
                                 System.out.println("\t> You are healed up to the maximum amount. Go and fight monsters!");
                                }
        
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
                    else if(ch == 3) {
                        System.out.println("\t> You chose to run away from the "+enemy+"!\n\t> A new enemy now appears!");
                        continue fighting; 
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
                enemyKilled += 1; 
                System.out.println("\tYou have killed "+enemyKilled+" enemies!");
                int moneyEarned = fightMoneyEarned; 
                money += moneyEarned; 
                System.out.println("\tYou earned $"+moneyEarned+"! You now have $"+money); 
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
                System.out.println("1. Continue fighting\n2. Exit the game"); 
    
                int ch1 = sc.nextInt(); 
    
                while(ch1 != 1 && ch1 != 2) {
                    System.out.println("Invalid choice! Please input again."); 
                    ch1 = sc.nextInt();
                }
    
                if(ch1 == 1) {
                    System.out.println("> You continue your adventure"); 
                    continue fighting; 
                } 
                else if(ch1 == 2) {
                    System.out.println("> You exit the cave!\n"); 
                    }
                    break fighting;                            
                    }               
                }
        else if(h == 2) {
            // If player chooses one it will open the fight menu and executes the fighting loop
            mining: 
            while(energy != 0) {
                System.out.println("---------------------------------------------------"); 
                int oreHP = rd.nextInt(maxOreHP);
                String ore = ores[rd.nextInt(ores.length)];
                System.out.println("\t# You spot a "+ore+" ore! #\n");
                while (oreHP > 1) {
                    System.out.println("\t> "+ore+"'s durability: "+oreHP+"\n\t> Your energy "+energy+" energy points");
                    System.out.println("\tWhat would you like to do?"); 
                    System.out.println("\t1. Mine");
                    System.out.println("\t2. Use energy potion");
                    System.out.println("\t3. Leave\n");
                    // Variable for choice
                    int mch = sc.nextInt(); 
    
                        if(mch == 1) {
                            int nrgLost = 2; 
        
                            energy -= 2; 
                            oreHP -= 1;
                            
                            if(nrgLost >= 1) {
                                System.out.println("\t> You lost "+nrgLost+" energy!\n\t> You now have "+energy+" energy points energy left");
                            }
                                System.out.println("\t> You strike the "+ore+" for 1 durability!\n");   
                            if(energy < 1) {
                                System.out.println("\t> You dont have enough energy to continue mining!\n");
                                break mining; 
                            }
                    }
                    else if(mch == 2) {
                        if(enrgPotions >= 1 ) {
                             if(energy < 100.0) {
                            
                                enrgPotions -= 1; 
                                energy += enrgPotionHealAmt; 
                                System.out.println("\t> You used a energy potion and gained 10 energy points\n\t> You now have "+energy+" energy points left and have "+enrgPotions+" potions left!");
                            } else {
                                System.out.println("\t> You have the maximum amount of enery points. Go mine for ores!"); 
                            }
                        } else {
                        System.out.println("\t>You don't have any energy potions left!");
                    }
                } else if(mch == 3) {
                    System.out.println("\t> You chose to leave the "+ore+" ore unmined!");
                } else {
                    System.out.println("INVALID OPTION!");
                }                   
            }
            if(energy < 1) {
                System.out.println("\t> You stopped mining because you ran out of energy.");
                break; 
            }
            System.out.println("---------------------------------------------------");
            System.out.println("\n\t"+ore+" was mined!");
            System.out.println("\tYou have "+energy+" energy points left!"); 
            oresMined += 1; 
            System.out.println("\tYou have mined "+oresMined+" ores!\n"); 
            if(rd.nextInt(100) < enrgPotionsDropAmt) {
                enrgPotions++;
                System.out.println("\t> You got lucky! The "+ore+" dropped an energy potion!\n\t- You now have "+enrgPotions+" energy potions left.\n");
    
            }
            System.out.println("What would you like to do now?"); 
            System.out.println("1. Continue mining\n2. Exit the game"); 
    
            int ch2 = sc.nextInt(); 
    
                while(ch2 != 1 && ch2 != 2) {
                    System.out.println("Invalid choice! Please input again."); 
                    ch2 = sc.nextInt();
                }
                if(ch2 == 1) {
                    System.out.println("> You continue your adventure");
                    continue mining;  
                } 
                else if(ch2 == 2) {
                    System.out.println("> You exit the game!\n"); 
                    }
                    break mining;                            
                    } 
            }  
        else if(h == 3) {
            shop: 
            while(true) {
                System.out.println("---------------------------------------------------");
                System.out.println("\t> Welcome to the shop!\n");
                System.out.println("\t> You currently have:\n\t> "+oresMined+" ores mined\n\t> $"+money);
                System.out.println("\t What would you like to do?"); 
                System.out.println("\t 1. Buy items\n\t 2. Sell ores\n\t 3. Exit shop");
                int sch = sc.nextInt(); 

                if(sch == 1) {
                    x: 
                    while(true) {
                        System.out.println("---------------------------------------------------");
                        System.out.println("\t# Buy items menu! #");
                        System.out.println("\t> 1. Energy potions - $40\n\t> 2. Health Potions - $40\n\t> 3. Grenades - $35\n\t> 4. Sword Charges - $30\n\t> 5. EXIT");
                        int t = sc.nextInt(); 

                        switch(t) {
                            case 1: 
                              System.out.println("\t> How many Energy Potions would you like?"); 
                              int n1 = sc.nextInt(); 
                              if(money < n1*40) {
                                System.out.println("\t> You don't have enough money to buy that many!");
                                break; 
                              } else {
                                int moneyToPay = n1*40; 
                                money -= moneyToPay; 
                                enrgPotions += n1; 

                                System.out.println("\t> You bought "+n1+" energy potions and paid $"+moneyToPay+"!\n\t> You now have $"+money+" left");
                                continue x; 
                              }
                              case 2: 
                              System.out.println("\t> How many Health Potions would you like?"); 
                              int n2 = sc.nextInt(); 
                              if(money < n2*40) {
                                System.out.println("\t> You don't have enough money to buy that many!");
                                break; 
                              } else {
                                int moneyToPay = n2*40; 
                                money -= moneyToPay; 
                                healthPotions += n2; 

                                System.out.println("\t> You bought "+n2+" health potions and paid $"+moneyToPay+"!\n\t> You now have $"+money+" left");
                                continue x; 
                              }
                              case 3: 
                              System.out.println("\t> How many Grenades would you like?"); 
                              int n3 = sc.nextInt(); 
                              if(money < n3*35) {
                                System.out.println("\t> You don't have enough money to buy that many!");
                                break; 
                              } else {
                                int moneyToPay = n3*35; 
                                money -= moneyToPay; 
                                grenades += n3; 

                                System.out.println("\t> You bought "+n3+" health potions and paid $"+moneyToPay+"!\n\t> You now have $"+money+" left");
                                continue x; 
                              }
                              case 4: 
                              System.out.println("\t> How many Sword Charges would you like?"); 
                              int n4 = sc.nextInt(); 
                              if(money < n4*30) {
                                System.out.println("\t> You don't have enough money to buy that many!");
                                break; 
                              } else {
                                int moneyToPay = n4*30; 
                                money -= moneyToPay; 
                                swordUses += n4; 

                                System.out.println("\t> You bought "+n4+" health potions and paid $"+moneyToPay+"!\n\t> You now have $"+money+" left");
                                continue x; 
                              }
                              case 5:
                              System.out.println("\t> You exit the buy menu!");
                              break x;                  
                              
                              default: 
                              System.out.println("INVALID OPTION");
                              continue x; 
                        }
                    } 
                }
                else if(sch == 2) {
                    y: 
                    while(true) {
                        System.out.println("---------------------------------------------------");
                        System.out.println("\t# Sell ores menu! #");
                        System.out.println("\t> Ores mined :"+oresMined+" - $25 Each\n\n\t> How many ores would you like to sell?");
                        int n = sc.nextInt(); 
                        
                        if(oresMined < n ) {
                            System.out.println("\t> You don't have that many ores to sell!");
                            continue y; 
                        }   else {
                            oresMined -= n; 
                            money += n*25; 

                            System.out.println("\t> You successfully sold "+n+" ores and earned $"+n*25+"!");
                            break; 
                        }
                    }
                }

                else if(sch == 3 ){
                    System.out.println("\t> You exit the shop!");
                    break shop; 
                }           
            }
        }
        else if(h == 4) {
                System.out.println("> You exit the game! Thanks for playing");
                System.out.println("> You made a total of $"+money+", mined "+oresMined+" ores and killed "+enemyKilled+" enemies!");
                System.out.println("> You had a total of "+enrgPotions+" energy potions, a total of "+healthPotions+" health potions, a total of "+grenades+" grenades and a total of "+swordUses+" sword uses left!");
                break GAME;     
            }           
        }       
    }
}