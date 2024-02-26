import java.util.Random;
import java.util.EmptyStackException;

/**
 * Write a description of class Game here.
 * Chris helped me with this assignment.
 *
 * @author Mathew
 * @version 10/06/2023
 */
public class Game
{
    //making the stacks
    StackInterface<Disk> stack1;
    StackInterface<Disk> stack2;
    StackInterface<Disk> stack3;
    
    //variables 
    private int player1Score;
    private int player2Score;
    private int currentRound;
    private int totalRounds;

   //@param turns - The total number of rounds in the game
   public Game(int turns)
   {
       totalRounds = turns;
       currentRound = 1;
       player1Score = 0;
       player2Score = 0;
       
       //declaring the implmentation of the stacks
       stack1 = new ArrayStack();
       stack2 = new LinkedStack();
       stack3 = new VectorStack();
   }
   
   public void playGame()
   {
       System.out.println("Lets play the game!");
       
       //reseting the scores
       player1Score = 0;
       player2Score = 0;
       currentRound = 1;
       
       //clearing the stacks to reset
       stack1.clear();
       stack2.clear();
       stack3.clear();
       
       for(int i = 1; i <= totalRounds; i++)
       {
           playRound();
           currentRound++;
       }
       
       checkScore();
       
       displayWinner();
       
   }
   
   public void playRound()
   {
      
       //Displaying the current round
       System.out.println("Round: " + currentRound);
           
       //Player 1 moves a disk to a stack
       playerMove(1);
           
           
       //Player 2 moves a disk to a stack
       playerMove(2);
           
           
       //pop a disk
       checkForPop();
           
           
       
       
       
       //Updating the score
       checkScore();
       
       
       System.out.println("End of round " + currentRound+ "\n");
       
       
   }
   //@param playerId - to see which player is making a move
   public void playerMove(int playerId)
   {
       //Create disk
       Disk disk = new Disk(playerId);
       
       
       //pick a random stack
       Random randomNumber = new Random();
       int stack = randomNumber.nextInt(3);
       
       //push to stack1
       if(stack ==0)
       {
           System.out.println("Player "+ playerId + " pushed a disk to  stack 1");
           
           //push the disk to stack1
           stack1.push(disk);
           
       }
       
       //push to stack2
       if(stack ==1)
       {
           System.out.println("Player "+ playerId + " pushed a disk to stack 2");
            
           //push the disk to stack2
           stack2.push(disk);
           
       }
       
       //push to stack3
       if(stack ==2)
       {
           
           System.out.println("Player "+ playerId + " pushed a disk to stack 3");
           
           //push the disk to stack3
           stack3.push(disk);
           
           
       }
   }
   //method to pop a disk
   //if its round 3 we pop a random disk from stack1 
   //if its round 5 we pop a random disk from stack2
   //if its round 8 we pop a random disk from stack3 
   //Made an exception if the stack is empty
   public void checkForPop()
   {
       //pop disk from stack1 every 3 rounds
       if (currentRound % 3 == 0)
       {
           //try to pop from stack1:
           try
           {
               stack1.pop();
               System.out.println("Popped disk from stack 1");
               
           }
           //gives an exception if the stack is empty
           catch(Exception error)
           {
               if(error instanceof EmptyStackException)
               {
                   System.out.println("Stack 1 is empty, nothing was popped");
               }
               
           }
           
       }
       
       //pop disk from stack2 every 5 rounds
       if (currentRound % 5 == 0)
       {
           try
           {
               stack2.pop();
               System.out.println("Popped disk from stack 2");
               
           }
           catch(Exception error)
           {
               //using EmptyStackException if the stack is empty
               if(error instanceof EmptyStackException)
               {
                   System.out.println("Stack 2 is empty, nothing was popped");
               }
               
           }
           
       }
       
       
       //pop disk from stack3 every 8 rounds
       
       if (currentRound % 8 == 0)
       {
           try
           {
               //pop a disk from stack3
               stack3.pop();
               System.out.println("Popped disk from stack 3");
               
           }
           //exception
           catch(Exception error)
           {
               if(error instanceof EmptyStackException)
               {
                   System.out.println("Stack 3 is empty, nothing was popped");
               }
               
           }
           
       }
   }
   
   public void checkScore()
   {
       //made an array with all values as false
       boolean stackState[] = {false, false, false};
       
      
       while(stackState[0] == false)
      {
          //check to see if stack1 is empty
          // 0 = stack1 
          if(stack1.isEmpty() == true)
          {
              stackState[0] =true;
              
          }
          else
          {
              stackState[0] =false;
              
              //pop a disk from stack1
              Disk playerDisk = stack1.pop();
              
              
              
              int playerDiskNum = playerDisk.getPlayerNumber();
              
              //if the disk num is = to 1
              if(playerDiskNum == 1)
              {
                  // updating player1 score
                  player1Score++;
              }
              if(playerDiskNum == 2)
              {
                  player2Score++;
                  
              }
              
          }
          
          //check to see if it is empty 
          // 1 = stack2 
          if(stack2.isEmpty() == true)
          {
              stackState[1] =true;
          }
          
          else
          {
            
              stackState[1] =false;
              //pop a disk from stack2  
              Disk playerDisk = stack2.pop();
              
              //getting the player number
              int playerDiskNum2 = playerDisk.getPlayerNumber();
              
              if(playerDiskNum2 == 1)
              {
                  //updating player1 score
                  player1Score++;
              }
              if(playerDiskNum2 == 2)
              {
                  //updating player2 score
                  player2Score++;
                  
              }
              
          }
          // 2 = stack3 
          if(stack3.isEmpty() == true)
          {
              stackState[2] =true;
              
          }
          else
          {
              stackState[2] =false;
              
              //pop a disk from stack3 a
              Disk playerDisk = stack3.pop();
              //storing player number into playerDiskNum3
              int playerDiskNum3 = playerDisk.getPlayerNumber();
              
              if(playerDiskNum3 == 1)
              {
                  //updating score for player1
                  player1Score++;
              }
              if(playerDiskNum3 == 2)
              {
                  //updating score for player1
                  player2Score++;
                  
              }
              
          }
          
      }
      
   }
   
   //Shows the winner 
   public void displayWinner()
   {
       System.out.println("\n \n" + "Score: ");
       System.out.println("Player 1 Score: " + player1Score);
       System.out.println("Player 1 Score: " + player2Score);
       
       //Displays who is the winner depending who has the higher score.
       if(player1Score > player2Score)
       {
           System.out.println("Player1 is the winner");
       }
       
       if(player1Score < player2Score)
       {
           System.out.println("Player2 is the winner");
       }
       
       if(player1Score == player2Score)
       {
           System.out.println("Player3 is the winner");
       }
       
          
   }
      
}
