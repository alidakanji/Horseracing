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


            if (raceSurface == "dirt"){
                if(getDirtRating()>=9){ //the higher the ratings, the higher possibility winning
                    winOdd+=0; // and low odds= high probability
                }
                else if(getDirtRating()>=8){
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
            else if(raceSurface =="grass"){
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
            else{
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
           if(winOdd%1==0.5)
            return "" + winOdd*2 + "-2";
            else 
            return "" + winOdd + "-1";

        }  

        public String getOddsPlace(int winOdd){
             //the probability for placing is higher than the probability of winning
             //so, if the winning odds is already low, then we want to make the placing odds even lower 
             //if the winning odd is high, the placing odd would be lower but would still be high

            double placeOdd = 0;
            if(winOdd>=4 && winOdd<=5){ //"">=4" ensures that after -2 the minimum result is 2
                placeOdd = winOdd - 2;

            }     
            else if(winOdd>=6 &&winOdd<=8){
                placeOdd = winOdd - 1.5;

            }    
            else if(winOdd>=8 && winOdd<=10){
                placeOdd = winOdd - 1;
            }
            else if(winOdd>10){
                placeOdd = winOdd - 0.5;

            }
            if(placeOdd%1==0.5)
                return "" + placeOdd*2 + "-2";
            else 
                return "" + placeOdd + "-1";
        }
        
        public String getOddShow(int winOdd, int placeOdd){
            int showOdd = 0; 
            if(placeOdd>=3 && placeOdd<=5){
                showOdd = placeOdd +1; //because winning and 
            }
            else if(placeOdd>=4 && placeOdd<=8){
                showOdd = placeOdd +2;
            }
            else if(placeOdd>=7 && placeOdd<=10){
                    showOdd = placeOdd +3;
            }
            else if(winOdd>11){
                showOdd = winOdd + 4;
            }

            if(showOdd%1==0.5)
                return "" + showOdd*2 + "-2";
            else 
                return "" + showOdd + "-1";

        }
    }

    
    



    