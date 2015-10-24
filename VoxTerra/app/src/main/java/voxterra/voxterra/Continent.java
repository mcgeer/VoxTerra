package voxterra.voxterra;

/**
 *Sets up continents and their variables
 */
public class Continent {
    private final String  name;
    private long        population;
    private long        emissions;
    private int         temperature;
    private final int   MAX_WATER_LEVEL;
    private double      fresh_water; //Percentage
    private double      growth;
    private double      relations; //Percent relations with countries
    private double      stability; //Percent political stability of the countries in the continent

    public Continent(String name, long population, long emissions, int temperature, int MAX_WATER_LEVEL, double fresh_water ,double growth,  double relations, double stability){
        this.name           = name;
        this.population     = population;
        this.emissions      = emissions;
        this.growth         = growth;
        this.MAX_WATER_LEVEL = MAX_WATER_LEVEL;
        this.fresh_water    = fresh_water;
        this.temperature    = temperature;
        this.relations      = relations;
        this.stability      = stability;
    }
    //===================Setter Methods===================//
    public String getName(){
        return this.name;
    }

    public long getPopulation(){
        return this.population;
    }

    public long getEmissions(){
        return this.emissions;
    }

    public int getTemperature(){
        return this.temperature;
    }
    public int getMAX_WATER_LEVEL(){
        return this.MAX_WATER_LEVEL;
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

    public void updateGrowth(long max_emissions){
        double emissions_ratio = this.emissions/max_emissions;
        if(emissions_ratio > 1.0){ emissions_ratio = 1.0;}
        else if(emissions_ratio < - 1.0){emissions_ratio = -1.0;}
        this.growth = (0.4 * (this.fresh_water - 0.5)) + (0.4 * (this.stability - 0.5)) + (0.2 * (emissions_ratio - 0.2));
    }
    //====================State Methods====================//
    public boolean isFlooding(int water_level){
        return (water_level > this.MAX_WATER_LEVEL);


    public boolean isDrought(){
        return (this.fresh_water < 0.20);
    }

}
