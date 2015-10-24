package voxterra.voxterra;

public class Sim {
    private long global_population;

    //Declare the continents
    private int num_continents = 7;
    private Continent [] continents = new Continent[num_continents];

    //Global variables
    private long co2_original = 100000; //CHANGE THIS VALUE
    private long co2 = co2_original;

    private int temperature_original = 10; //CHANGE THIS VALUE

    //Getters
    private long getWaterLevel(){

    }

    private int getTemperature(){
        //Calculated from c02

        //NEED TO RECONSIDER THIS FORMULA
        return (int) (co2*0.0001);
    }

    private String getNews(){

    }

    private long getCo2(){return co2;}

    private long getPopulation(){
        global_population=0;
        for (int i=0;i<num_continents;i++){
            global_population+=continents[i].getPopulation();
        }
        return global_population;
    }

    private Continent getContinentStat(String name){
        for (int i=0;i<num_continents;i++){
            if (continents[i].name == name){
                return continents[i];
            }
        }
    }
}
