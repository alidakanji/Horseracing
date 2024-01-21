package horseracing;

import java.util.Scanner;

public class HorseRacing {
// test1234
// awesomesauce
//hi
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


            race.startBetting();
            // I called my function called startBetting because Horseracing is the main where everything is ran - CG
            // i called this after the display race info so the user can know the different odds- CG
            //I called this before the race because users have to bet before the race starts- CG

            race.startRace();

            race.bettingResults(); 
            // I called my betting Results function - CG
            // I called this after the race so we can know the results and compare - CG

            // i called the betting
            System.out.println("Race is Over");
            
            //after the race is finished, I called my bettingResult to show if the person won any money -CG
            gameOver = playAgain(in);

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
