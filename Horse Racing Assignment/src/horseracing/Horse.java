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
            double winBet = 1;
            //refers to how much money you're putting in

            if (raceSurface == "dirt"){
                if(getDirtRating()>5){ // the ratings range from 1 to 10 and 5 is the middle.
                    // if the rating is higher than 5, they get a higher possibility
                    winBet++; 
                    
                }
    
            }
            else if(raceSurface =="grass"){
                if(getGrassRating()>5){
                    winBet++; 
                }
            }
            else{
                if(getMudRating()>5){
                    winBet++;
                }
            }
            
            return "" + winOdd + "-" + winBet;
        } 
    }

        



    