package voxterra.voxterra;

public class Sim {
    private long globalPopulation;

    //Declare the continents
    private int num_continents = 7;
    private Continent[] continents = new Continent[num_continents];

    //Global variables
    private long co2_original = 100; //CHANGE THIS VALUE
    private long co2 = co2_original;

    private long temperature_original = 0;

    //Getters
    private long getWaterLevel(){

    }

    private int getTemperature(){
        //Calculated from c02

        /*Temperture goes up 2 degress for double C02!

        "...the last IPCC report (AR4) described the likely range as between 2 and 4.5 degrees C,
        for double the amount of CO2 compared to pre-industrial levels."
        (https://www.skepticalscience.com/co2-temperature-correlation.htm) */
    }

    private long getNews(){

    }

    private long getCo2(){
        return co2;
    }

    private Continent getContinentStat(String name){
        for (int i=0;i<num_continents;i++){
            if (continents[i].name == name){
                return continents[i];
            }
        }
    }
}
