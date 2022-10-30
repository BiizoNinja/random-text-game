import java.util.Scanner; 
class game 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        
        // Game Variables 
        String[] enemies = { "Skeleton", "Zombie", "Magician"}; 
        int enemyHP = 80; 
        int enemyDmg = 10; 
        
        // Player Variables 
        int playerHP = 100; 
        int attackDmg = 15; 
        
        // Sample Game 
        System.out.println("You are in a deep, dark, eerie cave... One wrong move and anything can go wrong...\nAnd WHAT IS THAT! you see two paths one in the right and one in the left.. What do you do?\nType 1 to go right or type 2 to go left"); 
        int ch = sc.nextInt(); 
        
        
        switch(ch)
        {
            case 1: 
                System.out.println(""); 
            break; 
            
            case 2: 
                System.out.println(""); 
            break; 
            
            default:
               System.out.println(""); 

        } 
    }
}