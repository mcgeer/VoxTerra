package voxterra.voxterra;

/**
 * Created by riley_000 on 2015-10-24.
 */
public class Continent {
    private long    population;
    private long    emissions;
    private double  growth;
    private double  fresh_water; //Percentage
    private int     temperature;
    private double  relations; //Percent relations with countries
    private double  stability; //Percent political stability of the countries in the continent

    public Continent(long population,long emissions, int temperature, double growth, double fresh_water, double relations, double stability){
        this.population     = population;
        this.emissions      = emissions;
        this.growth         = growth;
        this.fresh_water     = fresh_water;
        this.temperature    = temperature;
        this.relations      = relations;
        this.stability      = stability;
    }
    //===================Setter Methods===================//
    public long getPopulation(){
        return this.population;
    }

    public long getEmissions(){
        return this.emissions;
    }

    public int getTemperature(){
        return this.temperature;
    }

    public double getGrowth(){
        return this.growth;
    }

    public double getFreshWater(){
        return this.fresh_water ;
    }

    public double getRelations(){
        return this.relations;
    }

    public double getStability(){
        return this.stability;
    }

    //===================Setter Methods===================//

    public void setPopulation(long population){
        this.population = population;
    }


    public void setEmissions(long emissions){
        this.emissions = emissions;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void setGrowth(double growth){
        this.growth = growth;
    }

    public void setFreshWater(double fresh_water){
        this.fresh_water = fresh_water;
    }

    public void setRelations(double relations){
        this.relations = relations;
    }

    public void setStability(double stability){
        this.stability = stability;
    }
}
