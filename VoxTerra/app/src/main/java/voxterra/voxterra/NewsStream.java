package voxterra.voxterra;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by riley_000 on 2015-10-24.
 */
public class NewsStream {

    private ArrayList<String[]> eventHistory = new ArrayList<String[]>();
    //private int eventCooldown = 0;


    public ArrayList<String[]> retrieveNews(){

        ArrayList<String[]> recentNews = new ArrayList<String[]>();

        String[] event = new String[3];  //location, description, time occurred

        for (int i = 0;i < Sim.continentNames.length; i++)      //per-continent events
        {
            Continent selectedContinent = Sim.getContinent(Sim.continentNames[i]);

            if (selectedContinent.getMAX_WATER_LEVEL() < Sim.getWaterLevel()&& !selectedContinent.isFlooding(Sim.getWaterLevel()))  //Adds flooding
            {
                event = {name, "Flooding occurs in "+name, Str(Sim.getTime())};
                selectedContinent.isFlooding = true;
                recentNews.add(event);

            } else if(selectedContinent.getMAX_WATER_LEVEL() >= Sim.getWaterLevel()&& selectedContinent.isFlooding(Sim.getWaterLevel()))//removes flooding
            {
                event = {name, "Flooding stops in "+name, Str(Sim.getTime())};
                selectedContinent.isFlooding = false;
                recentNews.add(event);
            }

            if (selectedContinent.getFreshWater()<0.2 && !selectedContinent.isDrought)
            {
                event = {name, name+" experiences drough across the land", Str(Sim.getTime())};
                selectedContinent.isDrought = true;
                recentNews.add(event);
            } else if(selectedContinent.getFreshWater()>=0.2 && selectedContinent.isDrought)
            {
                event = {name, name+"'s drought comes to an end", Str(Sim.getTime())};
                selectedContinent.isDrought = false;
                recentNews.add(event);
            }

        }

        eventHistory.addAll(recentNews);
        return recentNews;
    }

    public int randInt(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }

}
