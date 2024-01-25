package horseracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// test
public class Race {
    private List<Horse> horses;
    private double raceLength; // in furlongs
    private String raceSurface; // "grass", "dirt", or "mud" (Uses HorseRacingHelper constants)
    private int currentHorse;
    private int betType; //i created an instance for the betting type (to win, place or show) - CG
    private int horseBet;//then I created a instance called horseBet to represent which horse the user is betting on - CG
    private int winOdd; // i created an instance for odds on winning in horse classn 
    private int placeOdd; 
    private int ShowOdd; 
    private int bettingamt;

    private List<Horse> results;


    public Race(List<Horse> horses, double raceLength, String raceSurface) {
        this.horses = horses;
        this.raceLength = raceLength;
        this.raceSurface = raceSurface;
        this.currentHorse = 0;
        this.results = new ArrayList<Horse>();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public int numHorses(){
        return horses.size();
    }

    public Horse getNextHorse(){
        if (currentHorse == horses.size())
            currentHorse = 0;
        
        return horses.get(currentHorse++);
    }

    public double getRaceLength() {
        return raceLength;
    }

    public String getRaceSurface() {
        return raceSurface;
    }
    
    public int getOddsWin(double raceLength, String raceSurface) {
        return winOdd;

    }
   


    public void displayHorseTable(){
        String s9 = "Horse Name";
        System.out.println("+--------------------+-----------+------------+----------+----------------+--------+----------+--------+");
        System.out.printf("|%-20s|Dirt Rating|Grass Rating|Mud Rating|Preferred Length|OddsWin |OddsPlace |OddsShow|\n", s9);
        System.out.println("+--------------------+-----------+------------+----------+----------------+--------+----------+--------+");
        for (int i = 0; i < horses.size(); i++) {   // iterates through the horses list
            Horse horse = horses.get(i);
            String s1 = "" + horse.getName();
            String s2 = "" + horse.getDirtRating();
            String s3 = "" + horse.getGrassRating();
            String s4 = "" + horse.getMudRating();
            String s5 = "" + horse.getPreferredLength();
            String s6 = "" + horse.getOddsWin(raceLength,raceSurface);
            String s7 = "" + horse.getOddsPlace(Double.parseDouble(s6.substring(0,s6.indexOf("-"))));
            String s8 = "" + horse.getOddShow(Double.parseDouble(s7.substring(0,s7.indexOf("-"))));
            

            System.out.println("\"+-------------------+-----------+------------+----------+----------------+--------+----------+--------+\"");
            System.out.printf("|%-20s|%11s|%12s|%10s|%17s|%7s|%7s|%7s|\n", s1, s2, s3, s4, s5, s6, s7,s8);
        }
        //System.out.println("+--------------------+-----------+------------+----------+----------------+");
           // String s6 = "" + horse.getOddsWin(raceLength,raceSurface) + "-" + winBet;
            //System.out.println("+--------------------+-----+-----+-----+-----+---------+--------+----------+");
            //System.out.printf("|%-20s|%5s|%5s|%5s|%5s|%5s|\n", s1, s2, s3, s4, s5);
            //System.out.println("+--------------------+-----------+------------+----------+----------------+");
        }
       

    public void displayRaceInfo() {
        System.out.println("Race Information:");
        System.out.println("Race Surface: " + raceSurface);
        System.out.println("Race Length: " + raceLength + " furlongs");
        System.out.println("List of Horses:");
        // for (Horse horse : horses) {
        //     System.out.println("- " + horse.getName());
        // }
        displayHorseTable();
    }

    

    public void displayResults(){
        System.out.println("\n\nRace Results");
        System.out.println("------------");
        for(int i=0; i<results.size(); i++){
            System.out.println((i+1) + ": " + results.get(i).getName() + "("+results.get(i).getNumber()+")");
        }
     


    
    }

   
    
    public void startBetting(){
        System.out.println("Do you want to bet on a horse? 0 for Yes, 1 for no"); //this limits the answers only in numerical form - CG
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(); 
        input.close();
        if(x==0){
            System.out.println("How much money do you have?");//if the user doesn't have any money, they cant bet - CG
            int moneyamt = input.nextInt();
            
            if(moneyamt>0){

            System.out.println("How much money do you want to bet?");
            double bettingamt = input.nextInt();

            if(bettingamt<=moneyamt){
        
            System.out.println("Which horse do you want to bet on?"); // this would refer to my instance horseBet - CG
            horseBet = input.nextInt();

            System.out.println("Are you betting to win(1), place(2), or show(3)?"); // this would refer to my instance betType -CG
            betType = input.nextInt(); 

            }

            else
                 System.out.println("please enter an amount inside your budget"); 
        }


            else{
                System.out.println ("Sorry, you dont have enough money!");
                }

        }
        else{
            System.out.println("That's okay, let us know when you are!");
        }


    }
         public void bettingResults(){

        if(betType ==1){ // if the user is betting to win
            if(horseBet== results.get(0).getNumber()) // results.get(i).getNumber basically gets the number of the horse at i index- CG
            System.out.println("Yay, you earned" + bettingamt+ "dollars!"); //this one basically gets the number of the horse that came first and if the horse the user bets on wins then they made money!- CG
            else
            System.out.println("sorry, you didn't win..."); // if they bet to win, but their horse didn't place, they dont make money- CG
        }
    
    
        else if( betType==2){
            if (horseBet== results.get(0).getNumber()|| horseBet== results.get(1).getNumber()) // if the horseBet is the horse that came first OR second - CG
                System.out.println("Yay, you earned" + bettingamt+ "dollars");// then they make money - CG        
            else
                System.out.println("sorry, you didn't win..."); // if their horse didn't win first or second, then they dont make money- CG
        }


        else if( betType==3){
            
            if( horseBet== results.get(0).getNumber() ||  horseBet== results.get(1).getNumber() || horseBet == results.get(2).getNumber()) // if the horse came first, second of third - CG
            System.out.println("Yay, you earned " + bettingamt + " dollars");  //then they make money- CG
                
            else
                System.out.println("sorry, you didn't win...");//if their horse didn't win first OR second OR third, they dont make money - CG
        } 

         }


    

        
    




    public void startRace(){
        resetHorses();
        int numSpaces = (int)(raceLength*10);
        boolean done = false;
        HorseRacingHelper.pauseForMilliseconds(1000);
        HorseRacingHelper.playBackgroundMusicAndWait("Race.wav");
        HorseRacingHelper.playBackgroundMusic("horse_gallop.wav", true);

        
        while(!done){
            HorseRacingHelper.pauseForMilliseconds(40);
            HorseRacingHelper.clearConsole();
            HorseRacingHelper.updateTrack(numSpaces, horses);
            Horse horse = getNextHorse();
           

            if(!horse.raceFinished() && horse.getCurrentPosition() >= numSpaces){
                results.add(horse);
                horse.setRaceFinished(true);
            } else if(!horse.raceFinished()){
                horse.incrementPosition(getIncrementForHorse(horse));
            }

            displayResults();

            if (results.size() == horses.size())
                done = true;

        }



        HorseRacingHelper.stopMusic();
    }
    // Other methods for simulating the race, calculating winners, etc., can be added as needed

    private int getIncrementForHorse(Horse horse) {


        int d = (int)(7 - Math.abs(horse.getPreferredLength() - this.raceLength));

        if (raceSurface.equalsIgnoreCase("grass"))
            d += horse.getGrassRating() / 2;
        else if (raceSurface.equalsIgnoreCase("mud"))
            d += horse.getMudRating() / 2;
        else if (raceSurface.equalsIgnoreCase("dirt"))
            d += horse.getDirtRating() / 2;
        
       return d;
    }

    


    private void resetHorses() {
        for (Horse horse : horses) {
            horse.resetCurrenPosition();
        }
    }
}

