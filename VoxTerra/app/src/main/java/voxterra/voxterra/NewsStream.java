package voxterra.voxterra;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by simon on 2015-10-24.
 */
public class NewsStream {

    private boolean firstRun = true;

    private ArrayList<WorldEvent> eventHistory = new ArrayList<WorldEvent>();
    //private int eventCooldown = 0;


    /**
     * nothing: no popup (i.e. unimportant events w/o consequence)
     * announcement: popup with just an "ok" button
     * everything else: popup with different buttons representing responses to situation (all should also have an "ignore" option as well)
     *
     */
    public enum eventType{
        nothing,  announcement,
        oilspill, chemicalLeak, nuclearPowerPlantFailure, 
    }

    public ArrayList<WorldEvent> retrieveNews(){

        ArrayList<WorldEvent> recentNews = new ArrayList<WorldEvent>();

        WorldEvent event;  //location, description, time occurred

        if(firstRun)
        {
            event = new WorldEvent("Earth", "BY JOVE WE'VE DONE IT", 0, eventType.announcement);
            firstRun = false;
        }

        for (int i = 0;i < Sim.continentNames.length; i++)      //per-continent events
        {
            Continent selectedContinent = Sim.getContinent(Sim.continentNames[i]);
            String name = Sim.continentNames[i];
            if (selectedContinent.getMAX_WATER_LEVEL() < Sim.getCurrentWaterLevel()&& !selectedContinent.isFlooding(Sim.getCurrentWaterLevel()))  //Adds flooding
            {
                event = new WorldEvent(name, "Flooding occurs in "+name, Sim.getTime(), eventType.nothing);
                selectedContinent.isFlooding = true;
                recentNews.add(event);

            } else if(selectedContinent.getMAX_WATER_LEVEL() >= Sim.getCurrentWaterLevel()&& selectedContinent.isFlooding(Sim.getCurrentWaterLevel()))//removes flooding
            {
                event = new WorldEvent(name, "Flooding stops in "+name, Sim.getTime(), eventType.nothing);
                selectedContinent.isFlooding = false;
                recentNews.add(event);
            }

            if (selectedContinent.getFreshWater()<0.2 && !selectedContinent.isDrought)
            {
                event = WorldEvent(name, name + " experiences drough across the land", Sim.getTime(), eventType.nothing);
                selectedContinent.isDrought = true;
                recentNews.add(event);
            } else if(selectedContinent.getFreshWater()>=0.2 && selectedContinent.isDrought)
            {
                event = WorldEvent(name, name + "'s drought comes to an end", Sim.getTime(), eventType.nothing);
                selectedContinent.isDrought = false;
                recentNews.add(event);
            }

        }

        if(randInt(0, 19)==1){      //oilspill random disaster event
            event = {"Ocean", "ALERT: OILSPILL IN ", Str(Sim.getTime()), eventType.oilspill};
            recentNews.add(event);

            //if (pressed)
            eventResponse(event);
        }

        eventHistory.addAll(recentNews);
        return recentNews;
    }

    public int randInt(int Min, int Max){
        return Min + (int)(Math.random() * ((Max - Min) + 1));
    }


    /**
     * Call if player presses a high severity event
     *
     */
    public void eventResponse(WorldEvent event){

        switch (event.severity){

            case oilspill:
                //prompts action from player
                //lists options for player to choose (or ignore)
        }

    }
}
