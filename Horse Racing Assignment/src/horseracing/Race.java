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
    public double winOdd; // i created an instance for odds on winning in horse classn 
     public double placeOdd; 
     public double showOdd; 
    public double win;
    public double place;
    public double show;



    public double moneyamt; 
    public double bettingamt;

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
    
    public double getOddsWin(double raceLength, String raceSurface) {
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

            //basically gets the input from s6 
            //but s6 is a string with a number in it, and we only want the number
            //so we're taking the substring of s6 till the index where the dash is(which is the next index after the number)
            //then we're turning this into a double 
            String s8 = "" + horse.getOddShow(Double.parseDouble(s7.substring(0,s7.indexOf("-"))));
            

            //the same logic for getting a double version of the input from s7 

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
        Scanner input = new Scanner(System.in);
        
            System.out.println("How much money do you want to bet?");
             bettingamt = input.nextDouble();

            if(bettingamt<=moneyamt){
        
            System.out.println("Which horse do you want to bet on?"); // this would refer to my instance horseBet - CG
            horseBet = input.nextInt();

            System.out.println("Are you betting to win(1), place(2), or show(3)?"); // this would refer to my instance betType -CG
            betType = input.nextInt(); 

            }

            else
                 System.out.println("please enter an amount inside your budget"); 
        }



        public void bettingResults(){
            System.out.println(showOdd);

        if(betType ==1){ // if the user is betting to win
            
            double earnedDollars = win*bettingamt;
            if(horseBet== results.get(0).getNumber()) // results.get(i).getNumber basically gets the number of the horse at i index- CG

            System.out.println("yay, you won!"); //this one basically gets the number of the horse that came first and if the horse the user bets on wins then they made money!- CG
            else
            System.out.println("sorry, you didn't win..."); // if they bet to win, but their horse didn't place, they dont make money- CG
        }
    
    
        else if( betType==2){

          
        
            

            if(placeOdd==4){ //odd is 4-3, but the actual ratio value is 4/3
                placeOdd=4/3;
                System.out.println(placeOdd);
            }

            double earnedDollars = placeOdd*bettingamt;


            if (horseBet== results.get(0).getNumber()|| horseBet== results.get(1).getNumber()) // if the horseBet is the horse that came first OR second - CG
                System.out.println("yay, you won!");// then they make money - CG        
            else
                System.out.println("sorry, you didn't win..."); // if their horse didn't win first or second, then they dont make money- CG
        }


        else if( betType==3){


            if (showOdd==4){
                showOdd=showOdd/3; //refers to how the odd is 4-3, but the actual value is 4/3
                System.out.println(showOdd);
            }
            if (showOdd==5){
                showOdd=showOdd/4; // refers to  the odd is 5-4, but the acutal value is 5/4
                System.out.println(showOdd);

            }
            if (showOdd==3.5){
                 showOdd= showOdd/3; // refers to the how the odd is 3.5-3, but the actual value is 3.5/3;
                 System.out.println(showOdd);

            }
            else 
            showOdd=showOdd/1;


            double earnedDollars = showOdd*bettingamt;

            if( horseBet== results.get(0).getNumber() ||  horseBet== results.get(1).getNumber() || horseBet == results.get(2).getNumber()){ // if the horse came first, second of third - CG
            System.out.println("yay, you won!");  //then they make money- CG
        }
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


