package horseracing;

public class Horse{
        private String name;
        private int mudRating;
        private int grassRating;
        private int dirtRating;
        private double preferredLength;

        private int currentPosition;
        private boolean finishedRace;
        private int number;

        public Horse(String name, int mudRating, int grassRating, int dirtRating, double preferredLength) {
            this.name = name;
            this.mudRating = mudRating;
            this.grassRating = grassRating;
            this.dirtRating = dirtRating;
            this.preferredLength = preferredLength;
            this.currentPosition = 1;
            this.finishedRace = false;
            this.number = 0;
        }
        
        public void setNumber(int number){
            this.number = number;
        }

        public int getNumber(){
            return this.number;
        }

        public void setRaceFinished(boolean finished){
            finishedRace = finished;
        }

        public boolean raceFinished(){
            return finishedRace;
        }
        public String getName() {
            return name;
        }

        public int getMudRating() {
            return mudRating;
        }

        public int getGrassRating() {
            return grassRating;
        }

        public int getDirtRating() {
            return dirtRating;
        }
        
        public double getPreferredLength() {
            return preferredLength;
        }

        public void incrementPosition(int inc){
            currentPosition += inc;
        }

        public int getCurrentPosition(){
            return currentPosition;
        }

        public void resetCurrenPosition(){
            currentPosition = 2;
            finishedRace = false;
        }

        public String getOddsWin(double raceLength, String raceSurface) {
            double winOdd = 2 + Math.abs(preferredLength-raceLength);
    
            //2 is the base min amount return and you can find the difference between the two lengths
            // the smaller the difference is, the larger possibility 
            // the larger the difference is, the smaller possibility 


            if (raceSurface == "Dirt"){
                if(getDirtRating()>=9){ //the higher the ratings, the higher possibility winning
                    winOdd+=0; // and low odds= high probability
                }
                else if(getDirtRating()>=8){ //this pattern continues as the ratings get smaller
                    winOdd+=1;
                }
                else if(getDirtRating()>=7){
                    winOdd+=2;
                }
                else if(getDirtRating()>=6){
                    winOdd+=3;
                }
                else if(getDirtRating()>=5){
                    winOdd+=4;
                }
                else if(getDirtRating()<5){
                    winOdd+=5;
                }

            }
            else if(raceSurface =="grass"){ // this is the same if the surface is grass
                if(getGrassRating()>=9){
                    winOdd+=0;
                }
                else if(getGrassRating()>=8){
                    winOdd+=1;
                }
                else if(getGrassRating()>=7){
                    winOdd+=2;
                }
                else if(getGrassRating()>=6){
                    winOdd+=3;
                }
                else if(getGrassRating()>=5){
                    winOdd+=4;
                }
                else if(getGrassRating()<5){
                    winOdd+=5;
                }
            }
            else{ // and its the same if the surface is mud 
                if(getMudRating()>=9){
                    winOdd+=0;
                }
                else if(getMudRating()>=8){
                    winOdd+=1;
                }
                else if(getMudRating()>=7){
                    winOdd+=2;
                }
                else if(getMudRating()>=6){
                    winOdd+=3;
                }
                else if(getMudRating()>=5){
                    winOdd+=4;
                }
                else if(getMudRating()<5){
                    winOdd+=5;
                }
            }

            return ("" + winOdd + "-1"); //returns the odds for winning. this means for every dollar that was bet, winOdd amount is returned

        }  

        public String getOddsPlace(double winOdd){
             //the probability for placing is higher than the probability of winning
             //so, if the winning odds is already low, then we want to make the placing odds even lower 
             //if the winning odd is high, the placing odd would be lower but would still be high
             

            double placeOdd = 0; 

            //for these three i cant put them in the if statements so simply 
            //because if we subtract them by 2 the odds will be too low to be possible
            //if we subtract them by anything smaller than 2, then it wouldn't make sense because all these numbers have high possibity 
            //and if we were to subtract them by numbers smaller than 2, then it's saying all these numbers have low possibilities
            
            if(winOdd==2){ //if the winOdd is 2-1 which is a super high probability, the placeOdd is 4-3 
                placeOdd=4;
            }
            if(winOdd==2.5){ //if the winOdd is 2.5-1, the placeOdd is 2-1
                placeOdd=2;
            }
            if (winOdd==3){ // if the winOdd is 3-1, the placeOdd is 1.5-1
                placeOdd=1.5;
            }
            if(winOdd==3.5){ //if the winOdd is 3.5-1, the placeOdd is 2.5-1
                placeOdd=2.5;

            }
            
            if (winOdd>=4 && winOdd<6){ //if the winOdd is greater or equal to 4, but smaller than 6, the place odd is winOdd-2 
                //this means that it get in numbers from 4, 4.5, 5
                placeOdd = winOdd - 2; 
                //and then it subtracts 2 from the winodd because placing increases the possibility. 

            }     
             if(winOdd>=6 &&winOdd<8){ //can get numbers from 6, 6.5, 7
                placeOdd = winOdd - 1.5; //and as the possibility for winning decreases, the possiblity to place also decreases. 
                //so even if placing increases the possibility, it wouldn't increase as much as the one above

            }    
             if(winOdd>=8 && winOdd<10){ // can get numbers from 8,8.5,9
                placeOdd = winOdd - 1;
                //similar ideas as the one above. The possbility to place increase, but not as much because the possibility to win is already so low. 
            }
             if(winOdd>=10){ //any number equal or above 10
                placeOdd = winOdd - 0.5;
                //extremely low possibility 
            }
            if(placeOdd==4) //this is for the code I hardcoded for winOdd=2 above. 
                return "" + placeOdd + "-3";
            
    
            return "" + placeOdd + "-1"; 
        }
        
        public String getOddShow(double placeOdd){ //similarly I did this for odds to show
            double showOdd = 0; 
     
            if(placeOdd==1.5){ //if the odds is 1.5-1, the showing odds is 3.5-3
                showOdd=3.5;
            }

            if(placeOdd==2){ //if the odds is 2-1, the showing odds is 4-3
                showOdd=4;
            }
           
            if(placeOdd==2.5){ //is the odds is 2.5 -1, the showing odds is 2-1
                showOdd=2;
            }
            
            if (placeOdd==3){ //if the place is 3-1, the showing odds is 1.5-1
                showOdd=1.5;
            }
            if(placeOdd==3.5){ //if the place is 3.5-1, the showing odds is 2.5-1;
                showOdd=2.5;
            }

            if(placeOdd==4){ //this is for the odds 4-3, then the showing odd would be 5-4
                showOdd=5;
            }
            
            if(placeOdd>4 && placeOdd<6){
                showOdd = placeOdd -2; //this is very similar for the odds to place 
            }
            else if(placeOdd>=6 && placeOdd<8){
                showOdd = placeOdd -1.5;
            }
            else if(placeOdd>=8 && placeOdd<10){
                    showOdd = placeOdd -1;
            }
            else if(placeOdd>=10){
                showOdd = placeOdd -0.5;
            }
                     
                if (showOdd==4){
                    return ("" + showOdd + "-3"); //this refers to the code above about how 2-1 turns into 4-3
                }
                if (showOdd==5){
                    return ("" + showOdd + "-4"); //this refers to the code above about how 4-3 placeOdd turns into 5-4 showOdd
                }
                if (showOdd==3.5){
                    return ("" + showOdd + "-3");  //this refers to the code above about how 1.5-1 placeOdd turns into 3.5-3 showOdd
                }

                return ("" + showOdd + "-1"); 
                

        }
    }

    
    



    