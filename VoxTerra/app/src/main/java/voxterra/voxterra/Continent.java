package voxterra.voxterra;

/**
 * Created by riley_000 on 2015-10-24.
 */
public class Continent {
    private long    population;
    private double  growth;
    private double  freshWater; //Percentage
    private int     temperature;
    private double  relations; //Percent relations with countries
    private double  stability; //Percent political stability of the countries in the continent

    public Continent(long population,int temperature, double growth, double freshWater, double relations, double stability){
        this.population     = population;
        this.growth         = growth;
        this.freshWater     = freshWater;
        this.temperature    = temperature;
        this.relations      = relations;
        this.stability      = stability;
    }
    //===================Setter Methods===================//
    public long getPopulation(){
        return this.population;
    }

    public int getTemperature(){
        return this.temperature;
    }

    public double getGrowth(){
        return this.growth;
    }

    public double getFreshWater(){
        return this.freshWater;
    }

    public double getRelations(){
        return this.relations;
    }

    public double getStability(){
        return this.stability;
    }

    //===================Getter Methods===================//
}
