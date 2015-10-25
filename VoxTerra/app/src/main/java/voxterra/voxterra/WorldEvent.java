package voxterra.voxterra;

/**
 * Created by simon on 2015-10-24.
 */
public class WorldEvent extends NewsStream {

    public String location;
    public String headline;
    public int time;
    public eventType severity;

    public WorldEvent(String location, String headline, int time, eventType severity){
        this.location = location;
        this.headline = headline;
        this.time = time;
        this.severity = severity;
    }
}
