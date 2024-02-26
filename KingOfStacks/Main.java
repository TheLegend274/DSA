import java.util.Scanner;
public class Main
{
    public static void main()
    {
        Scanner scan = new Scanner(System.in);
        boolean accepted = false;
        int toatalTurns = 0;
        
        while(!accepted)
        {
            
            System.out.println("Please enter the amount of rounds you want (Enter above 30)");
            String user = scan.nextLine();
            //converting user String input to a int and storing it into totalTurns
            toatalTurns = Integer.valueOf(user);
            
            //to check to see if the user input is valid(over 30)
            if(toatalTurns >= 30)
            {
                accepted = true;
            }
            else
            {
                accepted = false;
            }
            
        }
        Game game = new Game(toatalTurns);
        
        //Playing the game
        game.playGame();
    }
}