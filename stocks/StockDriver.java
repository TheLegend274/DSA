import java.util.Scanner;
/**
 * Write a description of class driver here.
 *
 * @Mathew Sabu
 * @version (a version number or a date)
 */
public class StockDriver
{
    //made a leger
    static Broker leger = new Broker();
    public static void main(String[]args)
    {

        userInput();

    }

    //user input
    //returns the users input
    public static int userInput()
    {
        //declaring variables for user input 
        int user;
        int user1;
        double user2;
        int user3;
        double user4;
        //used a do - while loop so we can keep on asking the question until the user types 4
        do
        {
            //asking user to input one of the choices 
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select an option number(1,2,3,4)");
            System.out.println("1. Buy share of stock");
            System.out.println("2. Sell share of stock");
            System.out.println("3. Calculate total captial gain/loss. ");
            System.out.println("4. Quit");
            user = scan.nextInt();
            if (user == 1)
            {
                // ask the user the amount of shares and money
                System.out.println("Enter the amount of shares: ");
                user1 = scan.nextInt();
                System.out.println("Enter the amount of money: ");
                user2 = scan.nextDouble();
                leger.buy(user1,user2);

            }
            else if (user == 2)
            {
                System.out.println("Enter the amount of shares you want to sell: ");
                user3 = scan.nextInt();
                System.out.println("Enter the sell price: ");

                user4 = scan.nextDouble();
                //checking if user input is valid 
                if(user3 < 0 ){
                    System.out.println("Please enter number above 0");
                }
                leger.sell(user3,user4);

            }
            //get the total 
            else if (user == 3)
            {
                //call getTotalCapitalGain()
                leger.getTotalCapitalGain();

            }
            //breaks if the user inputs 4
            else if (user == 4)
            {
                System.out.println("Bye have a nice day!");
                break;

            }
        }while (user != 4);
        return user;

        
    }

}
