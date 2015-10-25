package voxterra.voxterra;

/**
 * Created by riley_000 on 2015-10-24.
 */
public class ShopItem {

    private String name;
    private String description;

    private long cost;
    private boolean unlocked;
    private boolean purchased;

    private ShopItem[] result_items;

    public ShopItem(String name, String description, long cost, boolean unlocked, ShopItem[] result_items){
        this.name           = name;
        this.description    = description;
        this.cost           = cost;
        this.unlocked       = unlocked;
        this.purchased      = false;
        this.result_items   = result_items;
    }

    public boolean isUnlocked(){
        return this.unlocked;
    }

    public void setUnlocked(boolean unlocked){
        this.unlocked = unlocked;
    }
}
