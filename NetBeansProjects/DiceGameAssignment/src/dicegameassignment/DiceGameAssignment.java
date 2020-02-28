package dicegameassignment;
import java.util.Scanner; //Scanner class is used to allow the users to enter the input
import java.util.Random; //Random class is used to generate random numbers 

 // @author baileyluu

public class DiceGameAssignment {
    
     // @param args the command line arguments
     
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random randomNumber = new Random(); 
            int points;//initialize points as an integer
            System.out.print("You have 500 points.\nEnter points to wager (-1 to QUIT):\t\t");
            points = input.nextInt();  //user enter points to wager
            int num1; // initialize num1 to num4 as integer numbers
            int num2;
            int num3;
            int num4;
            int playerPoints = 500;//player has 500 points at the beginning
            char roll; //initialize roll as a char to allow user to enter a letter
            int cycle = 0; //initialize cycle as an integer and equal to 0
            while(cycle >= 0){
                
                if(points > playerPoints){
                    if(cycle == 0){ //if cycle is equal to 0
                        System.out.println("\nPlease enter a wager less than or equal to 500!\n");
                        cycle++; //cycle increment by 1
                        System.out.print("You have 500 points.\nEnter points to wager (-1 to QUIT):\t\t");
                        points = input.nextInt(); // user enter points to wager
                    }else{//if cycle is greater than 0
                        System.out.println("\nPlease enter a wager less than or equal to " + playerPoints + "!\n");
                        cycle++;
                        System.out.print("You have " + playerPoints + "\nEnter points to wager (-1 to QUIT):\t\t");
                        points = input.nextInt(); //user enter points to wager
                        }       
                }else if (points == 0){ //if the points user enter is equal to 0
                    if (cycle == 0){ 
                        System.out.println("\nYou must wager at least one (1) point!\n");
                        cycle++;    //cycle increment by 1
                        System.out.print("You have 500 points.\nEnter points to wager (-1 to QUIT):\t\t");
                        points = input.nextInt();  
                    }else{ //if cycle is greater than 0
                        System.out.println("\nYou must wager at least one  (1) point!\n");
                            if(playerPoints != 500){
                                cycle++;
                                System.out.print("You have " + playerPoints + "\nEnter points to wager (-1 to QUIT):\t\t");
                                points = input.nextInt();
                            }else{
                                System.out.print("You have " + playerPoints + "\nEnter points to wager (-1 to QUIT):\t\t");
                                points = input.nextInt();
                                cycle++;
                            }
                        }
                }else if (points == -1){ //if user enter -1 (to QUIT)
                    System.out.println("\nThank your for playing! Goodbye!");
                    break; //end the program
                }else if (points <= playerPoints && points > 0){ 
    // if the points user enter is less than or equal to the points user currently have and are greater than 0 
                    num1 = randomNumber.nextInt(6) + 1;//  user first random number from 1 to 6
                    num2 = randomNumber.nextInt(6) + 1; // user second random number
                    num3 = randomNumber.nextInt(6) + 1; // computer first random number
                    num4 = randomNumber.nextInt(6) + 1; // computer second random number
                    System.out.println("\nYou rolled a [" + num1 + "][" + num2 + "]");
                    System.out.println("Computer rolled a [" + num3 + "][" + num4 + "]\n");
                    
                        if((num1 + num2) < (num3 + num4)){ 
            //if the sum of two random numbers of user is less than the sum of two random numbers of computer
                            if(cycle == 0){ //if cycle is equal to 0
                                System.out.println("You lose " + points + "!\n");
                                playerPoints -= points; // playerPoints = playerPoints - points
                                    if(playerPoints == 0){ //if player points is equal to 0
                                        System.out.println("GAME OVER! You have zero point left!");
                                        System.out.print("Would you like to play again (Y or N):\t\t");
                                        char decision = input.next().charAt(0); 
                                        //allow user to enter a letter 'Y' or 'N' if he/she wants to play again        
                                            if(decision == 'Y' || decision == 'y'){
                                            //if user enter a letter Y or y to play again
                                                playerPoints = 500;// player point will be reset to 500
                                                System.out.print("\nYou have 500 points.\nEnter points to wager (-1 to QUIT):\t\t");
                                                points = input.nextInt();
                                                cycle++;
                                            }else{ //if user enter a letter N or n to not play again
                                                System.out.println("\nThank your for playing! Goodbye!");
                                                break; //end the program
                                                }    
                                    }else{
                                        System.out.println("You have " + playerPoints + ".");
                                        cycle++;
                                        System.out.print("Enter points to wager (-1 to QUIT):\t\t");
                                        points = input.nextInt();
                                            }
                            }else{ //if cycle is greater than 0 
                                playerPoints = playerPoints - points;
                                    if(playerPoints == 0){ // if player doesn't have any points
                                        System.out.println("You lose " + points + "!\n");
                                        System.out.println("GAME OVER! You have zero point left!");
                                        System.out.print("Would you like to play again (Y or N):\t\t");
                                        char decision = input.next().charAt(0); 
                                            
                                            if(decision == 'Y' || decision == 'y'){
                                             // if user enter a letter Y or y to play again
                                                playerPoints = 500; // player point will be reset to 500
                                                System.out.print("\nYou have 500 points.\nEnter points to wager (-1 to QUIT):\t\t");
                                                points = input.nextInt();
                                                cycle++;
                                            }else{
                                                System.out.println("\nThank your for playing! Goodbye!");
                                                break;
                                                }     
                                            }else{
                                            System.out.println("You lose " + points + "!");
                                            System.out.println("\nYou have " + playerPoints + ".");
                                            cycle++;
                                            System.out.print("Enter points to wager (-1 to QUIT):\t\t");
                                            points = input.nextInt();
                                            }
                                }
                        }else if((num1 + num2) > (num3 + num4)){ 
           //if the sum of two random numbers of user is greater than the sum of two random numbers of computer    
                            if(cycle == 0){
                                System.out.println("You win " + points + "!\n");
                                playerPoints += points;
                                    if(playerPoints > 0){ //if playerPoints is greater than 0
                                        System.out.println("You have " + playerPoints + "."); 
                                        System.out.print("Enter points to wager ( -1 to QUIT):\t\t");
                                        points = input.nextInt();     
                                        }
                            }else if(cycle > 0){ //if cycle is greater than 0
                                playerPoints += points; //playerPoints = playerPoints + points;
                                System.out.println("You win " + points + "!\n");
                                System.out.println("You have " + playerPoints + ".");
                                cycle++;
                                System.out.print("Enter points to wager ( -1 to QUIT):\t\t");
                                points = input.nextInt();
                                }
                        }else{
            //if the sum of two random numbers of user is equal to the sum of two random numbers of computer
                            if(cycle == 0){ //if cycle is equal to 0
                                System.out.print("It's a tie!\nEnter 'R' to roll again:\t\t\t"); 
                                roll = input.next().charAt(0); //allow user to enter 'R' to roll again
                                cycle++; //cycle increment by 1
                                    if(roll == 'R'){ //if user type R
                                        playerPoints += 0; //player will get 0 point
                                        }
                            }else if(cycle > 0){ //if cycle is greater than 0
                                System.out.print("It's a tie!\nEnter 'R' to roll again:\t\t\t");
                                roll = input.next().charAt(0);//allow user to enter 'R' to roll again
                                cycle++;//cycle increment by 1
                                    if(roll == 'R'){ //if user type R
                                        playerPoints += 0; //player will get 0 point
                                        }
                            }
                        }
                }
        }
    }
}


    
        
        