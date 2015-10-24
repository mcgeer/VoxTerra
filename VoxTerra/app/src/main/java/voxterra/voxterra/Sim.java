package voxterra.voxterra;

public class Sim {
    private long global_population;

    //Declare the continents
    private int num_continents = 7;

    //String name, long population,long emissions, int temperature, double growth, double fresh_water, double relations, double stability
    Continent[] continents = {new Continent("North America",5287582631L,6672919291L,5,6,0.007,0.98,0.7,0.98)};

    //Global variables
    private long co2_original = 100000; //CHANGE THIS VALUE
    private long co2 = co2_original;

    private int temperature_original = 6; //CHANGE THIS VALUE

    //Getters
    public static long getWaterLevel(){

    }

    public static int getTemperature(){
        //Calculated from c02

        //NEED TO RECONSIDER THIS FORMULA
        return (int) (co2*0.0001);
    }

    public static String getNews(){

    }

    public static long getCo2(){return co2;}

    public static long getPopulation(){
        global_population=0;
        for (int i=0;i<num_continents;i++){
            global_population+=continents[i].getPopulation();
        }
        return global_population;
    }

    public static Continent getContinentStat(String name){
        for (int i=0;i<num_continents;i++){
            if (continents[i].name == name){
                return continents[i];
            }
        }
    }
}
