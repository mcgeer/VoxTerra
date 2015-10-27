package voxterra.voxterra;

/**
 * Used to simulate the planet and is the backbone to the whole program
 * Riley: I changed num continents to 1 for now!
 */
public class Sim {
    //=====================GLOBAL VARIABLES=====================//
    private static long global_population;
    //Declare the continents
    private static int num_continents = 1;
    //String name, long population,long emissions, int temperature, int MAX_WATER_LEVEL, double growth, double fresh_water, double relations, double stability
    private static Continent[] continents = {new Continent("North America",5287582631L,6672919291L,5,6,0.007,0.98,0.7,0.98)};
    //USER VARIABLES
    private static long user_money      = 100000000L;
    private static long weekly_income   = 1000000L;
    //Earths variables

    private static long co2_original    = 100000; //CHANGE THIS VALUE
    private static long co2             = co2_original;

    private static int temperature_original = 6; //CHANGE THIS VALUE
    private static int temperature = temperature_original;
    private static int water_level = 0;

    //======================GETTER METHODS======================//
    public long getMoney(){
        return this.user_money;
    }

    public long getWeekly_income() {return this.weekly_income;}

    public static int getCurrentWaterLevel(){
        return water_level;
    }

    public static int getCurrentTemperature(){
        /*
        Calculated from c02
        NEED TO RECONSIDER THIS FORMULA YES FIX THIS
        */
        return (int) (co2*0.0001);
    }

    public static String getNews(){
        return NewsStream.retrieveNews();
    }

    public static long getCo2(){return co2;}

    public static long getPopulation(){
        global_population=0;
        for (int i=0;i<num_continents;i++){
            global_population+=continents[i].getPopulation();
        }
        return global_population;
    }

    public static Continent getContinent(String name){
        for (int i=0;i<num_continents;i++){
            if (continents[i].getName() == name){
                return continents[i];
            }
        }
        return null;
    }
    //======================SETTER METHODS======================//
    private void setWeeklyIncome(long weekly_income){
        this.weekly_income = weekly_income;
    }

    private void increaseMoney(long money){
        this.user_money += money;
    }

    private void decreaseMoney(long money){
        this.user_money -= money;
    }
    //======================STATE METHODS=======================//

   public void SimulateWeek(){
        //This needs to be called ever week, Make a timer for this say 5 seconds for test 30 seconds for game
        //Pause timer before calling this
        //Get the news and allow actions on it
        String WeeklyNews = getNews();
        //Do what is needed for news
        //Global vars = 0
        for (int current_continent = 0; current_continent < num_continents; current_continent++){
            //In here += all global vars as well
            Continent update_cont = continents[current_continent];
            update_cont.setPopulation((long)(update_cont.getPopulation()*update_cont.getGrowth()));
            update_cont.setEmissions((long)(update_cont.getEmissions()*update_cont.getGrowth()));       //FIX THIS
            //update_cont.setFreshWater();  //Wont always change
            //update_cont.setRelations();   //Wont always change
            //update_cont.setStability();   //Wont always change
            update_cont.setTemperature(getCurrentTemperature()); //Will always change
            //update_cont.updateGrowth();   //Will always change
        }

        //Increase money based on funding for environment and donations
        increaseMoney(getWeekly_income());
        //Un-pause after return

        return;
    }
}
