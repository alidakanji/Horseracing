package horseracing;

import java.util.Scanner;

public class HorseRacing {
// test1234
// awesomesauce
//hi

public double moneyamt; 
public double bettingamt;
public int x;
public boolean gameOver;
public double winOdd; 
public double placeOdd; 
public double showOdd;
     public static void main(String[] args) {
        System.out.print("\u001B[?25l");  // Hide the cursor
        
        Scanner in = new Scanner(System.in);    
        HorseRacingHelper.prepareHorseRacingSimulation();
        boolean gameOver = false;

           while(!gameOver){
            HorseRacingHelper.clearConsole();

            int numHorsesInRace = (int)(Math.random()*7)+5;

            Race race = HorseRacingHelper.createRace(numHorsesInRace, HorseRacingHelper.SHORT, HorseRacingHelper.DIRT);
            race.displayRaceInfo();

            Scanner input = new Scanner(System.in);
        
            System.out.println("Do you want to bet on a horse? 0 for Yes, 1 for no"); //this limits the answers only in numerical form - CG
            int x = input.nextInt(); 
            if(x==0){
                    System.out.println("How much money do you have?");//if the user doesn't have any money, they cant bet - CG
                    int moneyamt = input.nextInt();
                    if(moneyamt>0){
                        
                        System.out.println("How much money do you want to bet?");
                        double bettingamt = input.nextDouble();
           
                       if(bettingamt<=moneyamt){
                   
                       System.out.println("Which horse do you want to bet on?"); // this would refer to my instance horseBet - CG
                       int horseBet = input.nextInt();
           
                       System.out.println("Are you betting to win(1), place(2), or show(3)?"); // this would refer to my instance betType -CG
                       int betType = input.nextInt(); 
           
                       }
                        
            
                        race.startRace();
            
                        race.bettingResults(); 
                        // I called my betting Results function - CG
                        // I called this after the race so we can know the results and compare - CG
            
                        // i called the betting
                        System.out.println("Race is Over");
                        
                        //after the race is finished, I called my bettingResult to show if the person won any money -CG
                        gameOver = playAgain(in);
                    
            
                    }

                    while(moneyamt<=0){
                        System.out.println("please enter a larger number"); //if the person doesn't have any money
                        System.out.println("How much money do you have?"); 
                        int i = input.nextInt();
                        if(i>0) //if the person enters a number greater than 1

                        race.startBetting();
                                               
            
                        race.startRace();
            
                        race.bettingResults(); 
                        System.out.println("Race is Over");
                        
                        gameOver = playAgain(in);
            
                        
                    } 
            }
        else 
        System.out.println("let us now when you are");
        }
     }
                    
                

        

    private static boolean playAgain(Scanner in) {
        System.out.print("\u001B[?25l");  // Hide the cursor

        System.out.print("Play Again: (y/n): ");
        String result = in.nextLine();

        if (result.equals("n"))
            return true;

        return false;

    }
}
