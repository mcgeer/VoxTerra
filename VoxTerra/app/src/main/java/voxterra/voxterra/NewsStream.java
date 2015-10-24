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
            String name = Sim.continentNames[i];

            if (Sim.getContinentStat(name).getWaterThreshold() < Sim.getWaterLevel()&& !Sim.getContinentStat(name).isFlooding)  //Adds flooding
            {
                event = {name, "Flooding occurs in "+name, Str(Sim.getTime())};

                Sim.getContinentStat(name).stateFlooding = True;

                recentNews.add(event);

            } else if(Sim.getContinentStat(name).getWaterThreshold() > Sim.getWaterLevel()&& Sim.getContinentStat(name).isFlooding)//removes flooding
            {
                event = {name, "Flooding stops in "+name, Str(Sim.getTime())};

                Sim.getContinentStat(name).stateFlooding = False;

                recentNews.add(event);
            }

            if (getContinent)

        }

        eventHistory.addAll(recentNews);
        return recentNews;
    }

    public int randInt(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }

}
