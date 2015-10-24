package voxterra.voxterra;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by riley_000 on 2015-10-24.
 */
public class NewsStream {

    private ArrayList<String[]> eventHistory = new ArrayList<String[]>();
    //private int eventCooldown = 0;


    public ArrayList<String[]> getNews(){

        ArrayList<String[]> recentNews = new ArrayList<String[]>();

        String[] event = new String[3];  //location, description, time occurred

        for (int i = 0;i < continentNames.length; i++)      //per-continent events
        {
            String name = continentNames[i];

            if (getContinent(name).getWaterThreshold() < getWaterLevel()&& !getContinent(continentNames[i]).isFlooding)  //Adds flooding
            {
                event = {name, "Flooding occurs in "+name, Str(getTime())};

                getContinent(name).stateFlooding = True;

                recentNews.add(event);

            } else if(getContinent(name).getWaterThreshold() > getWaterLevel()&& getContinent(continentNames[i]).isFlooding)//removes flooding
            {
                event = {name, "Flooding stops in "+name, Str(getTime())};

                getContinent(name).stateFlooding = False;

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
