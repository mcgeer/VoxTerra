package voxterra.voxterra;

public class Sim {
    private static long global_population;

    //Declare the continents
    private static int num_continents = 7;

    //String name, long population,long emissions, int temperature, int MAX_WATER_LEVEL, double growth, double fresh_water, double relations, double stability
    private static Continent[] continents = {new Continent("North America",5287582631L,6672919291L,5,6,0.007,0.98,0.7,0.98)};

    //Global variables
    private static long co2_original = 100000; //CHANGE THIS VALUE
    private static long co2 = co2_original;

    private static int temperature_original = 6; //CHANGE THIS VALUE

    private static int water_level = 0;

    //Getters
    public static int getWaterLevel(){
        return water_level;
    }

    public static int getTemperature(){
        //Calculated from c02

        //NEED TO RECONSIDER THIS FORMULA
        return (int) (co2*0.0001);
    }

    public static String getNews(){
        return NewsStream.receiveNews();
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
            if (continents[i].name == name){
                return continents[i];
            }
        }
    }
}
